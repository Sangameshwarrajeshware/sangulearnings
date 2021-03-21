package _10IntervewProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<Item> {

  private final Queue<Item> queue;
  private final int max;

  private final ReentrantLock lock = new ReentrantLock();
  private final Condition notFull = lock.newCondition();
  private final Condition notEmpty = lock.newCondition();

  public MyBlockingQueue(int size) {
    this.queue = new LinkedList<>();
    this.max = size;
  }

  public void put(Item item) throws InterruptedException {
    lock.lock();
    try {
      while(queue.size()==max){
        //block the thread until it gets one slot free
        notFull.await();
      }
      queue.add(item);
      notEmpty.signalAll();
    } finally {
      lock.unlock();
    }
  }

  public Item take() throws InterruptedException {
    lock.lock();
    try {

      while(queue.isEmpty()){
        //block the thread until it gets one item in queue
        notEmpty.await();
      }
      Item item = queue.remove();
      notFull.signalAll();
      return item;
    } finally {
      lock.unlock();
    }
  }
}
