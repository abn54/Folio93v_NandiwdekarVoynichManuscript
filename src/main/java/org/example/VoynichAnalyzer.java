/**
 * Project: Voynich Manuscript Analysis
 * Purpose Details: This program analyzes the Voynich Manuscript folio 93v, displaying the image
 * and providing frequency analysis of Latin letter occurrences. It also aims to decipher text from the manuscript
 * and compare letter frequencies with expected Latin frequencies.
 * Course: IST 242
 * Author: Aayudh Nandiwdekar
 * Date Developed: December 2024
 * Last Date Changed: December 2024
 * Revision: 1.0
 *
 * Sources:
 * - Image: "Folio 93v" of the Voynich Manuscript, obtained from the public domain.
 * - Latin Letter Frequency: Standard letter frequencies in the Latin alphabet.
 * - Voynich Manuscript image source: https://collections.library.yale.edu/catalog/2002046?child_oid=1006239
 * - Source on letter frequency analysis: Standard frequency analysis of Latin letters in cryptography.
 * - Information on Voynich Manuscript: "The Voynich Manuscript: The Mystery of the World's Most Famous Unsolved Book" by Gerry Kennedy and Rob Churchill.
 */

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class VoynichAnalyzer {

    public static void main(String[] args) {
        // Display image of the Voynich Manuscript folio 93v
        String imagePath = "src/resources/folio93v.jpg"; // Path to the image
        displayImage(imagePath);

        // Perform frequency analysis on the Voynich Manuscript text
        String text = "enter your extracted Voynich text here"; // Replace with extracted text from the image
        performFrequencyAnalysis(text);
    }

    /**
     * Method to display the image of the Voynich Manuscript.
     * @param imagePath the path to the image
     */
    public static void displayImage(String imagePath) {
        JFrame frame = new JFrame("Voynich Manuscript - Folio 93v");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the image
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel label = new JLabel(icon);

        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Method to perform frequency analysis on the extracted text from the Voynich Manuscript.
     * @param text the extracted text
     */
    public static void performFrequencyAnalysis(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int totalLetters = 0;

        // Convert text to lowercase to standardize for frequency analysis
        text = text.toLowerCase();

        // Count the frequency of each letter in the text
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
                totalLetters++;
            }
        }

        // Print frequency analysis of the Latin letters
        System.out.println("Frequency Analysis of Latin Letters in the text:");
        for (char c = 'a'; c <= 'z'; c++) {
            int occurrences = frequencyMap.getOrDefault(c, 0);
            double percentage = (occurrences / (double) totalLetters) * 100;
            System.out.printf("%c: %d occurrences (%.2f%%)\n", c, occurrences, percentage);
        }

        // Compare the observed frequencies with expected Latin letter frequencies
        compareWithLatinFrequencies(frequencyMap, totalLetters);
    }

    /**
     * Compares the frequency analysis of the Voynich Manuscript with standard Latin letter frequencies.
     * @param frequencyMap the map containing letter frequencies
     * @param totalLetters the total number of letters in the text
     */
    public static void compareWithLatinFrequencies(Map<Character, Integer> frequencyMap, int totalLetters) {
        double[] latinFrequencies = {8.17, 1.49, 2.78, 4.25, 12.70, 2.23, 2.02, 6.09, 6.97, 0.15, 0.77, 4.03, 2.41, 6.75, 7.51, 1.93, 0.10, 5.99, 6.33, 9.06, 2.76, 0.98, 2.36, 0.15, 1.97, 0.07};

        System.out.println("\nComparison with standard Latin letter frequencies:");

        for (char c = 'a'; c <= 'z'; c++) {
            int occurrences = frequencyMap.getOrDefault(c, 0);
            double percentage = (occurrences / (double) totalLetters) * 100;
            int index = c - 'a';
            double expectedPercentage = latinFrequencies[index];
            System.out.printf("%c: Expected %.2f%%, Found %.2f%%\n", c, expectedPercentage, percentage);
        }
    }
}
