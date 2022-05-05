package com.paderball.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Counter {
  private static Map<Character, Integer> getCharCounts(String text) {
    Map<Character, Integer> charToCount = new HashMap<>();

    if (text == null || text.length() == 0) {
      return charToCount;
    }

    for (int i = 0; i < text.length(); ++i) {
      char character = text.charAt(i);
      Integer count = charToCount.get(character);

      if (count == null) {
        charToCount.put(character, 1);
      } else {
        charToCount.put(character, count + 1);
      }
    }

    return charToCount;
  }

  private static List<Count> sortCharCounts(Map<Character, Integer> charToCount) {
    List<Count> sortedCounts = new ArrayList<>(charToCount.size());

    for (Entry<Character, Integer> entry : charToCount.entrySet()) {
      sortedCounts.add(new Count(entry.getKey(), entry.getValue()));
    }

    Collections.sort(sortedCounts);

    return sortedCounts;
  }

  private static String formatCharCounts(List<Count> charCounts) {
    StringBuilder builder = new StringBuilder();

    for (Count charCount : charCounts) {
      builder.append(charCount.getCharacter())
             .append(":    ")
             .append(charCount.getCount())
             .append("\n");
    }

    return builder.toString();
  }

  private static void display(String text, String formattedCounts) {
    System.out.println("Text: " + text);
    System.out.println(formattedCounts);
    System.out.println("=====================================================================================================================");
  }

  public static void main(String [] args) {
    for (String text : args) {
      Map<Character, Integer> charToCount = getCharCounts(text);
      List<Count> sortedCharCounts = sortCharCounts(charToCount);
      String formattedCounts = formatCharCounts(sortedCharCounts);
      display(text, formattedCounts);
    }
  }

  static class Count implements Comparable<Count> {
    private char character;
    private int count;

    public Count (char character, int count) {
      this.character = character;
      this.count = count;
    }

    public char getCharacter() {
      return character;
    }

    public int getCount() {
      return count;
    }

    @Override
    public int compareTo(Count o) {
      int countDiff = o.getCount() - count;
      if (countDiff != 0) {
        return countDiff;
      }

      return o.getCharacter() - character;
    }
  }
}
