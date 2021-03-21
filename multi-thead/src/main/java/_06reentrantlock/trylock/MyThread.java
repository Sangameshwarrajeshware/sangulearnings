package _06reentrantlock.trylock;

import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
  static ReentrantLock reentrantLock = new ReentrantLock();

  public MyThread(String name) {
    super(name);
  }

  public void run() {
    if (reentrantLock.tryLock()) {
      System.out.println(
          Thread.currentThread().getName() + " got the lock so perfomring safe operation");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      reentrantLock.unlock();
    } else {
      System.out.println(
          Thread.currentThread().getName() + " not got Lock so performing alternative operation");
    }
  }
}
