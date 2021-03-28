package _21InterviewUseBathroom;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Person implements Runnable {

  private final String name;
  private final Sex sex;
  private boolean needBathromm;
  private boolean canLeave;
  private final Bathroom bathroom;

  public Person(String name, Sex sex, Bathroom bathroom) {
    this.name = name;
    this.sex = sex;
    this.needBathromm = true;
    this.canLeave = false;
    this.bathroom = bathroom;
  }

  public String getName() {
    return name;
  }

  public Sex getSex() {
    return sex;
  }

  public void useBathroom() {
    this.bathroom.addUser(this);
    if (this.bathroom.isInBathroom(this)) {
      try {
        TimeUnit.SECONDS.sleep(5);
        this.canLeave = true;
        System.out.println(this.getName() + " Done");
      } catch (InterruptedException exception) {

      }
    }
  }

  public void leaveBathroom() {
    this.bathroom.removeUser(this);
    this.canLeave = false;
    this.needBathromm = false;
  }

  @Override
  public void run() {
    System.out.println(getName() + " Came to Bathroom Queue");
    while (this.needBathromm) {
      if ((this.bathroom.getCurrentSex().equals(this.getSex())
              || this.bathroom.getCurrentSex().equals(Sex.NONE))
          && !this.bathroom.isFull()
          && !this.bathroom.getUsers().contains(this)) {
        this.useBathroom();
      }

      if (this.canLeave) {
        this.leaveBathroom();
      }
    }
  }
}
