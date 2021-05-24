package comparators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LastNameGivenNamesComparatorTest {

    private LastNameGivenNamesComparator lastNameGivenNamesComparator = new LastNameGivenNamesComparator();

    @Test
    void firstParamLargerTest() {
        String name1 = "Adonis Julius Archer";
        String name2 = "Marin Alvarez";

        int result = lastNameGivenNamesComparator.compare(name1, name2);

        assertTrue(result > 0);
    }

    @Test
    void firstParamSmallerTest() {
        String name1 = "Marin Alvarez";
        String name2 = "Adonis Julius Archer";

        int result = lastNameGivenNamesComparator.compare(name1, name2);

        assertTrue(result < 0);
    }

    @Test
    void equalParamsTest() {
        String name1 = "Adonis Julius Archer";
        String name2 = "Adonis Julius Archer";

        int result = lastNameGivenNamesComparator.compare(name1, name2);

        assertEquals(0, result);
    }

    @Test
    void singleNameFirstParamTest() {
        String name1 = "Adonis";
        String name2 = "Adonis Julius Archer";

        int result = lastNameGivenNamesComparator.compare(name1, name2);

        assertTrue(result < 0);
    }

    @Test
    void singleNameSecondParamTest() {
        String name1 = "Adonis Julius Archer";
        String name2 = "Adonis";

        int result = lastNameGivenNamesComparator.compare(name1, name2);

        assertTrue(result > 0);
    }

    @Test
    void singleNameBothParamsTest() {
        String name1 = "Archer";
        String name2 = "Adonis";

        int result = lastNameGivenNamesComparator.compare(name1, name2);

        assertTrue(result > 0);
    }

    @Test
    void sameLastNameFirstParamShorterTest() {
        String name1 = "Julius Archer";
        String name2 = "Adonis Julius Archer";

        int result = lastNameGivenNamesComparator.compare(name1, name2);

        assertTrue(result > 0);
    }

    @Test
    void sameLastNameFirstParamLongerTest() {
        String name1 = "Adonis Julius Archer";
        String name2 = "Julius Archer";

        int result = lastNameGivenNamesComparator.compare(name1, name2);

        assertTrue(result < 0);
    }

    @Test
    void commonSubstringFirstParamLongerTest() {
        String name1 = "Adonis Julius Archer Archer";
        String name2 = "Adonis Julius Archer";

        int result = lastNameGivenNamesComparator.compare(name1, name2);

        assertTrue(result > 0);
    }

    @Test
    void commonSubstringSecondParamLongerTest() {
        String name1 = "Adonis Julius Archer";
        String name2 = "Adonis Julius Archer Archer";

        int result = lastNameGivenNamesComparator.compare(name1, name2);

        assertTrue(result < 0);
    }
}
