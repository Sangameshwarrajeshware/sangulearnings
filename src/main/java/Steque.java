public class Steque<Item>{

  private Node first;
  private Node last;
  private int N;

  private class Node{
    Item item;
    Node next;
  }

// push item on top of the stack
  public void push(Item item){
    Node oldLast = last;
    last = new Node();
    last.item = item;
    oldLast.next = last;
    N++;

  }


}
