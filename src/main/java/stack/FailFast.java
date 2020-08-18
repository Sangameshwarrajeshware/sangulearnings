package stack;

import java.util.Iterator;

public class FailFast<Item> implements Iterable<Item>{
  private class Node{
    Item item;
    Node next;
  }

  private int size;
  private Node first;
  private int operataionsCount;

  public boolean isEmpty(){
    return size ==0;
  }

  public int size(){
    return size;
  }

  public void push(Item item){
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    operataionsCount++;
    size++;
  }

  public Item pop(){
    if(isEmpty()){
      return null;
    }
    Item item = first.item;
    first = first.next;
    operataionsCount++;
    size--;
    return item;
  }

  public Iterator<Item> iterator(){
    return new FailFastIterator();
  }

  private class FailFastIterator<Item> implements Iterator<Item>{
    private int currentOperationCount;
    private Node current;

    public FailFastIterator(){
      current = first;
      currentOperationCount = operataionsCount;
    }

    @Override
    public boolean hasNext(){
      if(currentOperationCount!=operataionsCount){
        throw new RuntimeException("Concurent Modification not allowed");
      }
      return current != null;
    }

    @Override
    public Item next(){
      if(currentOperationCount!=operataionsCount){
        throw new RuntimeException("Concurent Modification not allowed");
      }
      Item item = (Item)current.item;
      current = current.next;
      return item;
    }
  }

  public static void main (String[] args) {
    System.out.print("Expected: a java.util.ConcurrentModificationException to be thrown\n");

    FailFast<String> failFastIterator = new FailFast<>();

    failFastIterator.push("a");
    failFastIterator.push("b");
    failFastIterator.push("c");
    failFastIterator.push("d");

    failFastIterator.pop();

    for(String string : failFastIterator) {
      System.out.print("Iterating at item " + string + " ");

      failFastIterator.push("z");
    }
  }
}
