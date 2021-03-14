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

        createClass();
        printTrainers();
        printStudents();
        printGroup();

    }

    private static void printTrainers() {
        System.out.println(trainers);

    }

    private static void printGroup() {
        System.out.println(groups);

    }

    private static void printStudents() {
        System.out.println(students);

    }

    private static void createClass() {

        Student student1 = new Student(" Olteanu ", "Alexandru ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student2 = new Student(" Draga ", "Sorin ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student3 = new Student(" Gradinaru ", "Traian ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student4 = new Student(" Lenter ", "Diana ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student5 = new Student(" Naghi ", "Andrea ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student6 = new Student(" Gheorghe ", "Dorina ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student7 = new Student(" Calin ", "Cornelia ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student8 = new Student(" Orza ", "Alexandra ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student9 = new Student(" Balan ", "Adrian ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student10 = new Student(" Torok ", "Szabi ", LocalDate.of(1988, Month.DECEMBER, 1), false);

        students = new HashSet<>();
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


        Set<Student> studentsRo16 = new HashSet<>();
        studentsRo16.add(student1);
        studentsRo16.add(student2);
        studentsRo16.add(student3);

        Set<Student> studentsRo17 = new HashSet<>();
        studentsRo17.add(student4);
        studentsRo17.add(student5);
        studentsRo17.add(student6);

        Set<Student> studentsRo18 = new HashSet<>();
        studentsRo18.add(student7);
        studentsRo18.add(student8);

        Set<Student> studentsRo19 = new HashSet<>();
        studentsRo19.add(student9);
        studentsRo19.add(student10);


        Trainer trainer1 = new Trainer(" Olteanu ", " Alexandru ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Trainer trainer2 = new Trainer(" Olteanu ", " Alexandru ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Trainer trainer3 = new Trainer(" Olteanu ", " Alexandru ", LocalDate.of(1988, Month.OCTOBER, 12), false);

        trainers = Arrays.asList(trainer1, trainer2, trainer3);


        Group javaRo16 = new Group(trainer1, studentsRo16);
        Group javaRo17 = new Group(trainer1, studentsRo17);
        Group javaRo18 = new Group(trainer3, studentsRo18);
        Group javaRo19 = new Group(trainer3, studentsRo19);

        groups = Arrays.asList(javaRo16, javaRo17, javaRo19, javaRo18);

    }
}


