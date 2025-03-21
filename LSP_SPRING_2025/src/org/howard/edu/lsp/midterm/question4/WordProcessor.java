package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that processes sentences to find all longest words.
 */
public class WordProcessor {
    private String sentence;

    /**
     * Constructor initializes the sentence.
     * @param sentence The sentence to process.
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds and returns all longest words in the sentence.
     * @return List of longest words.
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();

        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords;
        }

        String[] words = sentence.trim().split("\\s+");
        int maxLength = 0;

        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        for (String word : words) {
            if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }
}
