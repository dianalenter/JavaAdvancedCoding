import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimulateTooLateClass {

    private static Set<Student> students;
    private static List<Trainer> trainers;
    private static List<Group> groups;


    public static void main(String[] args) {
//        System.out.println("First name is: " + student1.getFirstName() + " "
//                + "Last name is: " + student1.getLastName() + " "
//                + "Birth date is: " + student1.getDateOfBirth() + " "
//                + "And the java knowledge is: " + student1.isHasPreviousJavaKnowledge());
        createClassroom();
        printTrainers();
        printGroups();
        printStudents();
    }

    private static void printStudents() {
        System.out.println("Students: ");
        System.out.println(students);
    }

    private static void printTrainers() {
        System.out.println("Trainers: ");
        System.out.println(trainers);
    }

    private static void printGroups() {
        System.out.println("Groups: ");
        System.out.println(groups);
    }

    private static void createClassroom() {
        //Students
        Student student1 = new Student("Andrei", "Manea1", LocalDate.of(1997, Month.SEPTEMBER, 19), true);
        Student student2 = new Student("student2", "Ulcior", LocalDate.of(1997, Month.SEPTEMBER, 19), true);
        Student student3 = new Student("student3", "Prosop", LocalDate.of(1997, Month.SEPTEMBER, 19), true);
        Student student4 = new Student("student4", "Cana", LocalDate.of(1997, Month.SEPTEMBER, 19), true);
        Student student5 = new Student("student5", "Cini", LocalDate.of(1997, Month.SEPTEMBER, 19), true);
        Student student6 = new Student("student6", "Mini", LocalDate.of(1997, Month.SEPTEMBER, 19), true);
        Student student7 = new Student("student7", "Ini", LocalDate.of(1997, Month.SEPTEMBER, 19), true);
        Student student8 = new Student("student8", "Popa", LocalDate.of(1997, Month.SEPTEMBER, 19), true);
        Student student9 = new Student("student9", "Pian", LocalDate.of(1997, Month.SEPTEMBER, 19), true);
        Student student10 = new Student("student10", "Geana", LocalDate.of(1997, Month.SEPTEMBER, 19), true);

        students = new HashSet<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        students.add(student10);

        Set<Student> students1 = new HashSet<Student>();
        students1.add(student1);
        students1.add(student2);
        students1.add(student3);

        Set<Student> students2 = new HashSet<Student>();
        students2.add(student4);
        students2.add(student5);
        students2.add(student6);

        Set<Student> students3 = new HashSet<Student>();
        students3.add(student7);
        students3.add(student8);

        Set<Student> students4 = new HashSet<Student>();
        students4.add(student9);
        students4.add(student10);

        //Trainers
        Trainer trainer1 = new Trainer("trainer1", "Ceapa", LocalDate.of(1997, Month.SEPTEMBER, 19), true);
        Trainer trainer2 = new Trainer("trainer2", "Capra", LocalDate.of(1997, Month.SEPTEMBER, 19), true);
        Trainer trainer3 = new Trainer("trainer3", "Oala", LocalDate.of(1997, Month.SEPTEMBER, 19), true);
        System.out.println(trainer1);

        trainers = Arrays.asList(trainer1, trainer2, trainer3);

        //Groups
        Group group1 = new Group(trainer1, students1);
        Group group2 = new Group(trainer2, students2);
        Group group3 = new Group(trainer1, students3);
        Group group4 = new Group(trainer3, students4);

        groups = Arrays.asList(group1, group2, group3, group4);
        System.out.println(group1);

    }
}

