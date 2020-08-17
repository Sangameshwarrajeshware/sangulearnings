package array;

import java.util.Iterator;
import java.util.StringJoiner;

public class GeneralizedQueue<Item> implements Iterable<Item>{
  private int size;
  private Item[] queue;

  public GeneralizedQueue(){
    queue = (Item[])new Object[1];
    size =0;
  }

  public boolean isEmpty(){
    return size ==0;
  }

  public int size(){
    return size;
  }

  public void insert(Item item){
    if(size == queue.length){
      resize(queue.length*2);
    }
    queue[size] = item;
    size++;
  }

  public Item delete(int k){
    if(isEmpty() || k> size){
      throw new RuntimeException("Queue is Empty not able delete");
    }

    Item item = queue[k-1];
    moveLeft(k);
    size--;
    if(size == queue.length/4){
      resize(queue.length/2);
    }
    return item;
  }

  private void moveLeft(int k){
    for(int i=k;i<size;i++){
      queue[i-1] = queue[i];
    }
    queue[size-1] = null;
  }

  private void resize(int capacity){
    Item[] newArray =(Item[]) new Object[capacity];
    for(int i=0;i<size;i++){
      newArray[i] = queue[i];
    }
    queue = newArray;
  }

  public Iterator<Item> iterator(){
    return new GeneralizedQueueIterator();
  }

  private class GeneralizedQueueIterator<Item> implements Iterator<Item>{
    int index = 0;

    @Override
    public boolean hasNext(){
      return index < size;
    }

    @Override
    public Item next(){
      Item item = (Item) queue[index];
      index++;
      return item;
    }
  }

  public static void main(String[] args) {
    GeneralizedQueue<Integer> generalizedQueue = new GeneralizedQueue<>();
    generalizedQueue.insert(0);
    generalizedQueue.insert(1);
    generalizedQueue.insert(2);
    generalizedQueue.insert(3);
    generalizedQueue.insert(4);

    generalizedQueue.delete(1);
    generalizedQueue.delete(3);

    StringJoiner generalizedQueueItems = new StringJoiner(" ");
    for (int item : generalizedQueue) {
      generalizedQueueItems.add(String.valueOf(item));
    }

    System.out.println("Generalized queue items: " + generalizedQueueItems.toString());
    System.out.println("Expected: 1 2 4");
  }

}
