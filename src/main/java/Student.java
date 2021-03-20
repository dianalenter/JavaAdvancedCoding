import java.time.LocalDate;

public class Student extends Person {
    boolean hasPreviousJavaKnowledge;


    public Student(String firstName, String lastName, LocalDate dateOfBirth, boolean hasPreviousJavaKnowledge) {
        super(firstName, lastName, dateOfBirth);
        this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;
    }

    public boolean isHasPreviousJavaKnowledge() {
        return hasPreviousJavaKnowledge;
    }

    public void setHasPreviousJavaKnowledge(boolean hasPreviousJavaKnowledge) {
        this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;
    }

    public String getLastName() {
        return super.getLastName();
    }
    public String getFirstName(){
        return super.getFirstName();
    }

    public int getAge(){
        return LocalDate.now().getYear() - super.getDateOfBirth().getYear();
    }

    public LocalDate getDateOfBirth(){
        return super.getDateOfBirth();
    }

    @Override
    public String toString() {
        return super.toString() +
                "hasPreviousJavaKnowledge = " + hasPreviousJavaKnowledge +
                '}';
    }
}
