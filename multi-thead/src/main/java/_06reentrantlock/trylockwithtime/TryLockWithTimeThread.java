package _06reentrantlock.trylockwithtime;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockWithTimeThread extends Thread {

  static ReentrantLock reentrantLock = new ReentrantLock();

  public TryLockWithTimeThread(String name) {
    super(name);
  }

  public void run() {

    do {
      try {
        if (reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
          System.out.println(Thread.currentThread().getName() + " Got Lock performing operations");
          try {
            Thread.sleep(5000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          reentrantLock.unlock();
          break;
        } else {
          System.out.println(Thread.currentThread().getName() + " have not got Lock trying again");
        }

      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    } while (true);
  }
}
