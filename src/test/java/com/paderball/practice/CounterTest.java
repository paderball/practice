package com.paderball.practice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

public class CounterTest {

  @Test
  public void getCharCountsWithNull() {
    Map<Character, Integer> charCounts = Counter.getCharCounts(null);

    assertNotNull("Null argument should return an empty Map", charCounts);
    assertEquals("Null argument should return an empty Map", 0, charCounts.size());
  }

  @Test
  public void getCharCountsWithEmptyString() {
    Map<Character, Integer> charCounts = Counter.getCharCounts("");

    assertNotNull("Empty String argument should return an empty Map", charCounts);
    assertEquals("Empty String argument should return an empty Map", 0, charCounts.size());
  }

  @Test
  public void getCharCountsWithAlphabet() {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    Map<Character, Integer> charCounts = Counter.getCharCounts(alphabet);

    assertNotNull(charCounts);
    assertEquals(26, charCounts.size());
    for (int i = 0; i < alphabet.length(); ++i) {
      assertEquals("Missing " + alphabet.charAt(i), 1, charCounts.get(alphabet.charAt(i)).intValue());
    }
  }

  @Test
  public void getCharCountsWithText() {
    Map<Character, Integer> charCounts = Counter.getCharCounts("theretheirthey're");

    assertNotNull(charCounts);
    assertEquals(7, charCounts.size());
    assertEquals(5, charCounts.get('e').intValue());
    assertEquals(3, charCounts.get('h').intValue());
    assertEquals(1, charCounts.get('i').intValue());
    assertEquals(3, charCounts.get('r').intValue());
    assertEquals(3, charCounts.get('t').intValue());
    assertEquals(1, charCounts.get('y').intValue());
    assertEquals(1, charCounts.get('\'').intValue());
  }

}
