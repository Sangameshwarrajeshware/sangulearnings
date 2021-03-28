package _21InterviewUseBathroom.final_solution;

import _21InterviewUseBathroom._01.Gender;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Person implements Runnable {

  private final String name;
  private final Gender gender;
  private final Bathroom bathroom;
  private boolean needBathroom;
  private boolean canLeave;

  public Person(String name, Gender gender, Bathroom bathroom) {
    this.name = name;
    this.gender = gender;
    this.bathroom = bathroom;
    this.needBathroom = true;
    this.canLeave = false;
  }

  public String getName() {
    return name;
  }

  public Gender getGender() {
    return gender;
  }

  public void useBathroom() throws InterruptedException {
    this.bathroom.enter(this);
    if (this.bathroom.isInBathroom(this)) {
      TimeUnit.SECONDS.sleep(new Random().nextInt(1) + 1);
      this.canLeave = true;
    }
  }

  public void leaveBathroom() throws InterruptedException {
    this.bathroom.exit(this);
    this.needBathroom = false;
    this.canLeave = false;
  }

  @Override
  public void run() {
    while (this.needBathroom) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException exception) {
        exception.printStackTrace();
      }
      if ((this.bathroom.getCurrentGender().equals(this.getGender())
          || this.bathroom.getCurrentGender().equals(Gender.NONE))
          && this.bathroom.isNotFull()
          && !this.bathroom.isInBathroom(this)) {
        try {
          this.useBathroom();
        } catch (InterruptedException exception) {
          exception.printStackTrace();
        }
      }

      if (this.canLeave) {
        try {
          this.leaveBathroom();
        } catch (InterruptedException exception) {
          exception.printStackTrace();
        }
      }
    }
  }
}
