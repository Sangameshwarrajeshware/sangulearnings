import java.util.Stack;

public class ParanthesesBalanced {

  public static void main(String[] args) {
    System.out.println(isBalanced("{[()]}"));
    System.out.println(isBalanced("{[(]}"));
    System.out.println(isBalanced("{[("));
    System.out.println(isBalanced("{[()]}{([()])}[({})]"));
    System.out.println(isBalanced("]})"));
  }

  private static boolean isBalanced(String anSetOfParantheses) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < anSetOfParantheses.length(); i++) {
      char character = anSetOfParantheses.charAt(i);
      if (isOpenParantheses(character)) {
        stack.push(character);
      } else if (character == ')') {
        if (stack.empty() || stack.pop() != '(') {
          return false;
        }
      } else if (character == ']') {
        if (stack.empty() || stack.pop() != '[') {
          return false;
        }
      } else if (character == '}') {
        if (stack.empty() || stack.pop() != '{') {
          return false;
        }
      }

    }

    return stack.isEmpty();
  }

  private static boolean isOpenParantheses(char character) {
    return character == '(' || character == '[' || character == '{';
  }
}
