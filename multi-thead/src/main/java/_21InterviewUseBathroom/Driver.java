package _21InterviewUseBathroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {

  public static void main(String[] args){
    Bathroom bathroom = Bathroom.getInstance();
    List<Person> users = new ArrayList<>();

    for(int i=0;i< 10; i++){
      if (new Random().nextInt(2) == 0) {
        // Creates man
        users.add(new Person(("Male" + i), Sex.MAN, bathroom));
      } else {
        // Creates woman
        users.add(new Person(("Female" + i), Sex.WOMEN, bathroom));
      }
    }

    users.stream().map(Thread::new).forEach(Thread::start);

    users.stream().map(Thread::new).forEach((t) -> {
      try {
        t.join();
      } catch (InterruptedException ex) {
        Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
      }
    });
  }

}
