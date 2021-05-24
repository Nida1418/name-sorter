import comparators.LastNameGivenNamesComparator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameSorterTest {

    private NameSorter nameSorter = new NameSorter(new LastNameGivenNamesComparator());

    @Test
    void sortSampleListTest() {
        List<String> names = new ArrayList<>();
        names.add("Janet Parsons");
        names.add("Vaughn Lewis");
        names.add("Adonis Julius Archer");
        names.add("Shelby Nathan Yoder");
        names.add("Marin Alvarez");
        names.add("London Lindsey");
        names.add("Beau Tristan Bentley");
        names.add("Leo Gardner");
        names.add("Hunter Uriah Mathew Clarke");
        names.add("Mikayla Lopez");
        names.add("Frankie Conner Ritter");

        List<String> expected = new ArrayList<>();
        expected.add("Marin Alvarez");
        expected.add("Adonis Julius Archer");
        expected.add("Beau Tristan Bentley");
        expected.add("Hunter Uriah Mathew Clarke");
        expected.add("Leo Gardner");
        expected.add("Vaughn Lewis");
        expected.add("London Lindsey");
        expected.add("Mikayla Lopez");
        expected.add("Janet Parsons");
        expected.add("Frankie Conner Ritter");
        expected.add("Shelby Nathan Yoder");

        nameSorter.sort(names);

        assertEquals(expected, names);
    }
}
