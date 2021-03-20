import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

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

    //VARARGS
    private static String getLongestString(String... longestStringArray) {
        //  int maxLength = 0;
        String auxString = "";
//        for (String element : longestStringArray) {
//            if (element.length() > maxLength) {
//                maxLength = element.length();
//                auxString = element;
//            } sau, am mai scapat de 2 linii de cod
        for (String element : longestStringArray) {
            if (element.length() > auxString.length()) {
                auxString = element;
            }
        }
        return auxString;
    }

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
        getNumberOfStudentsFromGroup_classicMethod();
        getAllMaxNumberOfStudentsFromGroup_classicMethod(groups);
        displayGroupWithMaxNumOfStudent_FunctionalMethod();
        displayGroupWithMinNumOfStudent_FunctionalMethod();
        studentsYoungerThan(25);
        displayStudentsYoungerThan(25);
        System.out.println(displayStudentsYoungerThan1(25));
        System.out.println(displayStudentsYoungerThan2(23));
        studentsGroupedByTrainer_WithGroups();

        studentsGroupedByTrainer_WithMAp(); //Functioneaza daca nu fac modificari in grupuri

        //-----------------------------------

        displayStudentsWithPreviousJavaKnowledge();
        displayStudentsWithPreviousJavaKnowledge1();

        dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge();


        removeStudentsYoungerThanFromGroups(25);

        printStudentsAlphabeticallyByFirstName();
        dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge4();
        dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge2();
        dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge3();
        System.out.println("Triple : " + tripleNumberOfStudentsFromMaxGroup(getAllMaxNumberOfStudentsFromGroup_classicMethod(groups)));
        System.out.println("cuvantul cu dimensiunea cea mai mare este  : " + getLongestString("Diana", "Liviu", "Leah"));//VARARGS: nputem scrie si fara paramatrii dar nu ne afiseaza nimic
    }

    private static void printTrainers() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista de trainers: ");
        System.out.println(trainers);

    }

    private static void printGroup() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista de grupe: ");
        System.out.println(groups);

    }

    private static void printStudents() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista de studenti: ");
        System.out.println(students);

    }

    private static void printstudentAlfabetically() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista studentilor sortata dupa firstName: ");
        students.stream()
                .sorted(Comparator.comparing(Student::getLastName))
                .forEach(System.out::println);

//        students.stream()
//                .sorted(Comparator.comparing(student -> student.getLastName()))
//                .forEach(student -> System.out.println(student);
    }

    private static void printStudentsAlphabeticallyByFirstName() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista studentilor sortata dupa firstName: ");
        students.stream()
                .sorted(Comparator.comparing(student -> student.getFirstName()))
                .forEach(student -> System.out.print(student + " "));
    }


    private static void getNumberOfStudentsFromGroup_classicMethod() {
        System.out.println("\n-----------------------------------");
        System.out.print("Grupele cu maxim numar de studenti (classic method_1): ");
        Group aux = new Group(null, null, new LinkedHashSet<>());
        for (Group group : groups) {
            if (group.getListOfStudents().size() > aux.getListOfStudents().size()) {  //>= ca sa arate daca au mai multe grupe acelasi nr de studenti
                aux = group;
            }
        }
        System.out.println("max group size " + aux);
    }

    public static List<Group> getAllMaxNumberOfStudentsFromGroup_classicMethod(List<Group>groupList) {
        System.out.println("\n-----------------------------------");
        List<Group> groupsMax = new ArrayList<>();
        Group aux = new Group(null, null, new LinkedHashSet<>());

        for (Group group : groupList) {
            if (group.getListOfStudents().size() > aux.getListOfStudents().size()) {
                aux = group;
                groupsMax = new ArrayList<>();
                groupsMax.add(group);
            } else if (group.getListOfStudents().size() == aux.getListOfStudents().size()) {
                groupsMax.add(group);
            }
        }
        // System.out.println("list of maximum list" + groupsMax);
        return groupsMax;
    }

    //...variable arguments, putem folosi atunci cand este ultimul paramatru din lista de parametrii, se foloseste cand e lista sau singur element
    private static int multiplyingNumberOfStudentsFromMaxGroup(int numberOfTimes, List<Group> maxGroup) {

        return maxGroup.size() * maxGroup.get(0).getListOfStudents().size() * numberOfTimes;
    }

    private static int tripleNumberOfStudentsFromMaxGroup(List<Group> maxGroup) {

        return multiplyingNumberOfStudentsFromMaxGroup(3, maxGroup);
    }

    private static void displayGroupWithMaxNumOfStudent_FunctionalMethod() {
        //functional method
        System.out.println("\n-----------------------------------");
        System.out.print("Grupele cu maxim numar de studenti (functional method): ");
        groups.stream()
                .filter(g -> g.getListOfStudents().size() ==
                        groups.stream()
                                .max(Comparator.comparingInt(g1 -> g1.getListOfStudents().size())).get().getListOfStudents().size())
                // .max((g1,g2) -> Integer.compare(g1.getListOfStudents().size(),g2.getListOfStudents().size()))
                //   .get().getListOfStudents().size())

                //Altfel (sortat in ordine crescatoare si luat primul element ca max):
                // groups.stream()
                //      .sorted((g1,g2) -> Integer.compare(g2.getListOfStudents().size(),g1.getListOfStudents().size()))
                //      .findFirst().get().getListOfStudents().size())

                //.forEach(g -> System.out.println(g));
                .forEach(System.out::println);
    }

    private static void displayGroupWithMinNumOfStudent_FunctionalMethod() {
        //functional method
        System.out.println("\n-----------------------------------");
        System.out.print("Grupele cu minim numar de studenti (functional method): ");
        groups.stream()
                .filter(g -> g.getListOfStudents().size() ==
                        groups.stream()
                                .min(Comparator.comparingInt(g1 -> g1.getListOfStudents().size())).get().getListOfStudents().size())
                // .map(Group::getNameOfGroup)       //va lista doar numele grupelor(daca decomentez linia aceasta)
                .forEach(System.out::println);
    }

    private static void studentsYoungerThan(int age) {
        System.out.println("\n-----------------------------------");
        System.out.print("\nLista studentilor mai tineri decat " + age + " ani : ");
        students.stream()
                .filter(student ->
                        Period.between(student.getDateOfBirth(), LocalDate.now()).getYears() < age)
                .forEach(student -> System.out.print(student));
    }

    //void
    private static void displayStudentsYoungerThan(int age) {
        System.out.println("\n-----------------------------------");
        System.out.print("\nLista studentilor mai tineri decat " + age + " ani : ");
        students.parallelStream()  //eficientizeaza daca ai mai multe elemente, creeaza mai multe treduri
                .filter(student -> student.getAge() < age)
                .forEach(student -> System.out.print(student));

    }

    //List
    private static List<Student> displayStudentsYoungerThan1(int age) {
        System.out.println("\n-----------------------------------");
        System.out.print("\nLista studentilor mai tineri decat " + age + " ani : ");
        return students.stream()
                .filter(student -> student.getAge() < age)
                .collect(Collectors.toList());
    }

    private static List<String> displayStudentsYoungerThan2(int age) {
        System.out.println("\n-----------------------------------");
        System.out.print("\nLista studentilor mai tineri decat " + age + " ani : ");
        return students.stream()
                .filter(student -> student.getAge() < age)
                .map(student -> student.getFirstName())                     //map => student transforma student in getfirstname
                .collect(Collectors.toList());
    }

    private static void studentsGroupedByTrainer_WithGroups() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista studentilor grupat dupa traineri: ");
        for (Trainer trainer : trainers) {
            System.out.print("\n" + trainer.getFirstName() + "'s students: ");
            for (Group group : groups) {
                if (trainer.equals(group.getTrainer())) {
                    for (Student student : group.getListOfStudents()) {
                        System.out.print(student);
                    }
                }
            }
        }
    }

    private static void studentsGroupedByTrainer_WithMAp() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista studentilor grupat dupa traineri: ");
        for (Trainer trainer : trainers) {
            System.out.print("\n" + trainer.getFirstName() + "'s students: ");
            for (Map.Entry<Student, Trainer> mapElement : Group.getStudentTrainerMap().entrySet()) {
                if (trainer.equals(mapElement.getValue())) {
                    System.out.print("  " + mapElement.getKey().toString());
                }
            }
        }
    }

    private static void displayStudentsWithPreviousJavaKnowledge1() {
        System.out.println("********StudentsWithPreviousJavaKnowledge****");
        students.stream()
                .filter(student -> (student != null && student.isHasPreviousJavaKnowledge() == true))
                //.filter(student -> (method1() & method2()) chiar daca prima returneaza false se executa a doua  cu "&"
                .forEach(System.out::println);
    }

    private static void displayStudentsWithPreviousJavaKnowledge() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista studentilor care au cunostinte Java: ");
        for (Student student : students) {
            if (student.isHasPreviousJavaKnowledge())
                System.out.print(student);
        }
    }

    private static void dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge() {
        System.out.println("\n-----------------------------------");

        int[] arrayOfNumStudents = new int[groups.size()];
        for (int gIndex = 0; gIndex < groups.size(); gIndex++) {
            for (Student student : groups.get(gIndex).getListOfStudents()) {
                if (!student.isHasPreviousJavaKnowledge()) {
                    arrayOfNumStudents[gIndex]++;
                }
            }
        }
        int maxNum = 0;
        int maxIndex = 0;
        for (int i = 0; i < arrayOfNumStudents.length; i++) {
            if (maxNum < arrayOfNumStudents[i]) {
                maxNum = arrayOfNumStudents[i];
                maxIndex = i;
            }
        }
        System.out.print("Grupa cu cei mai multi studenti care nu au cunostinte Java: " + groups.get(maxIndex));
    }

    private static void removeStudentsYoungerThanFromGroups(int age) {
        System.out.println("\n-----------------------------------");


        for (Group group : groups) {
            //     Group auxGroup = new Group(null, null, null);
            Set<Student> auxStudentList = new HashSet<>();
            for (Student student : group.getListOfStudents()) {
                if (Period.between(student.getDateOfBirth(), LocalDate.now()).getYears() >= age) {
                    auxStudentList.add(student);
                }
            }
            group.setListOfStudents(auxStudentList);
        }
        System.out.print("\nLista grupelor dupa stergerea studentilor mai tineri decat " + age + " ani : " + groups);
    }

    private static void dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge2() {
        System.out.println("\n-----------------2------------------");
        //afiseaza primul grup (chiar daca sunt mai multe cu acelasi numar de studenti fara cunostinte)
        System.out.print("Grupa cu cei mai multi studenti care nu au cunostinte Java: " +
                groups.stream()
                        .max(Comparator.comparing(g ->
                                g.getListOfStudents().stream()
                                        .filter(st -> st.isHasPreviousJavaKnowledge() == false)
                                        .count()))
                        .get()
                        .toString()
        );
    }

    private static void dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge3() {
        System.out.println("\n-----------------3------------------");
        System.out.print("Grupa cu cei mai multi studenti care nu au cunostinte Java: ");
        groups.stream()
                .filter(group -> group.getListOfStudents().stream()
                        .filter(st -> !st.isHasPreviousJavaKnowledge())
                        .count() ==
                        groups.stream()
                                .max(Comparator.comparing(g ->
                                        g.getListOfStudents().stream()
                                                .filter(st -> !st.isHasPreviousJavaKnowledge())
                                                .count()))
                                .get().getListOfStudents().stream()
                                .filter(student -> !student.isHasPreviousJavaKnowledge())
                                .count()
                )
                .forEach(group -> System.out.println(group));
    }

    private static void dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge4() {
        System.out.println("\n-----------------4------------------");
        //Am facut un getter in clasa Group care numara studentii fara cunostinte Java
        System.out.print("Grupa cu cei mai multi studenti care nu au cunostinte Java: ");
        groups.stream()
                .filter(group -> group.getNumOfStudentsWithNoPrevJavaKnow() == groups.stream()
                        .max(Comparator.comparing(group1 -> group1.getNumOfStudentsWithNoPrevJavaKnow()))
                        .get().getNumOfStudentsWithNoPrevJavaKnow()
                )
                .forEach(group -> System.out.println(group));
    }


    private static void createClass() {

        addStudents();      //ctrl+click
        addTrainers();
        addGroups();

        //JavaRo19.setTrainer(trainer3); - pana nu  schimbam pe private trainer
        // List<Person> personList = new ArrayList<>();
    }

    private static void addGroups() {
        javaRo16 = new Group("JavaRo16", trainer1, studentsRo16);
        javaRo17 = new Group("JavaRo17", trainer1, studentsRo17);
        javaRo18 = new Group("JavaRo18", trainer3, studentsRo18);
        javaRo19 = new Group("JavaRo19", null, studentsRo19);

        groups = Arrays.asList(javaRo16, javaRo17, javaRo19, javaRo18);
    }

    private static void addTrainers() {
        trainer1 = new Trainer(" Olteanu ", " Alexandru ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        trainer2 = new Trainer(" Olteanu ", " Alexandru ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        trainer3 = new Trainer(" Olteanu ", " Alexandru ", LocalDate.of(1988, Month.OCTOBER, 12), false);

        trainers = Arrays.asList(trainer1, trainer2, trainer3);
    }

    private static void addStudents() {
        Student student1 = new Student(" Olteanu ", "Alexandru ", LocalDate.of(1988, Month.OCTOBER, 12), true);
        Student student2 = new Student(" Draga ", "Sorin ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student3 = new Student(" Gradinaru ", "Traian ", LocalDate.of(2000, Month.OCTOBER, 12), false);
        Student student4 = new Student(" Lenter ", "Diana ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student5 = new Student(" Naghi ", "Andrea ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student6 = new Student(" Gheorghe ", "Dorina ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student7 = new Student(" Calin ", "Cornelia ", LocalDate.of(1990, Month.OCTOBER, 12), false);
        Student student8 = new Student(" Orza ", "Alexandra ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student9 = new Student(" Balan ", "Adrian ", LocalDate.of(1988, Month.OCTOBER, 12), false);
        Student student10 = new Student(" Torok ", "Szabi ", LocalDate.of(1988, Month.DECEMBER, 1), false);

        students = new LinkedHashSet<>();
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


        studentsRo16 = new LinkedHashSet<>();
        studentsRo16.add(student1);
        studentsRo16.add(student2);
        studentsRo16.add(student3);

        studentsRo17 = new LinkedHashSet<>();
        studentsRo17.add(student4);
        studentsRo17.add(student5);
        studentsRo17.add(student6);

        studentsRo18 = new LinkedHashSet<>();
        studentsRo18.add(student7);
        studentsRo18.add(student8);

        studentsRo19 = new LinkedHashSet<>();
        studentsRo19.add(student9);
        studentsRo19.add(student10);
    }
}


