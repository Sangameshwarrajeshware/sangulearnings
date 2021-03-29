package _22uberrideproblem;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    final UberRide uberRide = new UberRide();

    Set<Thread> allThreads = new HashSet<>();

    for(int i=0;i<10;i++){
      Thread thread = new Thread(()-> {
        try {
          uberRide.seatDemocaticans();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        } catch (InterruptedException exception) {
          exception.printStackTrace();
        }
      });
      thread.setName("Democraticans "+(i+1));

      allThreads.add(thread);
      Thread.sleep(20);
    }

    for(int i=0;i<14;i++){
      Thread thread = new Thread(()-> {
        try {
          uberRide.seatRepublicans();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        } catch (InterruptedException exception) {
          exception.printStackTrace();
        }
      });
      thread.setName("Republicans "+(i+1));
      allThreads.add(thread);
      Thread.sleep(20);
    }

    for(Thread thread : allThreads){
      thread.start();
    }

    for (Thread thread : allThreads){
      thread.join();
    }

  }

}
