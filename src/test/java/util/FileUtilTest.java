package util;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileUtilTest {

    private static final String INPUT_FILE = "src/test/resources/unsorted-names-list.txt";
    private static final String INVALID_FILE = "invalid";
    private static final String INVALID_PATH = "####.***";
    private static final String TEST_OUTPUT_FILE = "src/test/resources/test.txt";

    @Test
    void readSuccessTest() throws Exception {
        List<String> expected = new ArrayList<>();
        expected.add("Janet Parsons");
        expected.add("Vaughn Lewis");
        expected.add("Adonis Julius Archer");
        expected.add("Shelby Nathan Yoder");
        expected.add("Marin Alvarez");
        expected.add("London Lindsey");
        expected.add("Beau Tristan Bentley");
        expected.add("Leo Gardner");
        expected.add("Hunter Uriah Mathew Clarke");
        expected.add("Mikayla Lopez");
        expected.add("Frankie Conner Ritter");

        final List<String> names = FileUtil.read(INPUT_FILE);
        assertEquals(expected, names);
    }

    @Test
    void readExceptionTest() {
        assertThrows(IOException.class, () -> FileUtil.read(INVALID_FILE));
    }

    @Test
    void writeStringSuccessTest() throws Exception {
        // Clean up the test file to make sure file doesn't exist before the test
        deleteFile(TEST_OUTPUT_FILE);

        String testString = "test";
        FileUtil.write(TEST_OUTPUT_FILE, testString);

        List<String> result = FileUtil.read(TEST_OUTPUT_FILE);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(testString, result.get(0));

        deleteFile(TEST_OUTPUT_FILE);
    }

    @Test
    void writeStringExceptionTest() throws Exception {
        assertThrows(IOException.class, () -> FileUtil.write(INVALID_PATH, ""));
    }

    @Test
    void writeListSuccessTest() throws Exception {
        // Clean up the test file to make sure file doesn't exist before the test
        deleteFile(TEST_OUTPUT_FILE);

        List<String> testInput = new ArrayList<>();
        testInput.add("abc");
        testInput.add("xyz");

        FileUtil.write(TEST_OUTPUT_FILE, testInput);

        List<String> result = FileUtil.read(TEST_OUTPUT_FILE);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(testInput, result);

        deleteFile(TEST_OUTPUT_FILE);
    }

    @Test
    void writeListExceptionTest() throws Exception {
        assertThrows(IOException.class, () -> FileUtil.write(INVALID_PATH, Arrays.asList("abc", "xyz")));
    }

    private void deleteFile (String fileName) {
        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (IOException e) {
            // Do nothing
        }
    }
}
