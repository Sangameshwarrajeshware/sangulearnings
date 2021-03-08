package reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class Display {
  ReentrantLock reentrantLock = new ReentrantLock();

  public void wish(String name) {
    reentrantLock.lock(); // if we comment this line threads will run simultaneously
    for (int i = 0; i <= 10; i++) {
      System.out.println("Good morning");

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(name);
    }
    reentrantLock.unlock();
  }
}
