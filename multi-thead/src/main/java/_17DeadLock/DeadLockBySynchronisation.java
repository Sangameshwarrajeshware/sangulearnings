package _17DeadLock;



public class DeadLockBySynchronisation {

  final static Object lockA = new Object();
  final static Object lockB = new Object();

  public static void main(String[] args){
    new ThreadA().start();
    new ThreadB().start();

  }

  public static class ThreadA extends Thread{

    public void run(){
      synchronized (lockA){
        System.out.println("Thread A is holding LockA");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException exception) {
          exception.printStackTrace();
        }

        synchronized (lockB){
          System.out.println("Thread A is holding LockA and LockB");
        }

      }
    }
  }

  public static class ThreadB extends Thread{
    public void run(){
      synchronized (lockB){
        System.out.println("ThreadB holding LockB");

        try {
          Thread.sleep(1000);
        } catch (InterruptedException exception) {
          exception.printStackTrace();
        }

        synchronized (lockA){
          System.out.println("ThreadB holding Both LockA and LockB");
        }
      }
    }
  }

}
