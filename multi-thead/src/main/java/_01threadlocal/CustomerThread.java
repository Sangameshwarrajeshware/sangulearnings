package _01threadlocal;

public class CustomerThread extends Thread {

  static Integer customerId = 0;
  private static final ThreadLocal<Integer> threadLocal =
      ThreadLocal.withInitial(() -> ++customerId);

  CustomerThread(String name) {
    super(name);
  }

  public void run() {
    System.out.println(
        Thread.currentThread().getName() + " executing with Customer id " + threadLocal.get());
  }
}

class Demo {
  public static void main(String[] args) {
    CustomerThread customerThread1 = new CustomerThread("Customer thread -1");
    CustomerThread customerThread2 = new CustomerThread("Customer thread -2");
    CustomerThread customerThread3 = new CustomerThread("Customer thread -3");
    CustomerThread customerThread4 = new CustomerThread("Customer thread -4");

    customerThread1.start();
    customerThread2.start();
    customerThread3.start();
    customerThread4.start();
  }
}
