package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example1 {


  public static  void main(String[] args){
    int cores = Runtime.getRuntime().availableProcessors();
    ExecutorService executorService = Executors.newFixedThreadPool(cores);

    for(int i=0;i<100;i++){
      executorService.submit(new Task());
    }
    System.out.println(cores);
  }

  static class Task implements Runnable{

    @Override
    public void run() {

    }
  }

}
