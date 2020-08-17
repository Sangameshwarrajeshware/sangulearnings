package queue;

import java.util.Iterator;
import java.util.StringJoiner;

public class RingBuffer<Item> implements Iterable<Item>{
  private int size;
  private Item[] buffer;
  private int first;
  private int last;

  private Queue<Item> producerAuxQueue;
  private int dataCountToBeConsumed;

  public RingBuffer(int capacity){
    buffer = (Item[])new Object[capacity];
    first =-1;
    last =-1;
    size=0;
    dataCountToBeConsumed=0;
    producerAuxQueue = new Queue<Item>();
  }

  public boolean isEmpty(){
    return size ==0;
  }

  private boolean isFull(){
    return size == buffer.length;
  }

  public int size(){
    return size;
  }

  public void produce(Item item){

    if(dataCountToBeConsumed>0){
      consumeData(item);
      dataCountToBeConsumed--;
    }else{
      if(isEmpty()){
        buffer[size] = item;
        first = 0;
        last = 0;
        size++;
      }else{
        if(size<buffer.length){
          if(last == buffer.length-1){
            last =0;
          }else{
            last++;
          }
          buffer[last] = item;
          size++;
        }else{
          producerAuxQueue.enqueue(item);
        }
      }
    }



  }

  private void consumeData(Item item) {
    //Consumer consumes the item
    System.out.print("Data consumed: " + item);
  }

  public Item consume(){

    if(isEmpty()){
      dataCountToBeConsumed++;
      return null;
    }
    Item item = buffer[first];
    buffer[first] = null;
    if(first == buffer.length-1){
      first = 0;
    }else{
      first++;
    }
    size--;
    if(!producerAuxQueue.isEmpty()){
      producerAuxQueue.dequeue();
    }
    return item;

  }

  @Override
public Iterator<Item> iterator() {
    return new RingBufferIterator();
}

private class RingBufferIterator implements Iterator<Item> {

        private int current = first;
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public Item next() {
            Item item = buffer[current];

            if (current == buffer.length - 1) {
                current = 0; //Wrap around
            } else {
                current++;
            }

            count++;
            return item;
        }

    }

    public static void main(String[] args) {
      RingBuffer<Integer> ringBuffer = new RingBuffer<>(4);
      ringBuffer.produce(0);
      ringBuffer.produce(1);
      ringBuffer.produce(2);
      ringBuffer.produce(3);
      ringBuffer.produce(4);
      ringBuffer.produce(5);

      Integer item1 = ringBuffer.consume();
      if (item1 != null) {
        System.out.println("Consumed " + item1);
      }
      System.out.println("Expected: 0\n");

      Integer item2 = ringBuffer.consume();
      if (item2 != null) {
        System.out.println("Consumed " + item2);
      }
      System.out.println("Expected: 1\n");

      ringBuffer.produce(6);
      ringBuffer.produce(7);

      StringJoiner ringBufferItems = new StringJoiner(" ");
      for (int item : ringBuffer) {
        ringBufferItems.add(String.valueOf(item));
      }

      System.out.println("Main ring buffer items: " + ringBufferItems.toString());
      System.out.println("Expected: 2 3 4 5");
    }

}
