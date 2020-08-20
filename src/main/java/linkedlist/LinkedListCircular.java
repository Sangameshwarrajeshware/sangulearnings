package linkedlist;

import java.util.Iterator;

public class LinkedListCircular<Item> implements Iterable<Item> {

  private class Node {
    Item item;
    Node next;
  }

  private int size;
  private Node first;
  private Node last;

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void insert(Item item) {
    Node oldLast = last;
    last = new Node();
    last.item = item;

    if(oldLast != null) {
      last.next = oldLast.next;
      oldLast.next = last;
    }else{
        first = last;
        last.next = first;
      }
      size++;
    }


  public Node getFirstNode() {
    return first;
  }

  public Item get(int index) {
    if (isEmpty()) {
      return null;
    }

    if (index > size || index < 0) {
      throw new IllegalArgumentException("index should be correct");
    }

    Node current = first;
    int currentIndex = 0;
    while (currentIndex < index) {
      current = current.next;
      currentIndex++;
    }
    return current.item;
  }

  public void remove(int index) {
    if (isEmpty()) {
      return;
    }

    if (index > size || index < 0) {
      throw new IllegalArgumentException("index should be correct");
    }

    if (index == 0) {
      if (size() > 1) {
        first = first.next;
        last.next = first;
      } else {
        first = null;
        last = null;
      }
    } else {
      int currentIndex = 0;
      Node currentNode = first;
      while (index - 1 > currentIndex) {
        currentNode = currentNode.next;
      }
      currentNode.next = currentNode.next.next;
      if (currentNode.next == last) {
        last = currentNode;
      }
    }
    size--;
  }

  public void remove(Item item) {
    if (size() == 0) {
      return;
    }
    if (first.item.equals(item)) {
      if (size() > 1) {
        first = first.next;
        last.next = first;
      } else {
        first = null;
        last = null;
      }
      size--;
    } else {
      Node current = first;
      while (current != last && current.next.item.equals(item)) {
        current = current.next;
      }
      if (current != last) {
        current.next = current.next.next;
        if (current.next == last) {
          last = current;
        }

        size--;
      }
    }
  }

  public Iterator<Item> iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator<Item> implements Iterator<Item> {
    Node current = first;
    int index = 0;

    @Override
    public boolean hasNext() {
      return index < size();
    }

    @Override
    public Item next() {
      Item item = (Item) current.item;
      current = current.next;
      index++;
      return item;
    }
  }
}
