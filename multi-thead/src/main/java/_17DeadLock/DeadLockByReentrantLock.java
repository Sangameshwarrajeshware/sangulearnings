package _17DeadLock;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockByReentrantLock {

  ReentrantLock lockA = new ReentrantLock();
  ReentrantLock lockB = new ReentrantLock();

  public static  void main(String[] args){
    DeadLockByReentrantLock deadLockByReentrantLock = new DeadLockByReentrantLock();
    deadLockByReentrantLock.execute();
  }

  public void execute(){
    new Thread(() -> {
      try {
        processThis();
      } catch (InterruptedException exception) {
        exception.printStackTrace();
      }
    }).start();
    new Thread(() -> {
      try {
        processThat();
      } catch (InterruptedException exception) {
        exception.printStackTrace();
      }
    }).start();
  }

  private void processThis() throws InterruptedException {
    lockA.lock();
    lockB.lock();
    Thread.sleep(1000);
    lockB.unlock();
    lockA.unlock();

  }

  private void processThat() throws InterruptedException {
    lockB.lock();
    lockA.lock();
    Thread.sleep(1000);
    lockA.unlock();
    lockB.unlock();
  }



}
