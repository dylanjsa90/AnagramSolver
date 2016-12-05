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
	
	
}