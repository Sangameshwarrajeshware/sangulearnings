package stack;

import java.util.StringJoiner;

public class CopyStack<Item> extends Stack<Item> {

  public CopyStack(Stack<Item> stack) {
    Stack<Item> temp = new Stack<>();

    for (Item item : stack) {
      temp.push(item);
    }
    for (Item item : temp) {
      push(item);
    }
  }

  public static void main(String[] args) {
    Stack<Integer> originalStack = new Stack<>();
    originalStack.push(1);
    originalStack.push(2);
    originalStack.push(3);
    originalStack.push(4);

    CopyStack<Integer> stackCopy = new CopyStack<>(originalStack);

    stackCopy.push(5);
    stackCopy.push(6);

    originalStack.pop();
    originalStack.pop();

    stackCopy.pop();

    StringJoiner originalStackItems = new StringJoiner(" ");
    for (int item : originalStack) {
      originalStackItems.add(String.valueOf(item));
    }

    System.out.println("Original Stack: " + originalStackItems.toString());
    System.out.println("Expected: 2 1");

    System.out.println();

    StringJoiner copyStackItems = new StringJoiner(" ");
    for (int item : stackCopy) {
      copyStackItems.add(String.valueOf(item));
    }

    System.out.println("Stack Copy: " + copyStackItems.toString());
    System.out.println("Expected: 5 4 3 2 1");
  }
}
