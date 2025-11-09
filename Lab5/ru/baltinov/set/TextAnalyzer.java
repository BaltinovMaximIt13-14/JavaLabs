package ru.baltinov.set;

import java.util.HashSet;
import java.util.Set;

public class TextAnalyzer {
  private String text;

  public TextAnalyzer(String text) {
    this.text = text;
  }

  public int countUniqueLetters() {
    Set<Character> uniqueLetters = new HashSet<>();
    for (char c : text.toCharArray()) {
      if (Character.isLetter(c)) {
        uniqueLetters.add(Character.toLowerCase(c));
      }
    }
    return uniqueLetters.size();
  }
}
