package _01threadlocal;

public class OverridingInitialValue {

  public static void main(String[] args){

    // 1.5 version style
//    ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
//      public String initialValue(){
//        return "abc";
//      }
//    };

    //1.8 version style
    ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "abc");

    System.out.println(threadLocal.get());
    threadLocal.set("Sangau");
    System.out.println(threadLocal.get());
    threadLocal.remove();
    System.out.println(threadLocal.get());
  }

}
