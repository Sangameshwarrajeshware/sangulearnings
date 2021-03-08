package linkedlist;

public class Node {
  public Object item;
  public Node next;

  public Node() {
  }

  Node(Object item) {
    this.item = item;
  }

  @Override
  public String toString() {
    return "Node{" +
      "item=" + item +
      '}';
  }
}
