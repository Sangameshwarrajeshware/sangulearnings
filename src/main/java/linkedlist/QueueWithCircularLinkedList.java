package linkedlist;

import java.util.Iterator;
import java.util.StringJoiner;

public class QueueWithCircularLinkedList<Item> implements Iterable<Item>{

  @Override
  public Iterator<Item> iterator() {
    return new QueueIterator();
  }

  private class Node{
    Item item;
    Node next;
  }

  private int totalItems;
  private Node last;

  public boolean isEmpty(){
    return totalItems == 0;
  }

  public int size(){
    return totalItems;
  }

  public void enqueue(Item item){
    Node newNode = new Node();
    newNode.item = item;

    if(isEmpty()){
      last = newNode;
      last.next = last;
    }else{
      newNode.next = last.next;
      last.next = newNode;
      last = newNode;
    }
    totalItems++;
  }

  public Item dequeue(){
    if(isEmpty()){
      throw new RuntimeException("No Items present");
    }
    Item item;
    if(size()==1){
       item = last.item;
      last = null;
    }else{
       item = last.next.item;
      last.next = last.next.next;
    }
    totalItems--;
    return item;
  }

  private class QueueIterator implements Iterator<Item> {
    private Node current;
    private int count =0;

    public QueueIterator(){
      if(last !=null && size()>1){
        current = last.next;
      }else{
        current = last;
      }
    }

    public boolean hasNext(){
      return count < size();
    }

    public Item next(){
      count++;
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  public static void main (String[] args) {
		QueueWithCircularLinkedList<Integer> queue = new QueueWithCircularLinkedList<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);

        StringJoiner queueItems = new StringJoiner(" ");
        for (int item : queue) {
            queueItems.add(String.valueOf(item));
        }

        System.out.println("Queue items: " + queueItems.toString());
        System.out.println("Expected: 1 2 3 4");

        queue.dequeue();
    StringJoiner queueItems1 = new StringJoiner(" ");
    for (int item : queue) {
      queueItems1.add(String.valueOf(item));
    }
    System.out.println("Queue items: " + queueItems1.toString());
    System.out.println("Expected: 2 3 4");
	}


}
