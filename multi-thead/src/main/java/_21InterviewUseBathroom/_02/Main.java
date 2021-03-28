package _21InterviewUseBathroom._02;

import _21InterviewUseBathroom._01.Gender;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

  public static void main(String[] args) {
    Bathroom bathroom = Bathroom.getInstance();

    List<Person> users = new ArrayList<>();
    // Creates people
    for (int i = 0; i < ((new Random()).nextInt(10) + 15); i++) {
      // Creates man and woman
      if (new Random().nextInt(2) == 0) {
        // Creates man
        users.add(new Person(("Male" + i), Gender.MALE, bathroom));
      } else {
        // Creates woman
        users.add(new Person(("Female" + i), Gender.FEMALE, bathroom));
      }
    }
    users.stream().map(Thread::new).forEach(Thread::start);
    users.stream()
        .map(Thread::new)
        .forEach(
            (t) -> {
              try {
                t.join();
              } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
              }
            });
  }
}
