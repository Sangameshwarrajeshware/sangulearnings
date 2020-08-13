package linkedlist;

import java.util.Iterator;
import java.util.StringJoiner;

public class Deque<Item> implements Iterable<Item>{
  private int totalItems;
  private Node first;
  private Node last;

  private class Node{
    Item item;
    Node previous;
    Node next;
  }

  public boolean isEmpty(){
    return totalItems == 0;
  }

  public int size(){
    return totalItems;
  }

  public void pushLeft(Item item){
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    if(oldFirst != null){
      oldFirst.previous = first;
    }else{
      last = first;
    }
    totalItems++;
  }

  public void pushRight(Item item){
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.previous = oldLast;
    if(oldLast != null){
      oldLast.next = last;
    }else{
      first = last;
    }
    totalItems++;
  }

  public Item popLeft(){
    if(isEmpty()){
      throw new RuntimeException("Stack underflow");
    }

    Item item = first.item;
    first = first.next;
    if(first != null){
      first.previous = null;
    }else{
      last =null;
    }
    totalItems--;
    return item;
  }

  public Item popRight(){
    if(isEmpty()){
      throw new RuntimeException("Stack underflow");
    }
    Item item = last.item;
    last = last.previous;
    if(last != null){
      last.next = null;
    }else{
      first = null;
    }
     totalItems--;
    return item;
  }

  public Iterator<Item> iterator(){
    return new DequeIterator();
  }

  private class DequeIterator implements Iterator<Item>{
    Node current = first;
    int index =0;

    @Override
    public boolean hasNext(){
      return index < size();
    }

    @Override
    public Item next(){
      Item item = current.item;
      current = current.next;
      index++;
      return item;
    }
  }

  public static void main(String[] args) {
       Deque<String> deque = new Deque<>();

       deque.testPushLeft();
       deque.testPushRight();
       deque.testPopLeft();
       deque.testPopRight();
   }

   private void testPushLeft() {
       System.out.println("Test Push Left");

       Deque<String> deque = new Deque<>();
       deque.pushLeft("a");
       deque.pushLeft("b");
       deque.pushLeft("c");

       StringJoiner dequeItems = new StringJoiner(" ");
       for (String item : deque) {
           dequeItems.add(item);
       }

       System.out.println("Deque items: " + dequeItems.toString());
       System.out.println("Expected: c b a");
   }

   private void testPushRight() {
       System.out.println("\nTest Push Right");

       Deque<String> deque = new Deque<>();
       deque.pushRight("a");
       deque.pushRight("b");
       deque.pushRight("c");

       StringJoiner dequeItems = new StringJoiner(" ");
       for (String item : deque) {
           dequeItems.add(item);
       }

       System.out.println("Deque items: " + dequeItems.toString());
     System.out.println("Expected: a b c");
   }

   private void testPopLeft() {
     System.out.println("\nTest Pop Left");

       Deque<String> deque = new Deque<>();
       deque.pushRight("a");
       deque.pushRight("b");
       deque.pushRight("c");

       deque.popLeft();
       deque.popLeft();

       StringJoiner dequeItems = new StringJoiner(" ");
       for (String item : deque) {
           dequeItems.add(item);
       }

     System.out.println("Deque items: " + dequeItems.toString());
     System.out.println("Expected: c");
   }

   private void testPopRight() {
     System.out.println("\nTest Pop Right");

       Deque<String> deque = new Deque<>();
       deque.pushRight("a");
       deque.pushRight("b");
       deque.pushRight("c");

       deque.popRight();
       deque.popRight();

       StringJoiner dequeItems = new StringJoiner(" ");
       for (String item : deque) {
           dequeItems.add(item);
       }

     System.out.println("Deque items: " + dequeItems.toString());
     System.out.println("Expected: a");
   }
}
