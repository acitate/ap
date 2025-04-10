package ap.exercises.ex3;

public class Main_EX3_LM_1_3 {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("Artorias", "Dinu", "8925116", "Civil Engineering");
        students[1] = new Student("Gervasio", "Hadjieva", "6154556", "Dental Medicine");
        students[2] = new Student("Gyneth", "Maxentius", "2493848", "Roman History");
        System.out.println(searchStudent(students, "Gyneth Maxentius"));
    }

    static int searchStudent(Student[] students,String name) {
        int index = 0;

        for (int i = 0; i < students.length; i++) {
            String n = students[i].getFirstName() +" "+ students[i].getLastName();

            if (name.equals(n)) {
                index = i;
                break;
            } else {
                index = -1;
            }
        }
        return index;
    }
}
