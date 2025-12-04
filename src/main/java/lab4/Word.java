package lab4;

/**
 * Represents a word composed of individual {@link Letter} objects.
 * <p>
 * This class provides methods to access the word's content and count occurrences
 * of a specific character (case-insensitive).
 * </p>
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public class Word {
    /** Array of letters that make up this word */
    private final Letter[] letters;

    /**
     * Constructs a word from an array of letters.
     *
     * @param letters the sequence of letters forming the word
     */
    public Word(Letter[] letters) {
        this.letters = letters.clone(); // defensive copy
    }

    /**
     * Returns a copy of the internal letter array.
     *
     * @return array of {@link Letter} objects
     */
    public Letter[] getLetters() {
        return letters.clone();
    }

    /**
     * Returns the number of letters in this word.
     *
     * @return the length of the word
     */
    public int length() {
        return letters.length;
    }

    /**
     * Returns the character at the specified position.
     *
     * @param index the position of the character
     * @return the character at the given index
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public char charAt(int index) {
        return letters[index].getValue();
    }

    /**
     * Counts how many times the target character appears in this word (case-insensitive).
     *
     * @param targetChar the character to count (e.g., 'a')
     * @return the total number of occurrences of the character (both cases)
     */
    public int countChar(char targetChar) {
        int count = 0;
        char lower = Character.toLowerCase(targetChar);
        char upper = Character.toUpperCase(targetChar);
        for (Letter letter : letters) {
            char ch = letter.getValue();
            if (ch == lower || ch == upper) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the string representation of this word.
     *
     * @return the word as a string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(letters.length);
        for (Letter l : letters) {
            sb.append(l.getValue());
        }
        return sb.toString();
    }
}