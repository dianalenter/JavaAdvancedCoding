import java.time.LocalDate;

public class Trainer extends Person {
    boolean isAuthorized;

    public Trainer(String firstName, String lastName, LocalDate dateOfBirth, boolean isAuthorized) {
        super(firstName, lastName, dateOfBirth);
        this.isAuthorized = isAuthorized;
    }

    @Override
    public String toString() {
        return super.toString() +
                "isAuthorized=" + isAuthorized +
                '}';
    }
}
