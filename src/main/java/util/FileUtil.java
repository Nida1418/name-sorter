package util;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Utility class for reading and writing files
 */
public class FileUtil {

    public static List<String> read(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    /**
     * Method to write a string to a file
     * @param fileName name of the file to write to
     * @param content string to write in the file
     * @throws IOException
     */
    public static void write(String fileName, String content) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content + System.lineSeparator());
        }
    }

    /**
     * Method to write a list of string to a file, with each string written in a new line
     * @param fileName name of the file to write to
     * @param names list of names to be written to the file
     * @throws IOException
     */
    public static void write(String fileName, List<String> names) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String name : names) {
                writer.write(name + System.lineSeparator());
            }
        }
    }
}
