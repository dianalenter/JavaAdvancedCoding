import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Group {
    //  private String nameOfGroup;  - nu mai e nevoie sa-i dau nume, deoarece
    // cand instantiez grupul ii dau nume
    // (Group grupaRO16 = new Group(name: groupRO16, trainer, lista de studenti)
    private final String nameOfGroup;
    private Trainer trainer;
    private Set<Student> listOfStudents;
    private static final  Map<Student, Trainer> studentTrainerMap = new HashMap<>();

    public Group(String nameOfGroup, Trainer trainer, Set<Student> listOfStudents) {
        this.nameOfGroup = nameOfGroup;
        this.trainer = trainer;
        if (listOfStudents.size() <= 5) {
            this.listOfStudents = listOfStudents;
        } else {
            throw new MaximumNumberOfStudentsReached("Students limit exceeded");
        }

        for (Student student : listOfStudents) {
            studentTrainerMap.put(student, trainer);
        }
    }

//    public Group(Trainer trainer, Set<Student> listOfStudents) {
//        this.trainer = trainer;
//        if (listOfStudents.size() <= 5) {
//            this.listOfStudents = listOfStudents;
//        } else {
//            throw new MaximumNumberOfStudentsReached("Students limit exceeded");
//        }
//    }

    public static void printMap() {
        for (Map.Entry<Student, Trainer> entry : studentTrainerMap.entrySet()) {
            Student key = entry.getKey();
            Trainer value = entry.getValue();

            System.out.printf("%s %s", key, value);
        }
    }

    public static Map<Student, Trainer> getStudentTrainerMap() {
        return studentTrainerMap;
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public Set<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setListOfStudents(Set<Student> listOfStudents) {
        if (listOfStudents.size() <= 5) {
            this.listOfStudents = listOfStudents;
        } else {
            throw new MaximumNumberOfStudentsReached("Students limit exceeded");
        }
    }

    public int getNumOfStudentsWithNoPrevJavaKnow() {
        int count = 0;
        for (Student student : listOfStudents) {
            if (!student.isHasPreviousJavaKnowledge()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "\nGroup " + nameOfGroup + "{\n" +
                "   trainer=" + trainer +
                "\n   listOfStudents=" + listOfStudents +
                "}";
    }


}
