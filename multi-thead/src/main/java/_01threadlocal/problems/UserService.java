package _01threadlocal.problems;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserService {

  Map<Integer,LocalDate> users = new HashMap<>();

  public UserService(){
    users.put(100,LocalDate.now().minusYears(20));
    users.put(102,LocalDate.now().minusYears(30));
    users.put(103,LocalDate.now().minusYears(40));
    users.put(104,LocalDate.now().minusYears(50));
    users.put(105,LocalDate.now().minusYears(60));
    users.put(106,LocalDate.now().minusYears(70));
    users.put(107,LocalDate.now().minusYears(80));
  }

  public String birthDate(int userId){
    LocalDate date = users.get(userId);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return simpleDateFormat.format(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
  }


  public static void main(String[] args){
    new Thread(()-> {
      String birthDate = new UserService().birthDate(100);
      System.out.println(birthDate);
    }).start();

    new Thread(()-> {
      String birthDate = new UserService().birthDate(102);
      System.out.println(birthDate);
    }).start();
  }


}
