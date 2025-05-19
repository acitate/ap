package ap.projects.mid_project;

import java.security.SecureRandom;

public class Main {
    static Library library;


    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        InputHandler input = new InputHandler();
        MenuPrinter menu;
        int choice;

        if (handler.fileExists()) {
            library = handler.loadFromFile();
        } else {
            library = new Library();
            library.setName("Amirkabir2");
            library.setManager(new Manager("Amir", "karimi", "PhD"));
            String temp = idGen();
            library.addOperator(temp, new Operator("Darioush", "dosty", temp));
            temp = idGen();
            library.addOperator(temp, new Operator("Mona", "emami", temp));
        }
        menu = new MenuPrinter();

        while (true) {
            menu.initialMenu();
            choice = input.takeChoice(3);

            switch (choice) {
                case 0:
                    handler.setLibrary(library);
                    handler.saveToFile();
                    return;

                case 1:
                    managerLoop(input, menu, choice);
                    break;

                case 2:
                   studentLoop(input, menu, choice);
                   break;

                case 3:
                    operatorLoop(input, menu, choice);
                    break;
            }
        }
    }

    public static void managerLoop(InputHandler input, MenuPrinter menu, int choice) {
        while (true) {
            menu.managerMenu(library.getManager());
            choice = input.takeChoice(3);

            switch (choice) {
                case 0:
                    return;

                case 1: {
                    String name = input.takeAlphabeticString("Name: ");
                    String last_name = input.takeAlphabeticString("Last Name: ");
                    String id = idGen();

                    library.addOperator(id, new Operator(name, last_name, id));
                    break;
                }

                case 2: {
//                    System.out.println(library.getOperators());
                    System.out.println();
                    for (Operator ope : library.getOperators().values()) {
                        System.out.println(ope);
                    }
                    break;
                }

                case 3: {
                    for (BorrowedBook borrowedBook : library.getOfftime()) {
                        System.out.println(borrowedBook);
                    }
                }
            }
        }
    }

    public static void studentLoop(InputHandler input, MenuPrinter menu, int choice) {
        boolean isLogged = false;
        Student logged = null;

        while (true) {

            if (isLogged) {
                menu.studentMenu(logged);
                choice = input.takeChoice(5);

                switch (choice) {
                    case 1: {
                        String query = input.takeString("Query: ");
                        for (Book book : library.searchBook(query)) {
                            System.out.println(book);
                        }

                        break;
                    }

                    case 2: {
                        for (String book_id : library.getBooks().keySet()) {
                            System.out.print("id: " + book_id + " ; " + library.getBooks().get(book_id) + "\n");
                        }

                        String id = input.takeNumericString("Enter id of desired book: ");
                        if (id.equals("-1")) {
                            break;
                        }
                        while (!library.getBooks().containsKey(id) && !id.equals("-1")) {
                            id = input.takeNumericString("Invalid id, try again: ");
                        }
                        if (id.equals("-1")) {
                            break;
                        }

                        library.addRequest(id, new Request(library.getBooks().get(id), logged, RequestType.BORROW));

                        break;
                    }

                    case 3: {
                        for (String book_id : library.getBorrowed().keySet()) {
                            System.out.print("id: " + book_id + " ; " + library.getBorrowed().get(book_id) + "\n");
                        }

                        String id = input.takeNumericString("Enter id of book to return: ");
                        if (id.equals("-1")) {
                            break;
                        }
                        while (!(library.getBorrowed().containsKey(id)) && !id.equals("-1")) {
                            id = input.takeNumericString("Invalid id, try again: ");
                        }
                        if (id.equals("-1")) {
                            break;
                        }

                        library.addRequest(id, new Request(library.getBorrowed().get(id).getBook(), logged, RequestType.RETURN));

                        break;
                    }

                    case 4: {
                        for (BorrowedBook borrowed_book : library.getBorrowed().values()) {
                            if (borrowed_book.getBorrower().getStudentID().equals(logged.getStudentID())) {
                                System.out.println(borrowed_book);
                            }
                        }

                        break;
                    }

                    case 0:
                        return;
                }
            } else {
                menu.studentLoginMenu();
                choice = input.takeChoice(3);

                switch (choice) {
                    case 1: {
                        String stu_id = input.takeNumericString("Enter student ID: ");
                        if (stu_id.equals("-1")) {
                            break;
                        }
//                        int index = library.Exists(library.getStudents().values(), s -> s.);
//
//                        while (!(index >= 0)) {
//                            stu_id = input.takeNumericString("Student not found, try again: ");
//                        }
                        while (!library.getStudents().containsKey(stu_id) && !stu_id.equals("-1")) {
                            stu_id = input.takeNumericString("Try again: ");
                        }
                        if (stu_id.equals("-1")) {
                            break;
                        }
                        isLogged = true;
                        logged = library.getStudent(stu_id);

                        break;
                    }

                    case 2: {
                        String name = input.takeAlphabeticString("Enter first name: ");
                        String last_name = input.takeAlphabeticString("Enter last name: ");
                        String major = input.takeAlphabeticString("Enter major: ");
                        String stu_id = idGen();

                        library.addStudent(stu_id, new Student(name, last_name, major, stu_id));
                        isLogged = true;
                        logged = library.getStudent(stu_id);

                        break;
                    }

                    case 0:
                        return;
                }
            }
        }
    }

    public static void operatorLoop(InputHandler input, MenuPrinter menu, int choice) {
        boolean isLogged = false;
        Operator logged = null;
        String current_id = "";

        while (true) {

            if (isLogged) {
                menu.operatorMenu(logged);
                choice = input.takeChoice(4);

                switch (choice) {
                    case 1: {
                        // assuming "change personal info" means changing his own information.
                        String temp = input.takeString("Change first name: ");
                        String name = (temp.length() <= 1) ? logged.getFirstName() : temp;
                        temp = input.takeString("Change last name: ");
                        String last_name = (temp.length() <= 1) ? logged.getLastName() : temp;

                        logged = new Operator(name, last_name, logged.getEmployeeID());
                        library.changeOperator(current_id, logged);

                        break;
                    }

                    case 2: {
                        String name = input.takeString("Enter name of book: ");
                        String author = input.takeString("Enter name of author: ");
                        String year = input.takeNumericString("Enter year of publication: ");
                        String id = idGen();
                        int pages = input.takeInt("Enter page: ");

                        library.addBook(id, new Book(name, author, year, pages, id));

                        break;
                    }

                    case 3: {
                        for (String id : library.getRequests().keySet()) {
                            System.out.println("id: " + id + " ; " + library.getRequests().get(id));
                        }

                        String id = input.takeNumericString("Enter id of request: ");
                        if (id.equals("-1")) {
                            break;
                        }

                        while (!(library.getRequests().containsKey(id)) && !id.equals("-1")) {
                            id = input.takeNumericString("Invalid input, try again: ");
                        }
                        if (id.equals("-1")) {
                            break;
                        }
                        Request req = library.getRequests().get(id);

                        switch (req.getType()) {
                            case BORROW -> {
                                library.borrowBook(id, req, logged);
                                logged.borrow_requests++;
                            }

                            case RETURN -> {
//                                library.removeBorrowed(id);
//                                library.addBook(idGen(), req.getBook());
                                library.returnBook(id, req.getBook());
                                logged.return_requests++;
                            }
                        }

                        break;

                    }


                    case 0:
                        return;

                }


            } else {
                menu.operatorLoginMenu();
                choice = input.takeChoice(2);

                switch (choice) {
                    case 1:
                        String emp_id = input.takeNumericString("Enter employee ID: ");
                        if (emp_id.equals("-1")) {
                            break;
                        }
                        while (!(library.getOperators().containsKey(emp_id))) {
                            emp_id = input.takeNumericString("Employee not found, try again: ");
                        }
                        if (emp_id.equals("-1")) {
                            break;
                        }
                        isLogged = true;
                        logged = library.getOperator(emp_id);
                        break;

                    case 2:
                        String name = input.takeAlphabeticString("Enter first name: ");
                        String last_name = input.takeAlphabeticString("Enter last name: ");
                        String major = input.takeAlphabeticString("Enter major: ");
                        emp_id = input.takeNumericString("Student ID: ");
                        final String id_ = emp_id;

//                        library.addStudent(new Student(name, last_name, major, emp_id));

//                        current_id = library.Exists(library.getOperators().values(), s -> s.getEmployeeID().equals(id_));
                        isLogged = true;
                        logged = library.getOperator(emp_id);
                        break;

                    case 0:
                        return;
                }
            }
        }
    }

    public static String idGen() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {
            sb.append(secureRandom.nextInt(10));
        }

        return sb.toString();
    }
}
