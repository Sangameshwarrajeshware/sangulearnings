package _13CyclicBarrier;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{

  private final List<String> outputScrapper;
  private final CountDownLatch countDownLatch;

  public Worker(List<String> outputScrapper, CountDownLatch countDownLatch) {
    this.outputScrapper = outputScrapper;
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    // doSomework()
    outputScrapper.add("Counted Down");
    countDownLatch.countDown();
  }

}
