

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

}