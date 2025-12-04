package lab2;

import java.util.ArrayList;

/**
 * A utility class that processes a text block, splits it into words, counts occurrences
 * of a specified character (case-insensitive), and sorts the words in ascending order
 * by the number of times that character appears in each word.
 *
 * <p>This class demonstrates basic text processing, custom word splitting, case-insensitive
 * character counting, and implementation of the Bubble Sort algorithm using {@link StringBuilder}
 * objects stored in an {@link ArrayList}.</p>
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public class StringProcessor {

    /**
     * Main method - demonstrates the functionality of the class.
     * <p>Uses the target character 'a', processes a multi-line text block,
     * prints the original text, then prints all extracted words sorted by
     * the number of 'a'/'A' occurrences (ascending), along with their counts.</p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        char targetChar = 'a';
        StringBuilder text = new StringBuilder("""
                    A calm caravan traveled across a vast and radiant landscape. Ahead, a band of
                    nomads carried baskets and handmade crafts, walking at a steady pace. Far away,
                    a gentle guitar melody drifted across the warm air, creating a relaxed and
                    magical atmosphere. Around the camp area, several animals wandered lazily,
                    searching for snacks and patches of shade.
                """);
        System.out.println("Initial text:\n" + text);

        ArrayList<StringBuilder> sortedWords = sortWordsByCharCount(text, targetChar);

        System.out.println("Sorted words:");
        for (int i = 0; i < sortedWords.size(); i++) {
            System.out.println(i + ") " + sortedWords.get(i).toString().trim()
                    + " -> " + countChar(sortedWords.get(i), targetChar));
        }
    }

    /**
     * Counts how many times the target character appears in the given word,
     * performing a <strong>case-insensitive</strong> comparison.
     *
     * @param word        the word (as a {@link StringBuilder}) to examine
     * @param targetChar  the character to count (e.g., 'a')
     * @return            the total number of occurrences of the character
     *                    (both lower-case and upper-case forms)
     */
    private static int countChar(StringBuilder word, char targetChar) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (current == Character.toLowerCase(targetChar) ||
                    current == Character.toUpperCase(targetChar)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Splits the input text into individual alphabetic words.
     * <p>Words are sequences of alphabetic characters only.
     * Non-alphabetic characters (spaces, punctuation, newlines, etc.) act as delimiters.
     * Empty sequences are ignored.</p>
     *
     * @param text the source text as a {@link StringBuilder}
     * @return an {@link ArrayList} containing one {@link StringBuilder} per extracted word
     */
    private static ArrayList<StringBuilder> splitIntoWords(StringBuilder text) {
        ArrayList<StringBuilder> words = new ArrayList<>();
        int wordStart = 0;

        for (int i = 1; i <= text.length(); i++) {
            boolean endOfText = (i == text.length());
            boolean currentIsNonAlpha = endOfText || !Character.isAlphabetic(text.charAt(i));
            boolean previousWasAlpha = Character.isAlphabetic(text.charAt(i - 1));

            if (currentIsNonAlpha && previousWasAlpha) {
                // End of a word detected
                if (i > wordStart) {
                    words.add(new StringBuilder(text.substring(wordStart, i)));
                }
                wordStart = i + 1; // skip the delimiter(s)
            }
        }
        return words;
    }

    /**
     * Extracts words from the given text, sorts them in <strong>ascending order</strong>
     * by the number of occurrences of {@code targetChar} (case-insensitive),
     * and returns the sorted list.
     *
     * <p>The sorting is performed using the Bubble Sort algorithm.
     * Words with fewer occurrences of the target character appear first.</p>
     *
     * @param text        the source text to process
     * @param targetChar  the character whose frequency determines the sort order
     * @return            an {@link ArrayList} of {@link StringBuilder} objects
     *                    containing the words sorted by increasing count of {@code targetChar}
     */
    public static ArrayList<StringBuilder> sortWordsByCharCount(StringBuilder text, char targetChar) {
        ArrayList<StringBuilder> words = splitIntoWords(text);

        // Bubble sort - ascending by count of targetChar
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = 0; j < words.size() - i - 1; j++) {
                if (countChar(words.get(j), targetChar) > countChar(words.get(j + 1), targetChar)) {
                    // Swap
                    StringBuilder temp = words.get(j);
                    words.set(j, words.get(j + 1));
                    words.set(j + 1, temp);
                }
            }
        }

        return words;
    }
}