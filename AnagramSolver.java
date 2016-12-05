// Anagram Solver is a class that takes the users input for a dictionary file, word/words and
// a max number of words the anagram that it generates can create. After receiving the input
// this program will print all the possible combinations from within the dictionary and critera

import java.util.*;

public class AnagramSolver {

	private Map<String, LetterInventory> wordList;
	private List<String> dictionary;
	
	// Creates an anagram solver that uses the provided list as all the possible words
	public AnagramSolver(List<String> list){
		wordList = new HashMap<String, LetterInventory>();
		dictionary = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			dictionary.add(list.get(i));
			LetterInventory inventory = new LetterInventory(list.get(i));
		 	wordList.put(list.get(i), inventory);
		}
	}

  	// Prints out all the possible anagram combinations at or under the selected max of the provided
	// string. If max is 0 then prints all possible combinations and throws IllegalArgumentException
	// if max is less than 0. Also elimatinates all words from the dictionary that can not be used
	public void print(String s, int max) {
		if (max < 0) {
			throw new IllegalArgumentException("Max must be greater than 0");
		}
		LetterInventory wordInventory = new LetterInventory(s);
		List<String>  miniDictionary = new ArrayList<String>();	
		for (String d : dictionary) {
			if (wordInventory.subtract(wordList.get(d))!= null) {
				miniDictionary.add(d);
			}
		}	
		List<String> temp = new ArrayList<String>();
		anagramCompiler(wordInventory, max, temp, 0, miniDictionary);		
	}
	
	// Manually searches through the dictionary for all the possible anagrams by checking the letter
	// inventories, prints any anagram that is made from the max possible words or lower in the 
	// order they are found
	private void anagramCompiler(LetterInventory wordInventory, int max, List<String> temp,
										  int level, List<String> miniDictionary) {
		List<String> correct = new ArrayList<String>();		
		if (wordInventory.isEmpty()) {
			System.out.println(temp);
		} else if (max > level || max == 0) {		
			for (int i = 0; i < dictionary.size(); i++) {
				String key = dictionary.get(i);
				if (wordInventory.subtract(wordList.get(key)) != null) {
					wordInventory = wordInventory.subtract(wordList.get(key));
					temp.add(key);
					anagramCompiler(wordInventory, max, temp, level + 1, miniDictionary);
					temp.remove(temp.size()-1);
					wordInventory = wordInventory.add(wordList.get(key));	 	
				} 	
			}			
		}
	}
}