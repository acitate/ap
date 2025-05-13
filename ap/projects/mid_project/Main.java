package ap.projects.mid_project;

public class Main {
    static Library library;


    public static void main(String[] args) {
        String path = "/home/parsa/Projects/java/ap_eyd/ap/ap/exercises/library/files/";
        FileHandler handler = new FileHandler();
        MenuPrinter menu;
        InputHandler input = new InputHandler();
        int choice;

        if (handler.fileExists()) {
            library = handler.loadFromFile();
        } else {
            library = new Library();
            library.setName("Amirkabir2");
            library.setManager(new Manager("AmirMohammadius", "karimi", "PhD"));
            library.addOperator(new Operator("Darioush", "dosty", "04648946"));
            library.addOperator(new Operator("Mona", "emami", "09848949"));
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
            choice = input.takeChoice(2);

            switch (choice) {
                case 0:
                    return;

                case 1:
                    String name = input.takeAlphabeticString("Name: ");
                    String last_name = input.takeAlphabeticString("Last Name: ");
                    String id = input.takeNumericString("EmployeeID: ");

                    library.addOperator((new Operator(name, last_name, id)));
                    break;

                case 2:
//                    System.out.println(library.getOperators());
                    System.out.println();
                    for (Operator ope : library.getOperators()) {
                        System.out.println(ope);
                    }
                    break;
            }
        }
    }

    public static void studentLoop(InputHandler input, MenuPrinter menu, int choice) {
        boolean isLogged = false;
        Student logged = null;

        while (true) {

            if (isLogged) {
                menu.studentMenu(logged);
                choice = input.takeChoice(3);

                switch (choice) {
                    case 1:
                        String query = input.takeString("Query: ");
                        System.out.println(library.searchBook(query));

                        break;

                    case 0:
                        return;
                }
            } else {
                menu.studentLoginMenu();
                choice = input.takeChoice(3);

                switch (choice) {
                    case 1:
                        String stu_id = input.takeNumericString("Enter student ID: ");
                        final String id = stu_id;
                        int index = library.Exists(library.getStudents(), s -> s.getStudentID().equals(id));

                        while (!(index >= 0)) {
                            stu_id = input.takeNumericString("Student not found, try again: ");
                        }
                        isLogged = true;
                        logged = library.getStudent(stu_id);
                        break;

                    case 2:
                        String name = input.takeAlphabeticString("Enter first name: ");
                        String last_name = input.takeAlphabeticString("Enter last name: ");
                        String major = input.takeAlphabeticString("Enter major: ");
                        stu_id = input.takeNumericString("Student ID: ");

                        library.addStudent(new Student(name, last_name, major, stu_id));
                        isLogged = true;
                        logged = library.getStudent(stu_id);
                        break;

                    case 0:
                        return;
                }
            }
        }
    }

    public static void operatorLoop(InputHandler input, MenuPrinter menu, int choice) {
        boolean isLogged = false;
        Operator logged = null;
        int index = -1;

        while (true) {

            if (isLogged) {
                menu.operatorMenu(logged);
                choice = input.takeChoice(3);

                switch (choice) {
                    case 1:
                        // assuming "change personal info" means changing his own information.
                    String temp = input.takeString("Change first name: ");
                    String name = (temp.length() <= 1) ? logged.getFirstName() : temp;
                    temp = input.takeString("Change last name: ");
                    String last_name = (temp.length() <= 1) ? logged.getLastName() : temp;

                    logged = new Operator(name, last_name, logged.getEmployeeID());
                    library.changeOperator(index, logged);
                    break;

                    case 2:
                        name = input.takeString("Enter name of book: ");
                        String author = input.takeString("Enter name of author: ");
                        String year = input.takeNumericString("Enter year of publication: ");
                        int pages = input.takeInt("Enter page: ");

                        library.addBook(new Book(name, author, year, pages));
                        break;

                    case 0:
                        return;

                }


            } else {
                menu.operatorLoginMenu();
                choice = input.takeChoice(2);

                switch (choice) {
                    case 1:
                        String emp_id = input.takeNumericString("Enter employee ID: ");
                        final String id = emp_id;
                        index = library.Exists(library.getOperators(), s -> s.getEmployeeID().equals(id));

                        while (!(index >= 0)) {
                            emp_id = input.takeNumericString("Student not found, try again: ");
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

                        library.addStudent(new Student(name, last_name, major, emp_id));

                        index = library.Exists(library.getOperators(), s -> s.getEmployeeID().equals(id_));
                        isLogged = true;
                        logged = library.getOperator(emp_id);
                        break;

                    case 0:
                        return;
                }
            }
        }
    }
}
