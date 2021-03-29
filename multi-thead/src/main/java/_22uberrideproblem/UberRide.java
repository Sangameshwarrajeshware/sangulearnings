package _22uberrideproblem;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class UberRide {
  private int democratics = 0;
  private int repulicans = 0;

  Semaphore democraticWaiting = new Semaphore(0);
  Semaphore repblicansWaiting = new Semaphore(0);

  CyclicBarrier barrier = new CyclicBarrier(4, () -> System.out.println("Barrier Opening"));
  ReentrantLock lock = new ReentrantLock();

  public void seatDemocaticans() throws BrokenBarrierException, InterruptedException {
    boolean ride = false;
    lock.lock();
    democratics++;
    if (democratics == 4) {
      ride = true;
      democratics -= 4;
      democraticWaiting.release(3);
    } else if (democratics == 2 && repulicans >= 2) {
      ride = true;
      democratics -= 2;
      repulicans -= 2;
      democraticWaiting.release(1);
      repblicansWaiting.release(2);
    } else {
      lock.unlock();
      democraticWaiting.acquire();
    }
    seated();
    barrier.await();
    if (ride) {
      drive();
      lock.unlock();
    }
  }

  public void seatRepublicans() throws BrokenBarrierException, InterruptedException {
    boolean ride = false;
    lock.lock();
    repulicans++;
    if (repulicans == 4) {
      ride = true;
      repulicans -= 4;
      repblicansWaiting.release(3);
    } else if (repulicans == 2 && democratics >= 2) {
      ride = true;
      democratics -= 2;
      repulicans -= 2;
      repblicansWaiting.release(1);
      democraticWaiting.release(2);
    } else {
      lock.unlock();
      repblicansWaiting.acquire();
    }
    seated();
    barrier.await();
    if (ride) {
      drive();
      lock.unlock();
    }
  }

  private void drive() {
    System.out.println(
        "Uber Ride on Its way... with ride leader " + Thread.currentThread().getName());
  }

  private void seated() {
    System.out.println(Thread.currentThread().getName() + " is Seated");
  }
}
