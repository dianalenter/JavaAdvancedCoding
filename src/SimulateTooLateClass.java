import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class SimulateTooLateClass {
    public static void main(String[] args) {

//        System.out.println("First name is: " + student1.getFirstName() + " "
//                + "Last name is: " + student1.getLastName() + " "
//                + "Birth date is: " + student1.getDateOfBirth() + " "
//                + "And the java knowledge is: " + student1.isHasPreviousJavaKnowledge());
        createClass();

    }

    private static void createClass() {
        Student student1 = new Student("Diana", "Lenter", LocalDate.of(1989, Month.MAY, 06), true);
        System.out.println(student1);
        Student student2 = new Student("Di", "Lenter", LocalDate.of(1989, Month.MAY, 06), true);
        Student student3 = new Student("Dia", "Lenter", LocalDate.of(1989, Month.MAY, 06), true);
        Student student4 = new Student("Dian", "Lenter", LocalDate.of(1989, Month.MAY, 06), false);
        Student student5 = new Student("Dianna", "Lenter", LocalDate.of(1989, Month.MAY, 06), true);
        Student student6 = new Student("Dianaa", "Lenter", LocalDate.of(1989, Month.MAY, 06), false);
        Student student7 = new Student("Diannaa", "Lenter", LocalDate.of(1989, Month.MAY, 06), true);
        Student student8 = new Student("Diiana", "Lenter", LocalDate.of(1989, Month.MAY, 06), true);
        Student student9 = new Student("Diaana", "Lenter", LocalDate.of(1989, Month.MAY, 06), false);
        Student student10 = new Student("Diaiana", "Lenter", LocalDate.of(1989, Month.MAY, 06), false);

        List<Student> studentsRo16 = Arrays.asList(student1, student2, student3);
        List<Student> studentsRo17 = Arrays.asList(student4, student5);
        List<Student> studentsRo18 = Arrays.asList(student6, student7);
        List<Student> studentsRo19 = Arrays.asList(student8,student9,student10);

        Trainer trainer1 = new Trainer("Di", "Lenter", LocalDate.of(1989, Month.MAY, 06), true);
        Trainer trainer2 = new Trainer("Di", "Lenter", LocalDate.of(1989, Month.MAY, 06), true);
        Trainer trainer3 = new Trainer("Di", "Lenter", LocalDate.of(1989, Month.MAY, 06), true);
        System.out.println(trainer1);

        Group JavaRo16 = new Group(trainer1, studentsRo16);
        Group JavaRo17 = new Group(trainer2, studentsRo17);
        Group JavaRo18 = new Group(trainer3, studentsRo18);
        Group JavaRo19 = new Group(null, studentsRo19);
        JavaRo19.setTrainer(trainer3);
    }
}
