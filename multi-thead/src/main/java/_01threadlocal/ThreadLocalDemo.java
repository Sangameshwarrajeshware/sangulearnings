package _01threadlocal;

public class ThreadLocalDemo {

  public static void main(String[] args){
    ThreadLocal<String> threadLocal = new ThreadLocal<>();
    System.out.println(threadLocal.get());
    threadLocal.set("Sangau");
    System.out.println(threadLocal.get());
    threadLocal.remove();
    System.out.println(threadLocal.get());
  }

}
