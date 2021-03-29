package _23DiningPhilasopher;

public class Main {

  public static void main(String[] args) {
    Philosopher[] philosophers = new Philosopher[5];
    Object[] forks = new Object[philosophers.length];

    for (int i = 0; i < philosophers.length; i++) {
      forks[i] = new Object();
    }

    for (int i = 0; i < philosophers.length; i++) {
      Object leftFork = forks[i];
      Object rightFork = forks[(i + 1) % forks.length];

      if (i == forks.length - 1) {
        philosophers[i] = new Philosopher(rightFork, leftFork);
      } else {
        philosophers[i] = new Philosopher(leftFork, rightFork);
      }

      Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
      t.start();
    }
  }
}
