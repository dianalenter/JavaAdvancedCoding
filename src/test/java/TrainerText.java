import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainerText {

    @Test
    public void verifyIsAuthorizedTrainer() {
        //Given
        Trainer trainer = new Trainer(null, null, null, true);

        //When
        //boolean authorized = trainer.isAuthorized();

        //Then
       // Assertions.assertTrue(trainer.isAuthorized());
        assertTrue(trainer.isAuthorized());
    }
}
