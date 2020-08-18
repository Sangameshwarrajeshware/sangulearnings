package queue;

public class TextEditor<Item>{
  private class Node{
    Item item;
    Node next;
  }

  private int sizeLeft;
  private int sizeRight;
  private Node firstLeftStack;
  private Node firstRightStack;

  public TextEditor(){
    sizeLeft =0;
    sizeRight=0;
    firstLeftStack = null;
    firstRightStack= null;
  }

  public void insert(Item item){
    Node oldFirstLeft = firstLeftStack;
    firstLeftStack = new Node();
    firstLeftStack.item = item;
    firstLeftStack.next = oldFirstLeft;
    sizeLeft++;
  }

  public Item get(){
    if(sizeRight==0){
      return null;
    }

    return firstRightStack.item;
  }

  public Item delete(){
    if(sizeRight==0){
      return null;
    }
    Item item = firstRightStack.item;
    firstRightStack = firstRightStack.next;
    return item;
  }

  private void insertOnRightStack(Item item){
    Node oldFirstRight = firstRightStack;
    firstRightStack = new Node();
    firstRightStack.item = item;
    firstRightStack.next = oldFirstRight;
    sizeRight++;
  }

  public void left(int k){
    int count = 0;
    while(count<k && sizeLeft > 0){
      Item item = firstLeftStack.item;
      insertOnRightStack(item);
      firstLeftStack = firstLeftStack.next;
      sizeLeft--;
      count++;
    }
  }

  public int size(){
    return sizeLeft + sizeRight;
  }

  public void right(int k){
    int count = 0;
    while(count< k && sizeRight>0){
      Item item = firstRightStack.item;
      insert(item);
      firstRightStack = firstRightStack.next;
      sizeRight--;
      count++;
    }

    
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("Left Stack: ");
    for(Node current = firstLeftStack; current != null; current = current.next) {
      stringBuilder.append(current.item).append(" ");
    }

    stringBuilder.append("\nRight Stack: ");
    for(Node current = firstRightStack; current != null; current = current.next) {
      stringBuilder.append(current.item).append(" ");
    }

    return stringBuilder.toString();
  }

  public static void main(String...args) {
    TextEditor<Character> textEditorBuffer = new TextEditor<>();

    System.out.println("Test insert");
    textEditorBuffer.insert('R');
    textEditorBuffer.insert('e');
    textEditorBuffer.insert('n');
    textEditorBuffer.insert('e');

    System.out.println(textEditorBuffer);
    System.out.println("Expected:\n" +
      "Left Stack: e n e R \n" +
      "Right Stack: ");

    System.out.println("\nTest left");
    textEditorBuffer.left(3);

    System.out.println(textEditorBuffer);
    System.out.println("Expected:\n" +
      "Left Stack: R \n" +
      "Right Stack: e n e");

    System.out.println("\nTest right");
    textEditorBuffer.right(2);

    System.out.println(textEditorBuffer);
    System.out.println("Expected:\n" +
      "Left Stack: n e R \n" +
      "Right Stack: e");

    System.out.println("\nTest get");
    System.out.println(textEditorBuffer.get());
    System.out.println(textEditorBuffer.get());
    System.out.println("Expected:\ne\ne");

    System.out.println("\nTest delete");
    System.out.println(textEditorBuffer.delete());

    System.out.println(textEditorBuffer);
    System.out.println("Expected:\n" +
      "e\n" +
      "Left Stack: n e R \n" +
      "Right Stack: ");
  }

}
