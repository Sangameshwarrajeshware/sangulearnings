package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

  public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(4);

    PrintJob[] jobs = {
      new PrintJob("Sangu"),
      new PrintJob("mahesh"),
      new PrintJob("raj"),
      new PrintJob("ram"),
      new PrintJob("sita"),
      new PrintJob("ravan")
    };

    for (PrintJob job : jobs) {
      service.submit(job);
    }
    service.shutdown();
  }
}
