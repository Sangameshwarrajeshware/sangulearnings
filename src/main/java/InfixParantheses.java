import java.util.Stack;

public class InfixParantheses{

  public static String infix(String input){

    Stack<String> operators = new Stack<String>();
    Stack<String> operands = new Stack<String>();

    String[] characters = input.split("\\s");

    for(String character : characters){
      if(character.equals("(")){
      }else if(character.equals("+") || character.equals("-")|| character.equals("*") || character.equals("/")){
        operators.push(character);
      }else if(character.equals(")")){
        String operator = operators.pop();
        String value2 = operands.pop();
        String value1 = operands.pop();

        String subExpression = "( "+value1+" "+operator+" "+value2+" )";
        operands.push(subExpression);
      }else{
        operands.push(character);
      }
    }

    return operands.pop();

  }
}
