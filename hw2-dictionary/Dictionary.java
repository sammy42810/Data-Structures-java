//Samantha Bryan
//I pledge my honor that I have abided by the Stevens Honor System

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {

  /**
   * Dictionary class has two arraylist attributes.
   * dictArrayList: stores DictionaryItem objects that are consisted of word-count pair
   * wordList: stores word part of the DictionaryItem for quick check if word exists in the dictionary.
   * dictArrayList uses the index of wordlist to locate the word in dictArrayList.
   */
  private ArrayList<DictionaryItem> dictArrayList = new ArrayList<>(100);
  private ArrayList<String> wordList = new ArrayList<>(100);

  /**
   * Constructor for Dictionary class.
   */
  public Dictionary(){
    dictArrayList = new ArrayList<>(1300);
    wordList = new ArrayList<>(1300);
  }

  /**
   * A boolean method that adds a word to the dictionary by adding the word to the wordList
   * and adding a dictionary item to dictArrayList to store both word and count.
   * @param item
   * @return Returns true to indicate success
   */
  public boolean addWordToDictionary(DictionaryItem item) {
    String word = item.getWord();
    int count = item.getCount();
    if (hasWord(word)) {
      int index = wordList.indexOf(word);
      dictArrayList.get(index).setCount(dictArrayList.get(index).getCount() + count);
    } else {
      wordList.add(word);
      dictArrayList.add(new DictionaryItem(word, count));
    }
    return true;
  }

  /**
   * Checks if a word is in the wordList
   * @param word
   * @return a true or false
   */
  public boolean hasWord(String word){
    return wordList.contains(word);
  }

  /**
   * Finds the word in wordlist list by using binary search algorithm
   * @param word
   * @param low
   * @param high
   * @return How many times the word appears in the book
   */
  private int binarySearch(String word, int low, int high) {
    int index = Integer.MAX_VALUE;
    while (low <= high) {
      int mid = low + ((high - low) / 2);
      if (wordList.get(mid).compareTo(word) < 0) {
        low = mid + 1;
      } else if (wordList.get(mid).compareTo(word) > 0) {
        high = mid - 1;
      } else {
        index = mid;
        break;
      }
    }
    return (index == Integer.MAX_VALUE) ? -1 : dictArrayList.get(index).getCount();
  }


  /**
   * Prints the words in the wordList
   */
  public void printDictionary(){
    System.out.println("All words mentioned in the Ion book:");
    System.out.println("Words");
    System.out.println("-----");
    for(String word:wordList){
      System.out.println(word);
    }
  }

  /**
   * Using the input of a word, returns the number of times the word is used in the book
   * @param word
   * @return count of the word in the dictionary
   */
  public int searchDictionary(String word) {
    int low = 0, high = wordList.size();
    int result = binarySearch(word, low, high);
    if (result != -1) {
      return result;
    } else {
      System.out.println("The word \'" + word + "\' does not exist in the Ion dictionary!");
      return -1;
    }
  }
}