//Samantha Bryan
//I pledge my honor that I have abided by the Stevens Honor System

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class DictionaryCreator {
    private Dictionary dict;

    /**
     * A constructor for reading the file ‘IonDictionary.txt’ from the folder your file is in.
     * Call readFile() method from this constructor to read the file and store the dictionary object
     * Calls printMenu() to run the program.
     */
    public DictionaryCreator(){
        readFile("IonDictionary.txt");
        printMenu();
    }
    public DictionaryCreator(String filename) {
        readFile(filename);
        printMenu();
    }

    /**A boolean operation method checks if the file exists in the given path/current folder.
     * If it does, it returns true.
     * Else, it throws FileNotFoundException.
     * @param fileName
     * @return boolean True/False
     */
    public boolean fileExists(String fileName){
        File newFile = new File(fileName);
        return newFile.exists();
    }

    /**
     * Imputs a file to be read and split into its words
     * and the words and their counts.
     * @param filename
     * @return Dictionary of the Word and its Word and count
     * @throws FileNotFoundException
     */
    public Dictionary readFile(String filename) {
        File f = new File(filename);
        try {
            if (!fileExists(filename)) {
                throw new FileNotFoundException("File does not exist.");
            }
            Scanner s = new Scanner(f);
            dict = new Dictionary();
            int c = 0;
            while (s.hasNextLine()) {
                if (c < 4) {
                    s.nextLine();
                    c++;
                    continue;
                }
                String line = s.nextLine();
                DictionaryItem item = splitWordCountPair(line);
                if (item != null) {
                    dict.addWordToDictionary(item);
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return dict;
    }

    /**
     * Creates a dictionary
     * @return a dictionary
     */
    public Dictionary createADictionary(){
        Dictionary d = new Dictionary();
        return d;
    }

    /**
     * A helper function to split the word from the count in the text file.
     * @param l
     * @return A dictionary item with the word and its count
     */
    public DictionaryItem splitWordCountPair(String l){
        String word = "";
        int i = 0;
        String[] a = l.split("\\|");
        word = a[0].strip();
        try {
            i = Integer.parseInt(a[1].strip());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("There is no count for this word.");
        }
        DictionaryItem di = new DictionaryItem(word,i);
        return di;
    }

    /**
     * Prints the menu for the user repeatedly till user chooses 3 to indicate the end of program.
     * If user enters a value out of 1-3 range, code catches NumberFormatException
     * Calls the processMenuItem method to perform specific tasks for each menu item.
     */
    public void printMenu(){
        System.out.println("Welcome to the Ion Dictionary! This dictionary is created from the words used in the book Ion by Plato!");
        Scanner userInput = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("Please choose one of the following menu items indicated with 1-3");
            System.out.println("1: To print all the words in the dictionary, choose 1");
            System.out.println("2: To search a word in the dictionary, choose 2");
            System.out.println("3: To quit the program, choose 3");
            int item = 0;
            try {
                item = Integer.parseInt(userInput.nextLine());
                if(item>3 || item<1)
                    throw new IllegalArgumentException();
            }catch(IllegalArgumentException e) {
                System.out.println("ERROR! Please enter a number between 1 and 3.");
                continue;
            }
            loop = processMenuItem(item, userInput);
        }
        userInput.close();
    }

    /**
     * Menu item 1: calls the printDictionary method
     * Menu item 2: calls searchDictionary method to search the user given word in the dictionary.
     * @param menuItem: user given value
     * @param scan: Scanner type object, passed to keep the input stream open
     * @return
     */
    private boolean processMenuItem(int menuItem, Scanner scan){
        boolean menuLoop = true;
        switch (menuItem){
            case 1:
                dict.printDictionary();
                break;
            case 2:
                System.out.println("Please enter the word you would like to search: ");
                String word = scan.nextLine();
                int count = dict.searchDictionary(word);
                if (count != -1) {
                    System.out.println("The word \'" + word + "\' occurred " + dict.searchDictionary(word) + " times in the book!");
                }
                else{
                    System.out.println("The word \'" + word + "\' does not exist in the Ion dictionary!");
                }
                break;
            case 3:
                System.out.println("Thanks for using Ion Dictionary! Bye!");
                menuLoop = false;
                break;
        }
        return menuLoop;
    }


}
