package lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a complete text composed of multiple {@link Sentence}s.
 * <p>
 * Provides access to all sentences and all words across the entire text.
 * </p>
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public class Text {
    /** List of sentences in the order they appear */
    private final List<Sentence> sentences = new ArrayList<>();

    /**
     * Adds a sentence to the end of this text.
     *
     * @param sentence the sentence to add
     */
    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    /**
     * Returns an unmodifiable list of all sentences in this text.
     *
     * @return list of {@link Sentence} objects
     */
    public List<Sentence> getSentences() {
        return Collections.unmodifiableList(sentences);
    }

    /**
     * Returns all words from all sentences in this text.
     *
     * @return a flat list of all {@link Word} objects in document order
     */
    public List<Word> getAllWords() {
        List<Word> allWords = new ArrayList<>();
        for (Sentence s : sentences) {
            allWords.addAll(s.getWords());
        }
        return allWords;
    }

    /**
     * Returns the full text as a single string.
     *
     * @return the reconstructed text with spaces between sentences
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.size(); i++) {
            sb.append(sentences.get(i));
            if (i < sentences.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}