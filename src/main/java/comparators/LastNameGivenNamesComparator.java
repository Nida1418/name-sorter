package comparators;

import java.util.Comparator;

/**
 * An implementation of comparator to compare two names as follows:
 * - first compare last name, if they are not equal then return result
 * - if last name are equal then compare all given names one by one from beginning
 * and return the result
 * - Ignore case while comparing
 */
public class LastNameGivenNamesComparator implements Comparator<String> {

    // Assuming the name string contains space separated components
    private static final String SPLITTER = " ";

    public int compare(String name1, String name2) {
        String[] name1Arr = name1.trim().split(SPLITTER);
        String[] name2Arr = name2.trim().split(SPLITTER);

        if (name1Arr[name1Arr.length - 1].compareToIgnoreCase(name2Arr[name2Arr.length - 1]) != 0) {
            // If last names are not equal return the result of their comparison
            return name1Arr[name1Arr.length - 1].compareToIgnoreCase(name2Arr[name2Arr.length - 1]);
        }

        // If last names are equal then run the comparison on all given names
        // Loop through the given names of shorter name to avoid index out of bounds exception
        if (name1Arr.length <= name2Arr.length) {
            for (int i = 0; i < name1Arr.length; i++) {
                if (name1Arr[i].compareToIgnoreCase(name2Arr[i]) != 0) {
                    // If the given name component is not equal then return the result of comparison
                    return name1Arr[i].compareToIgnoreCase(name2Arr[i]);
                }
            }
        } else {
            for (int i = 0; i < name2Arr.length; i++) {
                if (name1Arr[i].compareToIgnoreCase(name2Arr[i]) != 0) {
                    return name1Arr[i].compareToIgnoreCase(name2Arr[i]);
                }
            }
        }

        // If both names have same number of given and last names and all of them are equal
        // then both names are actually same (equal)
        if (name1Arr.length == name2Arr.length) {
            return 0;
        }

        // If second name is substring of first then first name should appear
        // after the second during sorting
        if (name1Arr.length > name2Arr.length) {
            return 1;
        }

        // If first name is substring of second then second name should appear
        // after the first during sorting
        return -1;
    }
}
