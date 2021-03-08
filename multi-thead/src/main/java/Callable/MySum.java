package Callable;

import java.util.concurrent.Callable;

public class MySum implements Callable {

  private int number;

  public MySum(int number) {
    this.number = number;
  }

  @Override
  public Object call() {
    System.out.println(
        Thread.currentThread().getName() + " responsible for calculating sum of " + number);
    int sum = 0;
    for (int i = 1; i <= number; i++) {
      sum = sum + i;
    }
    return sum;
  }
}
