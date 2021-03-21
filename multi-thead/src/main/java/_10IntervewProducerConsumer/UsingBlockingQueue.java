package _10IntervewProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UsingBlockingQueue {

  public static void main(String[] args){

    BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(10);


    final Runnable producer = () -> {
      while (true){
        try {
          blockingQueue.put(new Object());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };


    new Thread(producer).start();


    final Runnable consumer = () -> {
      while(true){
        try {
          Object ob = blockingQueue.take();
          //Process the object ob
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };


    new Thread(consumer).start();
  }

}
