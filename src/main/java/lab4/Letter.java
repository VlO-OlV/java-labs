package lab4;

/**
 * An immutable wrapper for a single alphabetic character.
 * <p>
 * This class ensures that only valid letters (as defined by {@link Character#isAlphabetic})
 * can be stored. It is used as a building block for the {@link Word} class.
 * </p>
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public class Letter {
    /** The alphabetic character represented by this object */
    private final char value;

    /**
     * Constructs a new Letter with the specified character.
     *
     * @param value the alphabetic character
     * @throws IllegalArgumentException if the character is not alphabetic
     */
    public Letter(char value) {
        if (!Character.isAlphabetic(value)) {
            throw new IllegalArgumentException("Incorrect letter value");
        }
        this.value = value;
    }

    /**
     * Returns the character value of this letter.
     *
     * @return the stored alphabetic character
     */
    public char getValue() {
        return value;
    }

    /**
     * Returns a string representation of this letter (the character itself).
     *
     * @return a one-character string containing the letter
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}