import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class to sort a list of names
 */
public class NameSorter {

    // Logic to be used to sort the input list of names
    private Comparator<String> comparator;

    // Inject the sorting logic to initialise the class
    public NameSorter(Comparator<String> comparator) {
        this.comparator = comparator;
    }

    /**
     * Method to sort the input list of names as per logic injected during class instantiation
     * @param names input list of names
     */
    public void sort(List<String> names) {
        Collections.sort(names, comparator);
    }
}
