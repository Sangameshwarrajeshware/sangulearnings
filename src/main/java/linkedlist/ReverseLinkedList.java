package linkedlist;

import java.util.Iterator;
import java.util.StringJoiner;

public class ReverseLinkedList<Item> implements Iterable<Item> {

  @Override
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class Node {
    Item item;
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

  public void add(Item item) {
    if (isEmpty()) {
      first = new Node();
      first.item = item;
    } else {
      Node current;
      for(current = first; current.next != null; current = current.next);

      Node newNode = new Node();
      newNode.item = item;
      current.next = newNode;
    }
    totalItems++;
  }

  public Node reverse() {
    Node current = first;
    Node reverse = null;
    while (current != null) {
      Node next = current.next;
      current.next = reverse;
      reverse = current;
      current = next;
    }
    first = reverse;
    return first;
  }

  public void reverse3() {
    first = reverse3Impl(first);
  }

  private Node reverse3Impl(Node current) {
    if (current == null) {
      return null;
    }

    if (current.next == null) {
      return current;
    }

    Node nextNode = current.next;
    Node rest = reverse3Impl(nextNode);
    nextNode.next = current;
    current.next = null;

    return rest;
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  public static void main(String[] args) {
    ReverseLinkedList<Integer> linkedList = new ReverseLinkedList<>();
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(4);

    linkedList.reverse3();

    StringJoiner listItems = new StringJoiner(" ");
    for (int item : linkedList) {
      listItems.add(String.valueOf(item));
    }

    System.out.println("Reverse list items: " + listItems.toString());
    System.out.println("Expected: 4 3 2 1");
  }
}
