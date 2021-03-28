package _21InterviewUseBathroom.usingSemaphores;

import _21InterviewUseBathroom.Sex;

public class Person implements Runnable {

  private final String name;
  private final Sex gender;
  private boolean needBathroom;

  private final Bathroom bathroom;

  public Person(String name, Sex gender, Bathroom bathroom) {
    this.name = name;
    this.gender = gender;
    this.needBathroom = true;
    this.bathroom = bathroom;
  }

  public String getName() {
    return name;
  }

  public Sex getGender() {
    return gender;
  }

  public void useBathroom(Person person) throws InterruptedException {

    this.bathroom.enter(person);
    System.out.println(person.getName() + " is Bathing now");
    Thread.sleep(5000);
    this.bathroom.exit(person);
    this.needBathroom = false;
  }

  @Override
  public void run() {
    try {
      System.out.println(getName() + " in Queue");
      while (this.needBathroom) {
        if (this.bathroom.isEmpty()
            || (this.bathroom.isNotFull() && this.bathroom.getCurrentGender().equals(this.getGender()))) {
          useBathroom(this);
          this.notifyAll();
        }
      }

    } catch (InterruptedException exception) {
      exception.printStackTrace();
    }
  }
}
