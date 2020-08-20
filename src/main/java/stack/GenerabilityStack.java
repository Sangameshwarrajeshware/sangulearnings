package stack;

import queue.Queue;

class GenerablilityStack {

  public static boolean willTheStackUnderflow(String[] inputValues) {
    int count = 0;
    for (String input : inputValues) {
      if (input.equals("_")) {
        count--;
      } else {
        count++;
      }
      if (count < 0) {
        return true;
      }
    }
    return false;
  }

  private static boolean canAPermutationBeGenerated(String[] permutation) {
    Stack<Integer> stack = new Stack<>();
    int current = 0;

    for (String value : permutation) {
      int integerValue = Integer.parseInt(value);

      if (stack.isEmpty() || integerValue > stack.peek()) {
        while (current < integerValue) {
          stack.push(current);
          current++;
        }

        current++;
      } else if (integerValue == stack.peek()) {
        stack.pop();
      } else {
        return false;
      }
    }

    return true;
  }


  public static boolean isValidOutput(String s) {
    // Get output into queue
    String[] items = s.split("\\s+");
    Queue<Integer> output = new Queue<>();
    for (String item : items) {
      output.enqueue(Integer.parseInt(item));
    }
    // Generate queue of possible inputs
    Queue<Integer> input = new Queue<>();
    for (int i = 0; i < output.size(); i++) {
      input.enqueue(i);
    }
    // Parse output
    String debug = "";
    Stack<Integer> buffer = new Stack<>();
    while (!output.isEmpty()) {
      while (!input.isEmpty() && output.peek() >= input.peek()) {
         System.out.println("  push " + input.peek());
        debug += input.peek() + " ";
        buffer.push(input.dequeue());
      }
      if (output.peek() == buffer.peek()) {
        int tmp = buffer.pop();
        System.out.println("  pop  " + tmp);
        debug += "- ";
      }
      output.dequeue();
    }
    // Output is valid if buffer is empty
    if (buffer.isEmpty()) {
      // Sanity check
      System.out.printf("%12s: \"%s\" from \"%s\"\n", "Verify", testClient(debug), debug);
      return true;
    }
    else {
      System.out.printf("%12s: \"%s\" from \"%s\"\n", "Verify", testClient(debug), debug);
      return false;
    }
  }

  public static String testClient(String input) {
    String[] items = input.split("\\s+");
    Stack<String> s = new Stack<>();
    String output = "";
    for (String item : items) {
      if (!item.equals("-"))
        s.push(item);
      else if (!s.isEmpty())
        output += s.pop() + " ";
    }
    return output;
  }

  public static void main(String[] args) {
    //"Will the stack underflow?" tests
    String input1Values = "0 1 2 - - -";
    String[] input1 = input1Values.split("\\s");

    System.out.print("Input 1 - Will Underflow? ");
    System.out.println(willTheStackUnderflow(input1) + " Expected: false");

    String input2Values = "0 1 2 - - - 3 4 5 - - 6 - - -";
    String[] input2 = input2Values.split("\\s");

    System.out.print("Input 2 - Will Underflow? ");
    System.out.println(willTheStackUnderflow(input2) + " Expected: true");

    String input3Values = "0 - - 1 2 -";
    String[] input3 = input3Values.split("\\s");

    System.out.print("Input 3 - Will Underflow? ");
    System.out.println(willTheStackUnderflow(input3) + " Expected: true");

    //"Can permutation be generated?" tests
    System.out.println("\nCan a permutation be generated?");
    System.out.print("Input: 4 3 2 1 0 9 8 7 6 5 - ");
    System.out.println(canAPermutationBeGenerated("4 3 2 1 0 9 8 7 6 5".split(" ")) + " Expected: true");
    System.out.print("Input: 4 6 8 7 5 3 2 9 0 1 - ");
    System.out.println(canAPermutationBeGenerated("4 6 8 7 5 3 2 9 0 1".split(" ")) + " Expected: false");
    System.out.print("Input: 2 5 6 7 4 8 9 3 1 0 - ");
    System.out.println(canAPermutationBeGenerated("2 5 6 7 4 8 9 3 1 0".split(" ")) + " Expected: true");
    System.out.print("Input: 4 3 2 1 0 5 6 7 8 9 - ");
    System.out.println(canAPermutationBeGenerated("4 3 2 1 0 5 6 7 8 9".split(" ")) + " Expected: true");
    System.out.print("Input: 1 2 3 4 5 6 9 8 7 0 - ");
    System.out.println(canAPermutationBeGenerated("1 2 3 4 5 6 9 8 7 0".split(" ")) + " Expected: true");
    System.out.print("Input: 0 4 6 5 3 8 1 7 2 9 - ");
    System.out.println(canAPermutationBeGenerated("0 4 6 5 3 8 1 7 2 9".split(" ")) + " Expected: false");
    System.out.print("Input: 1 4 7 9 8 6 5 3 0 2 - ");
    System.out.println(canAPermutationBeGenerated("1 4 7 9 8 6 5 3 0 2".split(" ")) + " Expected: false");
    System.out.print("Input: 2 1 4 3 6 5 8 7 9 0 - ");
    System.out.println(canAPermutationBeGenerated("2 1 4 3 6 5 8 7 9 0".split(" ")) + " Expected: true");
    System.out.print("Input: 4 3 2 1 0 5 9 7 8 6 - ");
    System.out.println(canAPermutationBeGenerated("4 3 2 1 0 5 9 7 8 6".split(" ")) + " Expected: false");


    System.out.println("----------------------");
    System.out.println(isValidOutput("4 3 2 1 0 9 8 7 6 5") + " Expected: true");
    System.out.println(isValidOutput("2 5 6 7 4 8 9 3 1 0") + " Expected: true");
    System.out.println(isValidOutput("4 6 8 7 5 3 2 9 0 1") + " Expected: false");
  }
}
