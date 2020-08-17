package linkedlist;

import java.util.Iterator;
import java.util.StringJoiner;

// Delete kth element. Implement a class that supports the following API:
// public class GeneralizedQueue<Item>
// GeneralizedQueue() create an empty queue
// boolean isEmpty() is the queue empty?
// void insert(Item x) add an item
// Item delete(int k) delete and return the kth least recently inserted item
// API for a generic generalized queue
// First, develop an implementation that uses an array implementation, and then develop
// one that uses a linked-list implementation. Note : the algorithms and data structures
// that we introduce in Chapter 3 make it possible to develop an implementation that
// can guarantee that both insert() and delete() take time prortional to the logarithm
// of the number of items in the queue—see Exercise 3.5.27.
public class GeneralisedQueue<Item> implements Iterable<Item>{

  private class Node{
    Item item;
    Node previous;
    Node next;
  }

  private int size;
  private Node first;
  private Node last;

  public boolean isEmpty(){
    return size ==0;
  }

  public int size(){
    return size;
  }

  public void insert(Item item){
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.previous = oldLast;
    if(oldLast != null){
      oldLast.next = last;
    }else{
      first = last;
    }
    size++;
  }


  public Item delete(int k){
    if(isEmpty() || k>size){
      throw new RuntimeException("underflow");
    }

    if(k<=0){
      throw new RuntimeException("invalid index");
    }

    int count ;
    Node current;
    boolean startFromBeginning = k<=size/2;
    if(startFromBeginning){
      count =1;
      for(current=first;count<k;current=current.next){
        count++;
      }
    }else{
      count = size;
      for(current=last;count>k;current = current.next){
        count--;
      }
    }

    Item item = current.item;

    if(current.previous != null){
      current.previous.next = current.next;
    }else{
      first = current.next;
    }

    if(current.next != null){
      current.next.previous = current.previous;
    }else{
      last = current.previous;
    }

    size--;
    return item;
  }

  public Iterator<Item> iterator(){
    return new GeneralisedQueueIterator();
  }

  private class GeneralisedQueueIterator<Item> implements Iterator<Item> {

    private Node current = first;

    @Override
    public boolean hasNext(){
      return current != null;
    }

    @Override
    public Item next(){
      Item item = (Item)current.item;
      current = current.next;
      return item;
    }
  }

  public static void main(String[] args) {
    GeneralisedQueue<Integer> generalizedQueue = new GeneralisedQueue<>();
    generalizedQueue.insert(0);
    generalizedQueue.insert(1);
    generalizedQueue.insert(2);
    generalizedQueue.insert(3);
    generalizedQueue.insert(4);

    generalizedQueue.delete(1);
    generalizedQueue.delete(4);
    generalizedQueue.insert(99);

    StringJoiner generalizedQueueItems = new StringJoiner(" ");
    for (int item : generalizedQueue) {
      generalizedQueueItems.add(String.valueOf(item));
    }

    System.out.println("Generalized queue items: " + generalizedQueueItems.toString());
    System.out.println("Expected: 1 2 3 99");
  }
}
