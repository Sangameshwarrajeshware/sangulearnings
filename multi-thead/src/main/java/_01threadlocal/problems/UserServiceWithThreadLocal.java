package _01threadlocal.problems;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserServiceWithThreadLocal {

  private static final ExecutorService threadPool = Executors.newFixedThreadPool(10);

  Map<Integer, LocalDate> users = new HashMap<>();

  public UserServiceWithThreadLocal() {
    users.put(100, LocalDate.now().minusYears(20));
    users.put(101, LocalDate.now().minusYears(25));
    users.put(102, LocalDate.now().minusYears(30));
    users.put(103, LocalDate.now().minusYears(40));
    users.put(104, LocalDate.now().minusYears(50));
    users.put(105, LocalDate.now().minusYears(60));
    users.put(106, LocalDate.now().minusYears(70));
    users.put(107, LocalDate.now().minusYears(80));
  }

  public String birthDate(int userId) {
    LocalDate date = users.get(userId);
    return ThreadSafeFormatter.df
        .get()
        .format(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
  }

  public static void main(String[] args) {

    for (int i = 100; i < 1200; i++) {
      int id = i;
      threadPool.submit(
          () -> {
            String date = new UserServiceWithThreadLocal().birthDate(id);
            System.out.println(date);
          });
    }
  }

  static class ThreadSafeFormatter {
    public static final ThreadLocal<SimpleDateFormat> df =
        ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
  }
}
