import comparators.LastNameGivenNamesComparator;
import util.FileUtil;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger("Main.class");
    private static final String ERROR_FILE = "./errors.txt";
    private static final String FILE_NAME_ERROR = "Please provide a valid file name as an argument while " +
            "running the program.";
    private static final String FILE_READ_ERROR = "Error while reading the file %s";
    private static final String FILE_WRITE_ERROR = "Error while writing to file %s";
    private static final String OUTPUT_FILE = "./sorted-names-list.txt";

    public static void main(String args[]) {
        // If no input file name is supplied while executing the program then add the
        // error message to a file "errors.txt" in the same directory from where the program
        // is executed
        if (args == null || args.length != 1) {
            try {
                FileUtil.write(ERROR_FILE, FILE_NAME_ERROR);
            } catch (IOException e) {
                // If there is a problem while writing error message to errors.txt file
                // then simply log the error message
                logger.log(Level.SEVERE, String.format(FILE_WRITE_ERROR, e.getMessage()));
                logger.log(Level.SEVERE, FILE_NAME_ERROR);
            }

            return;
        }

        try {
            List<String> names = FileUtil.read(args[0]);
            NameSorter nameSorter = new NameSorter(new LastNameGivenNamesComparator());
            nameSorter.sort(names);
            try {
                FileUtil.write(OUTPUT_FILE, names);
            } catch (IOException e) {
                logger.log(Level.SEVERE, String.format(FILE_WRITE_ERROR, e.getMessage()));
            }
        } catch (IOException e) {
            // If there is an error while reading the input file then write the error message
            // to errors.txt file or to logs (if unable to write to errors.txt file)
            try {
                FileUtil.write(ERROR_FILE, String.format(FILE_READ_ERROR, e.getMessage()));
            } catch (IOException ex) {
                logger.log(Level.SEVERE, String.format(FILE_WRITE_ERROR, ex.getMessage()));
                logger.log(Level.SEVERE, String.format(FILE_READ_ERROR, ex.getMessage()));
            }

            return;
        }
    }
}
