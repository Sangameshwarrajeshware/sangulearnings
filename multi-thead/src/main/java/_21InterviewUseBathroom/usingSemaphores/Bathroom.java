package _21InterviewUseBathroom.usingSemaphores;

import _21InterviewUseBathroom.Sex;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;

public class Bathroom {

  private static final int CAPACITY = 2;

  private Sex currentGender;
  private LinkedHashSet<Person> persons;

  ReentrantLock lock = new ReentrantLock();

  public Bathroom() {
    this.currentGender = Sex.NONE;
    this.persons = new LinkedHashSet<>();
  }

  public Sex getCurrentGender() {
    return currentGender;
  }

  public static Bathroom getInsatance() {
    return insatance;
  }

  public boolean isFull() {
    return persons.size() == CAPACITY;
  }

  public boolean isNotFull() {
    return !isFull();
  }

  public boolean isEmpty() {
    return persons.isEmpty();
  }

  public boolean isNotEmpty() {
    return !isEmpty();
  }

  public static final Bathroom insatance = new Bathroom();

  public void enter(Person person) {
    lock.lock();
    try {
      if (isEmpty()) {
        this.currentGender = person.getGender();
      }

      if ((isNotFull() && this.currentGender.equals(person.getGender())) && !this.persons.contains(person)) {
        if (this.persons.add(person)) {
          System.out.println(person.getName() + " Entered into Bathroom");
        }
        if (isFull()) {
          System.out.println("Bathroom is Full Now");
        }
      }
    } finally {
      lock.unlock();
    }
  }

  public void exit(Person person) {
    lock.lock();
    try {
      if (isNotEmpty()) {
        if (this.persons.remove(person)) {
          System.out.println(person.getName() + " Leaving the Bathroom");
        }

        if (isEmpty()) {
          System.out.println("Bathroom is Empty now");
          this.currentGender = Sex.NONE;
        }
      }
    } finally {
      lock.unlock();
    }
  }
}
