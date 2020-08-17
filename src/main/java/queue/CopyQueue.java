package queue;

import java.util.StringJoiner;

public class CopyQueue<Item> extends Queue<Item> {
  public CopyQueue(Queue<Item> queue) {
    for (Item item : queue) {
      enqueue(item);
    }
  }

  public static void main(String[] args) {
    Queue<Integer> originalQueue = new Queue<>();
    originalQueue.enqueue(1);
    originalQueue.enqueue(2);
    originalQueue.enqueue(3);
    originalQueue.enqueue(4);

    CopyQueue<Integer> queueCopy = new CopyQueue<>(originalQueue);
    queueCopy.enqueue(5);
    queueCopy.enqueue(99);

    originalQueue.dequeue();

    queueCopy.dequeue();
    queueCopy.dequeue();

    StringJoiner originalQueueItems = new StringJoiner(" ");
    for (int item : originalQueue) {
      originalQueueItems.add(String.valueOf(item));
    }

    System.out.println("Original Queue: " + originalQueueItems.toString());
    System.out.println("Expected: 2 3 4");

    System.out.println();

    StringJoiner copyQueueItems = new StringJoiner(" ");
    for (int item : queueCopy) {
      copyQueueItems.add(String.valueOf(item));
    }

    System.out.println("Queue Copy: " + copyQueueItems.toString());
    System.out.println("Expected: 3 4 5 99");
  }

}
