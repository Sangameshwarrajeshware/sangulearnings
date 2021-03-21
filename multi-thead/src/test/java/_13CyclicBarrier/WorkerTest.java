package _13CyclicBarrier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class WorkerTest {

  @Test
  void whenParallelProcessing_mainThreadWillbeBlockedUntilCompletion() throws InterruptedException {

    List<String> outputScrapper = Collections.synchronizedList(new ArrayList<>());
    CountDownLatch countDownLatch = new CountDownLatch(5);

    List<Thread> workers =
        Stream.generate(() -> new Thread(new Worker(outputScrapper, countDownLatch)))
            .limit(5)
            .collect(Collectors.toList());

    workers.forEach(Thread::start);
    countDownLatch.await();
    outputScrapper.add("Latch Released");

    List<String> expected = new ArrayList<>();
    expected.add("Counted Down");
    expected.add("Counted Down");
    expected.add("Counted Down");
    expected.add("Counted Down");
    expected.add("Counted Down");
    expected.add("Latch Released");
    assertEquals(expected, outputScrapper);
  }
}
