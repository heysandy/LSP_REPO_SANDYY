package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a processor that finds the longest word(s) in a sentence.
 */
public class WordProcessor {
    private String sentence; // Stores the sentence to be processed

    /**
     * Constructor for WordProcessor class.
     * @param sentence input sentence
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all longest words in the sentence, maintaining original order and without duplicates.
     * @return List of longest words, or empty list if sentence is empty.
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords; // return empty list for empty or null input
        }

        String[] words = sentence.trim().split("\\s+"); // handles multiple spaces
        int maxLength = 0;

        // First pass to find the maximum word length
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        // Second pass to add longest words to the result (no duplicates)
        for (String word : words) {
            if (word.length() == maxLength && !longestWords.contains(word)) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }
}
