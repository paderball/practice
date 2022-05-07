package com.paderball.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Counter {
  public static <T> Map<T, Integer> getCounts(List<T> data) {
    Map<T, Integer> charToCount = new HashMap<>();

    if (data == null || data.size() == 0) {
      return charToCount;
    }

    for (T datum : data) {
      Integer count = charToCount.get(datum);

      if (count == null) {
        charToCount.put(datum, 1);
      } else {
        charToCount.put(datum, count + 1);
      }
    }

    return charToCount;
  }

  public static <T extends Comparable<T>> List<Count<T>> sortCounts(Map<T, Integer> dataCounts) {
    List<Count<T>> sortedCounts = new ArrayList<>(dataCounts.size());

    for (Entry<T, Integer> entry : dataCounts.entrySet()) {
      sortedCounts.add(new Count<T>(entry.getKey(), entry.getValue()));
    }

    Collections.sort(sortedCounts);

    return sortedCounts;
  }

  public static <T extends Comparable<T>> String formatCharCounts(List<Count<T>> dataCounts) {
    StringBuilder builder = new StringBuilder();

    for (Count<T> count : dataCounts) {
      builder.append(count.getKey())
             .append(":    ")
             .append(count.getCount())
             .append("\n");
    }

    return builder.toString();
  }

  private static void display(String text, String formattedCounts) {
    System.out.println("Text: " + text);
    System.out.println(formattedCounts);
    System.out.println("=====================================================================================================================");
  }

  public static List<Character> stringToChars(String text) {
    ArrayList<Character> chars = new ArrayList<Character>(text.length());
    for (char character : text.toCharArray()) {
      chars.add(character);
    }

    return chars;
  }

  public static void main(String [] args) {
    for (String text : args) {
      List<Character> chars = stringToChars(text);
      Map<Character, Integer> charToCount = getCounts(chars);
      List<Count<Character>> sortedCharCounts = sortCounts(charToCount);
      String formattedCounts = formatCharCounts(sortedCharCounts);
      display(text, formattedCounts);
    }
  }

  static class Count<T extends Comparable<T>> implements Comparable<Count<T>> {
    private T key;
    private int count;

    public Count (T key, int count) {
      this.key = key;
      this.count = count;
    }

    public T getKey() {
      return key;
    }

    public int getCount() {
      return count;
    }

    @Override
    public int compareTo(Count<T> o) {
      int countDiff = o.getCount() - count;
      if (countDiff != 0) {
        return countDiff;
      }

      return key.compareTo(o.getKey());
    }
  }
}
