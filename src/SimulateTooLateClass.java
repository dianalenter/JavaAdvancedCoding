import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class SimulateTooLateClass {
    private static Set<Student> students;
    private static List<Trainer> trainers;
    private static List<Group> groups;
    private static Set<Student> studentsRo16;
    private static Set<Student> studentsRo17;
    private static Set<Student> studentsRo18;
    private static Set<Student> studentsRo19;
    private static Trainer trainer1, trainer2, trainer3;
    private static Group javaRo16, javaRo17, javaRo18, javaRo19;

    public static void main(String[] args) {
        //        System.out.println("First name is: " + student1.getFirstName() + " "
//                + "Last name is: " + student1.getLastName() + " "
//                + "Birth date is: " + student1.getDateOfBirth() + " "
//                + "And the java knowledge is: " + student1.isHasPreviousJavaKnowledge());

        createClass();     //ctrl+click
        printTrainers();
        printStudents();
        printGroup();
        printstudentAlfabetically();

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

    private static void printstudentAlfabetically() {
        students.stream()
                .sorted(Comparator.comparing(student -> student.getLastName()))
                .forEach(student -> System.out.println(student));
    }

    private static void createClass() {

        addStudents();      //ctrl+click
        addTrainers();
        addGroups();

    }

    private static void addGroups() {
        javaRo16 = new Group(trainer1, studentsRo16);
        javaRo17 = new Group(trainer1, studentsRo17);
        javaRo18 = new Group(trainer3, studentsRo18);
        javaRo19 = new Group(trainer3, studentsRo19);

        groups = Arrays.asList(javaRo16, javaRo17, javaRo19, javaRo18);
    }

    private static void addTrainers() {
        trainer1 = new Trainer(" Olteanu ", " Alexandru ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        trainer2 = new Trainer(" Olteanu ", " Alexandru ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        trainer3 = new Trainer(" Olteanu ", " Alexandru ", LocalDate.of(1988, Month.OCTOBER, 12), false);

        trainers = Arrays.asList(trainer1, trainer2, trainer3);
    }

    private static void addStudents() {
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


        studentsRo16 = new HashSet<>();
        studentsRo16.add(student1);
        studentsRo16.add(student2);
        studentsRo16.add(student3);

        studentsRo17 = new HashSet<>();
        studentsRo17.add(student4);
        studentsRo17.add(student5);
        studentsRo17.add(student6);

        studentsRo18 = new HashSet<>();
        studentsRo18.add(student7);
        studentsRo18.add(student8);

        studentsRo19 = new HashSet<>();
        studentsRo19.add(student9);
        studentsRo19.add(student10);
    }
}


