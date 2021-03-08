package Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    MySum[] jobs = {
      new MySum(10), new MySum(20), new MySum(30), new MySum(40), new MySum(50), new MySum(60)
    };

    ExecutorService executorService = Executors.newFixedThreadPool(4);

    for (MySum job : jobs){
      Future<Integer> future = executorService.submit(job);
      System.out.println(future.get());
    }
  }
}
