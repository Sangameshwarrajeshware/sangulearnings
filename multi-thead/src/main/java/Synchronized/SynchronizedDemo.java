package Synchronized;

public class SynchronizedDemo {
  public  static  void main(String[] args){

    Display display= new Display();
    MyThread t1 = new MyThread(display,"Kohli");
    MyThread t2 = new MyThread(display,"ABD");

    t1.start();
    t2.start();

  }
}
