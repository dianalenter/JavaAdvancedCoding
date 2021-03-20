import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulateClassTest {

    @Test
    void getAllMaxNumberOfStudentsFromGroup_classicMethod() {

        //Given
        List<Group> groups = new ArrayList<>();
        Student student1 = new Student(" Olteanu ", "Alexandru ", LocalDate.of(1988, Month.OCTOBER, 12), true);
        Student student2 = new Student(" Olteanu ", "Alexandru ", LocalDate.of(1988, Month.OCTOBER, 12), true);

        Set<Student> students = new LinkedHashSet<>();
        students.add(student1);
        students.add(student2);
        Group javaRo16 = new Group("JavaRo16", null, students);
        Group javaRo17 = new Group("JavaRo17", null, students);

        groups.add(javaRo16);
        groups.add(javaRo17);

        // When
        //SimulateTooLateClass.getAllMaxNumberOfStudentsFromGroup_classicMethod(groups);
        //Then
        assertEquals(2,SimulateTooLateClass.getAllMaxNumberOfStudentsFromGroup_classicMethod(groups).size());
    }

}
