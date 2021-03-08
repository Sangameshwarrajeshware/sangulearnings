package reentrantlock.trylockwithtime;

public class TryLockWithtimeDemo {

  public static void main(String[] args){
    TryLockWithTimeThread tryLockWithTimeThread1 = new TryLockWithTimeThread("First Thread");
    TryLockWithTimeThread tryLockWithTimeThread2 = new TryLockWithTimeThread("Second Thread");

    tryLockWithTimeThread1.start();
    tryLockWithTimeThread2.start();
  }

}
