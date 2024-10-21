package Rec;

public class question1 {

}
//multiply
public static int multiply(int x, int y) {
    if (x == 0) {
        return 0;
    }
    return y + multiply(x - 1, y);
}

public static void main(String[] args) {
    System.out.println(multiply(7, 4)); 
    System.out.println(multiply(3, 5));  
}
}
///print chars
public static void printCharacters(char character, int count) {
    if (count > 0) {
        System.out.print(character);
        printCharacters(character, count - 1);
    } else {
        System.out.println();
    }
}

public static void main(String[] args) {
    printCharacters('*', 3);
    printCharacters('#', 5);
    printCharacters('^', 20);
}
}
////////////count vowels
public static int countVowels(String var0, int var1) {
    if (var1 == var0.length()) {
       return 0;
    } else {
       char var2 = var0.charAt(var1);
       return "AEIOUaeiou".indexOf(var2) != -1 ? 1 + countVowels(var0, var1 + 1) : countVowels(var0, var1 + 1);
    }
 }

 public static void main(String[] var0) {
    String var1 = "Hello World";
    int var2 = countVowels(var1, 0);
    System.out.println("Number of vowels in the string: " + var2);
 }
}

//Recursive method to remove vowels from a string
public static String removeVowels(String str, int index) {
  if (index == str.length()) {
      return "";
  }
  char ch = str.charAt(index);
  if ("AEIOUaeiou".indexOf(ch) == -1) {
      return ch + removeVowels(str, index + 1);
  }
  return removeVowels(str, index + 1);
}
//test
public static void main(String[] args) {
  String input = "Hello, World!";
  String output = removeVowels(input, 0);
  System.out.println(output); // prints: Hll, Wrld!
}
}

//Recursive method to duplicate each character in a string
public static String duplicateChars(String str, int index) {
  if (index == str.length()) {
      return "";
  }
  return str.charAt(index) + "" + str.charAt(index) + duplicateChars(str, index + 1);
}
//test
  public static void main(String[] args) {
      String input = "Hello";
      System.out.println(duplicateChars(input, 0));
  }
}
