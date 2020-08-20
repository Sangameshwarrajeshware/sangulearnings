package expert;


import java.util.Iterator;
import java.util.StringJoiner;


public class DeleteKthNode<Item> implements Iterable<Item> {

  private class Node {
    Item item;
    Node next;
  }

  private int size;
  private Node first;

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
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
    size++;
  }

  public void deleteLastNode() {
    if (!isEmpty()) {
      if (size == 1) {
        first = null;
      } else {
        Node current = first;
        for (int i = 0; i < size - 2; i++) {
          current = current.next;
        }
        current.next = null;
      }

      size--;
    }
  }

  public void delete(int k) {
    if (k > size || isEmpty()) {
      return;
    }

    if (k == 1) {
      first = first.next;
    } else {
      Node current;
      int count = 1;

      for(current = first; current != null; current = current.next) {
        if (count == k - 1 && current.next != null) {
          current.next = current.next.next;
          break;
        }
        count++;
      }
    }
    size--;
  }

  @Override
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    Node current = first;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      Item item = current.item;
      current = current.next;

      return item;
    }
  }

  public static void main(String[] args) {
    DeleteKthNode<Integer> linkedList = new DeleteKthNode<>();
    linkedList.add(0);
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);

    System.out.println("Before removing second node");

    StringJoiner listBeforeRemove = new StringJoiner(" ");
    for (int number : linkedList) {
      listBeforeRemove.add(String.valueOf(number));
    }


    System.out.println(listBeforeRemove.toString());
    System.out.println("Expected: 0 1 2 3");

    linkedList.delete(2);

    System.out.println("\nAfter removing second node");
    StringJoiner listAfterRemove = new StringJoiner(" ");
    for (int number : linkedList) {
      listAfterRemove.add(String.valueOf(number));
    }

    System.out.println(listAfterRemove.toString());
    System.out.println("Expected: 0 2 3");
  }

}
