package com.paderball.practice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CounterTest {

  @Test
  public void getCharCountsWithNull() {
    Map<Character, Integer> charCounts = Counter.getCounts(null);

    assertNotNull("Null argument should return an empty Map", charCounts);
    assertEquals("Null argument should return an empty Map", 0, charCounts.size());
  }

  @Test
  public void getCharCountsWithEmptyData() {
    Map<Character, Integer> charCounts = Counter.getCounts(new ArrayList<Character>());

    assertNotNull("Empty String argument should return an empty Map", charCounts);
    assertEquals("Empty String argument should return an empty Map", 0, charCounts.size());
  }

  @Test
  public void getCharCountsWithAlphabet() {
    List<Character> chars = Counter.stringToChars("abcdefghijklmnopqrstuvwxyz");
    Map<Character, Integer> charCounts = Counter.getCounts(chars);

    assertNotNull(charCounts);
    assertEquals(26, charCounts.size());
    for (Character character : chars) {
      assertEquals("Missing " + character, 1, charCounts.get(character).intValue());
    }
  }

  @Test
  public void getCharCountsWithText() {
    List<Character> chars = Counter.stringToChars("theretheirthey're");
    Map<Character, Integer> charCounts = Counter.getCounts(chars);

    assertNotNull(charCounts);
    assertEquals(7, charCounts.size());
    assertEquals(Integer.valueOf(5), charCounts.get('e'));
    assertEquals(Integer.valueOf(3), charCounts.get('h'));
    assertEquals(Integer.valueOf(1), charCounts.get('i'));
    assertEquals(Integer.valueOf(3), charCounts.get('r'));
    assertEquals(Integer.valueOf(3), charCounts.get('t'));
    assertEquals(Integer.valueOf(1), charCounts.get('y'));
    assertEquals(Integer.valueOf(1), charCounts.get('\''));
  }

  @Test
  public void getCharCountsWithIntegers() {
    List<Integer> integers = Arrays.asList(new Integer[] {1, 1, 2, 2, 3, 3});
    Map<Integer, Integer> counts = Counter.getCounts(integers);

    assertNotNull(counts);
    assertEquals(3, counts.size());
    assertEquals(Integer.valueOf(2), counts.get(1));
    assertEquals(Integer.valueOf(2), counts.get(2));
    assertEquals(Integer.valueOf(2), counts.get(3));
  }

  @Test
  public void getCharCountsWithStrings() {
    List<String> strings = Arrays.asList(new String[] {"hi", "hello", "world", "hi", "bye", "underworld", "bye"});
    Map<String, Integer> counts = Counter.getCounts(strings);

    assertNotNull(counts);
    assertEquals(5, counts.size());
    assertEquals(Integer.valueOf(2), counts.get("hi"));
    assertEquals(Integer.valueOf(1), counts.get("hello"));
    assertEquals(Integer.valueOf(1), counts.get("world"));
    assertEquals(Integer.valueOf(2), counts.get("bye"));
    assertEquals(Integer.valueOf(1), counts.get("underworld"));
  }
}
