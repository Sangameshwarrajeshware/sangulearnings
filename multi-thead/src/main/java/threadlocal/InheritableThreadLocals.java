package threadlocal;

public class InheritableThreadLocals extends Thread {

  public static InheritableThreadLocal<String> inheritableThreadLocal =
      new InheritableThreadLocal<String>() {
        public String childValue(String p) {
          return "CC";
        }
      };

  public void run() {
    inheritableThreadLocal.set("PP");
    System.out.println("Parent thread value " + inheritableThreadLocal.get());

    ChildClass childClass = new ChildClass();
    childClass.start();
  }
}

class ChildClass extends Thread {

  public void run() {
    System.out.println(
        "child thread value " + InheritableThreadLocals.inheritableThreadLocal.get());
  }
}

class InheritableDemo {
  public static void main(String[] args) {
    InheritableThreadLocals inheritableThreadLocals = new InheritableThreadLocals();
    inheritableThreadLocals.start();
  }
}
