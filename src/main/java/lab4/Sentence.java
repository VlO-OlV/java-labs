package lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a sentence as a sequence of {@link Word}s and {@link PunctuationMark}s.
 * <p>
 * Elements are stored in the order they appear in the original text.
 * </p>
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public class Sentence {
    /** Ordered list of sentence elements (Word or PunctuationMark) */
    private final List<Object> elements = new ArrayList<>();

    /**
     * Adds a word or punctuation mark to the end of this sentence.
     *
     * @param element either a {@link Word} or {@link PunctuationMark}
     */
    public void addElement(Object element) {
        if (!(element instanceof Word || element instanceof PunctuationMark)) {
            throw new IllegalArgumentException("Only Word and PunctuationMark can be added");
        }
        elements.add(element);
    }

    /**
     * Returns an unmodifiable view of all elements in this sentence.
     *
     * @return list of elements in order
     */
    public List<Object> getElements() {
        return Collections.unmodifiableList(elements);
    }

    /**
     * Returns all words contained in this sentence.
     *
     * @return list of {@link Word} objects in this sentence
     */
    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Object el : elements) {
            if (el instanceof Word) {
                words.add((Word) el);
            }
        }
        return words;
    }

    /**
     * Returns the string representation of this sentence.
     *
     * @return the sentence text with all elements concatenated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object el : elements) {
            sb.append(el.toString());
        }
        return sb.toString();
    }
}