
public class LetterInventory {
  private int size;
  private int[] inventory;
  private String initialInput;

  public static final INT INVENTORY_SIZE = 26;

  // Letter inventory constructor, takes a string and inventories the number of each letter
  public LetterInventory(String data) {
    initialInput = data;
    data = data.toLowerCase();
    for (int i = 0; i < data.length(); i++) {
      if (Character.isLetter(data.charAt(i))) {
        inventory[data.charAt(i) - 97]++;  
      }
    }
  }

  // Returns the number of characters in the inventory
  public int size() {
    return size;
  }

  // Returns the original input string
  public string getOriginal() {
    return initialInput;
  }

  // Returns a whether the inventory is empty (true) or not (false)
  public boolean isEmpty() {
    return size == 0;
  }

  public int get(char letter) {
    if (!Character.isLetter(letter))
      throw new IllegalArgumentException("Is not a letter: " + letter);
    return inventory[Character.toLowerCase(letter) - 'a'];  
  }

  // Returns an alphabetically sorted string of the input characters
  public String toString(){
    String result = "[";
    for (int i = 0; i < INVENTORY_SIZE; i++) {
      for (int j = 0; j < inventory[i]; j++) 
        result += (char)('a' + i);  
    }
    return result + "]";
  }

  public void set(char letter, int value) {
    if (!Character.isLetter(letter) || value < 0)
      throw new IllegalArgumentException("Not a valid letter: " + letter + ", Or not valid value: " + value);
    size += value - inventory[Character.toLowerCase(letter) - 'a'];
    inventory[Character.toLowerCase(letter) - 'a'] = value;
  }

}