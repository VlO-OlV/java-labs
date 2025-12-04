package lab4;

/**
 * Utility class for parsing a {@link StringBuilder} into a structured {@link Text} object.
 * <p>
 * The parser recognizes words (sequences of alphabetic characters) and punctuation marks,
 * properly handling sentence boundaries (., !, ?).
 * </p>
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public class TextParser {

    /**
     * Parses the input text into a {@link Text} object containing sentences,
     * words, and punctuation marks.
     *
     * @param sb the source text
     * @return a fully structured {@link Text} representation
     */
    public static Text parse(StringBuilder sb) {
        Text text = new Text();
        Sentence currentSentence = new Sentence();

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);

            // Skip whitespace but preserve single spaces as punctuation
            if (Character.isWhitespace(c)) {
                if (i + 1 < sb.length() && !Character.isWhitespace(sb.charAt(i + 1))) {
                    currentSentence.addElement(new PunctuationMark(' '));
                }
                continue;
            }

            if (!Character.isAlphabetic(c)) {
                currentSentence.addElement(new PunctuationMark(c));

                // Sentence-ending punctuation
                if (c == '.' || c == '!' || c == '?') {
                    text.addSentence(currentSentence);
                    currentSentence = new Sentence();
                }
            } else {
                // Start of a new word
                java.util.List<Letter> letters = new java.util.ArrayList<>();
                letters.add(new Letter(c));

                // Consume consecutive alphabetic characters
                while (i + 1 < sb.length() &&
                        !Character.isWhitespace(sb.charAt(i + 1)) &&
                        Character.isAlphabetic(sb.charAt(i + 1))) {
                    i++;
                    letters.add(new Letter(sb.charAt(i)));
                }

                Word word = new Word(letters.toArray(new Letter[0]));
                currentSentence.addElement(word);
            }
        }

        // Add the last sentence if not empty
        if (!currentSentence.getElements().isEmpty()) {
            text.addSentence(currentSentence);
        }

        return text;
    }
}