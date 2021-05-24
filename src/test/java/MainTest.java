import org.junit.jupiter.api.Test;
import util.FileUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MainTest {

    private static final String INPUT_FILE = "src/test/resources/unsorted-names-list.txt";
    private static final String OUTPUT_FILE = "./sorted-names-list.txt";
    private static final String ERROR_FILE = "./errors.txt";
    private static final String INVALID_INPUT_FILE = "invalid";

    @Test
    void sortingSuccessTest() throws Exception {
        // Clean up the output file to make sure file doesn't exist before the test
        deleteFile(OUTPUT_FILE);

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

        Main.main(new String[]{INPUT_FILE});

        final List<String> result = FileUtil.read(OUTPUT_FILE);
        assertEquals(expected, result);

        deleteFile(OUTPUT_FILE);
    }

    @Test
    void inputFileNotSuppliedErrorTest() throws Exception {
        // Clean up the error file to make sure file doesn't exist before the test
        deleteFile(ERROR_FILE);

        Main.main(new String[] {});

        final List<String> result = FileUtil.read(ERROR_FILE);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Please provide a valid file name as an argument while running " +
                "the program.", result.get(0));

        deleteFile(ERROR_FILE);
    }

    @Test
    void invalidInputFileTest() throws Exception {
        // Clean up the error file to make sure file doesn't exist before the test
        deleteFile(ERROR_FILE);

        Main.main(new String[] {INVALID_INPUT_FILE});

        final List<String> result = FileUtil.read(ERROR_FILE);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Error while reading the file " + INVALID_INPUT_FILE, result.get(0));

        deleteFile(ERROR_FILE);
    }

    private void deleteFile (String fileName) {
        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (IOException e) {
            // Do nothing
        }
    }
}
