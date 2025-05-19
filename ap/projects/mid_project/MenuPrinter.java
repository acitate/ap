package ap.projects.mid_project;

public class MenuPrinter {

    public void initialMenu() {
        System.out.print("\n-----------------------------------\n"+
                         "1. Manager\n"+
                         "2. Student\n"+
                         "3. Operator\n"+
                         "0. quit\n"+
                         "-----------------------------------\n"+
                         "Choice: ");
    }

    public void studentMenu(Student logged) {
        System.out.println("\nLogged in as " + logged);
        System.out.print("-----------------------------------\n"+
                         "1. Search book\n"+
                         "2. Request to borrow a book\n"+
                         "3. Request to return a book\n"+
                         "4. List borrowed books\n"+
                         "0. quit\n"+
                         "-----------------------------------\n"+
                         "Choice: ");
    }

    public void managerMenu(Manager manager) {
        System.out.println("\n\t" + manager);
        System.out.print("-----------------------------------\n"+
                         "1. Add operator\n"+
                         "2. Show operators\n"+
                         "3. List offtime books\n"+
                         "0. quit\n"+
                         "-----------------------------------\n"+
                         "Choice: ");
    }

    public void studentLoginMenu() {
        System.out.print("-----------------------------------\n"+
                         "1. Login\n"+
                         "2. SignUp\n"+
                         "0. quit\n"+
                         "-----------------------------------\n"+
                         "Choice: ");
    }

    public void operatorLoginMenu() {
        System.out.print("-----------------------------------\n"+
                         "1. Login\n"+
                         "0. quit\n"+
                         "-----------------------------------\n"+
                         "Choice: ");
    }

    public void operatorMenu(Operator operator) {
        System.out.println("\nOperating as " + operator);
        System.out.print("-----------------------------------\n"+
                         "1. Change perosnal info\n"+
                         "2. Add book\n"+
                         "3. Confirm request\n"+
                         "0. quit\n"+
                         "-----------------------------------\n"+
                         "Choice: ");
    }
}
