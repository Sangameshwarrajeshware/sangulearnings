package linkedlist;

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {





  private int size;
  private Node first;

  public Node getFirst(){
    return first;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void add(Item item) {
    Node newNode = new Node(item);
    newNode.next = first;

    first = newNode;
    size++;
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    public Item next() {
      Item item = (Item) current.item;
      current = current.next;

      return item;
    }
  }
}
