package linkedlist;

public class SearchNode {

  private class Node {
    String item;
    Node next;
  }

  private int totalItems;
  private Node first;

  public boolean isEmpty() {
    return totalItems == 0;
  }

  public int size() {
    return totalItems;
  }

  public void add(String item) {
    if (size() == 0) {
      first = new Node();
      first.item = item;
    } else {
      Node current;
      for (current = first; current.next != null; current = current.next) ;
      Node newNode = new Node();
      newNode.item = item;
      current.next = newNode;
    }
    totalItems++;
  }

  public boolean search(String item) {
    if (size() == 0) {
      return false;
    }
    Node current;
    for (current = first; current.next != null; current = current.next) {
      if (current.item.equals(item)) {
        return true;
      }
    }

    return false;

  }


  public static void main(String[] args){
    SearchNode searchNode = new SearchNode();
    searchNode.add("sangu");
    searchNode.add("sangu4");
    searchNode.add("sangu6");

    System.out.println(searchNode.search("sangu"));
    System.out.println(searchNode.search("sa"));
  }

}
