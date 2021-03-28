package _21InterviewUseBathroom.usingSemaphores;

import _21InterviewUseBathroom.Sex;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    final Bathroom bathroom = Bathroom.getInsatance();

    for (int i = 0; i < 10; i++) {
      if (i % 2 == 0) {
        executorService.submit(new Person("Male" + i, Sex.MAN, bathroom));
      } else {
        executorService.submit(new Person("Female" + i, Sex.WOMEN, bathroom));
      }
    }

    executorService.shutdown();
  }
}
