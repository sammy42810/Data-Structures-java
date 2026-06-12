//Samantha Bryan
//I pledge my honor that I have abided by the Stevens Honor System
public class DictionaryItem {
  private String word;
  private int count;
  
  /**
  * Stores the word-count pair in the DictionaryItem object
  * @param word
  * @param count
  */
  public DictionaryItem(String word, int count){
    this.word = word;
    this.count = count;
  }
  
  /**
  * Getter for the data field: word
  * @return word: a String
  */
  public String getWord(){
    return word;
  }
    
  /**
  * Getter for the data field: count
  * @return count: an int
  */
  public int getCount(){
    return count;
  }
  
  /**
  * Setter for the data field: word
  * @param word: a String
  */
  public void setWord(String word){
    this.word = word;
  }
  
  /**
  * Setter for the data field: count
  * @param count: an int
  */
  public void setCount(int count){
    this.count = count;
  }
}

