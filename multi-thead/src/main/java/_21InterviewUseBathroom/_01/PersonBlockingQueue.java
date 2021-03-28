package _21InterviewUseBathroom._01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PersonBlockingQueue<Item> {

  private final Queue<Item> personsInQueue;
  private final int max;

  private final ReentrantLock lock = new ReentrantLock();
  private final Condition notFull = lock.newCondition();
  private final Condition notEmpty = lock.newCondition();

  public PersonBlockingQueue(int size) {
    this.personsInQueue = new LinkedList<>();
    this.max = size;
  }

  public void put(Item item) throws InterruptedException {
    lock.lock();
    try {
      while (personsInQueue.size() == max) {
        notFull.await();
      }
      personsInQueue.add(item);
      notEmpty.signalAll();
    } finally {
      lock.unlock();
    }
  }

  public Item take() throws InterruptedException {
    lock.lock();
    try {
      while (personsInQueue.isEmpty()) {
        notEmpty.await();
      }

      Item item = personsInQueue.remove();
      notFull.signalAll();
      return item;
    } finally {
      lock.unlock();
    }
  }
}
