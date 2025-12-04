package lab4;

/**
 * An immutable wrapper for a single punctuation mark or whitespace character.
 * <p>
 * This class is used to represent any non-alphabetic character in the text,
 * including spaces, commas, periods, etc.
 * </p>
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public class PunctuationMark {
    /** The punctuation or whitespace character */
    private final char mark;

    /**
     * Constructs a new punctuation mark.
     *
     * @param mark the non-alphabetic character
     * @throws IllegalArgumentException if the character is alphabetic
     */
    public PunctuationMark(char mark) {
        if (Character.isAlphabetic(mark)) {
            throw new IllegalArgumentException("Incorrect punctuation mark");
        }
        this.mark = mark;
    }

    /**
     * Returns the punctuation character.
     *
     * @return the stored non-alphabetic character
     */
    public char getMark() {
        return mark;
    }

    /**
     * Returns a string representation of this punctuation mark.
     *
     * @return a one-character string containing the mark
     */
    @Override
    public String toString() {
        return String.valueOf(mark);
    }
}