package lab4;

import java.util.List;

/**
 * Demonstrates text parsing and sorting words by frequency of a target character.
 * <p>
 * Uses the full object-oriented text model (Text → Sentence → Word/Letter/Punctuation)
 * to parse a sample paragraph and sort words by count of the letter 'a' (case-insensitive).
 * </p>
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public class Main {

    /**
     * Program entry point.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        char targetChar = 'a';
        StringBuilder input  = new StringBuilder("""
                    A calm caravan traveled across a vast and radiant landscape. Ahead, a band of
                    nomads carried baskets and handmade crafts, walking at a steady pace. Far away,
                    a gentle guitar melody drifted across the warm air, creating a relaxed and
                    magical atmosphere. Around the camp area, several animals wandered lazily,
                    searching for snacks and patches of shade.
                """);

        System.out.println("Initial text:");
        System.out.println(input);

        Text text = TextParser.parse(input);

        List<Word> allWords = sortWordsByCharCount(text, targetChar);

        System.out.println("Sorted words:");
        for (int i = 0; i < allWords.size(); i++) {
            Word word = allWords.get(i);
            System.out.println(i + ") " + word + " -> " + word.countChar(targetChar));
        }
    }

    /**
     * Returns a list of all words sorted in ascending order by the number of occurrences
     * of the specified character (case-insensitive).
     * <p>
     * Uses Bubble Sort algorithm.
     * </p>
     *
     * @param text       the text to process
     * @param targetChar the character to count
     * @return sorted list of words
     */
    public static List<Word> sortWordsByCharCount(Text text, char targetChar) {
        List<Word> allWords = new java.util.ArrayList<>(text.getAllWords());

        // Bubble sort: ascending by count of targetChar
        for (int i = 0; i < allWords.size() - 1; i++) {
            for (int j = 0; j < allWords.size() - i - 1; j++) {
                if (allWords.get(j).countChar(targetChar) > allWords.get(j + 1).countChar(targetChar)) {
                    Word temp = allWords.get(j);
                    allWords.set(j, allWords.get(j + 1));
                    allWords.set(j + 1, temp);
                }
            }
        }

        return allWords;
    }
}