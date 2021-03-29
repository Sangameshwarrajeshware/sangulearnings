package _23DiningPhilasopher;

public class Philosopher implements Runnable {

  Object leftFork;
  Object rightFork;

  public Philosopher(Object leftFork, Object rightFork) {
    this.leftFork = leftFork;
    this.rightFork = rightFork;
  }

  private void doAction(String action) throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " " + action);
    Thread.sleep(1000);
  }

  @Override
  public void run() {
    while (true) {
      try {
        doAction(System.nanoTime() + " : Thinking");
        synchronized (leftFork) {
          doAction(System.nanoTime() + " Picked up Left Fork");
          synchronized (rightFork) {
            doAction(System.nanoTime() + " Picked up Right Fork");
            doAction(System.nanoTime() + " put down right fork");
          }
          doAction(System.nanoTime() + " Put down Left Fork and Start thinking");
        }

      } catch (InterruptedException exception) {
        Thread.currentThread().interrupt();
        return;
      }
    }
  }
}
