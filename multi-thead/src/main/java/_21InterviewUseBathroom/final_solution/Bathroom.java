package _21InterviewUseBathroom.final_solution;

import _21InterviewUseBathroom._01.Gender;
import java.util.LinkedHashSet;
import java.util.concurrent.Semaphore;

public class Bathroom {

  private static final int CAPACITY = 5;

  public static  Bathroom instance = new Bathroom(CAPACITY);

  private Gender currentGender;
  private  LinkedHashSet<Person> persons;
  private  Semaphore semaphore;
  private  Semaphore enterSemaphore;
  private  Semaphore exitSemaphore;
  private final int capacity;

  public Bathroom(int capacity) {
    this.capacity = capacity;
    this.currentGender = Gender.NONE;
    this.persons = new LinkedHashSet<>();
    this.semaphore = new Semaphore(this.capacity, true);
    this.enterSemaphore = new Semaphore(1, true);
    this.exitSemaphore = new Semaphore(1, true);

  }

  public Gender getCurrentGender() {
    return currentGender;
  }

  public static Bathroom getInstance() {
    return instance;
  }

  public boolean isEmpty() {
    return this.persons.isEmpty();
  }

  public boolean isNotEmpty() {
    return !this.isEmpty();
  }

  public boolean isFull() {
    return this.persons.size() == this.capacity;
  }

  public boolean isNotFull() {
    return !isFull();
  }

  public boolean isInBathroom(Person person) {
    return this.persons.contains(person);
  }

  public boolean isNotInBathroom(Person person) {
    return !isInBathroom(person);
  }

  public void enter(Person person) throws InterruptedException {
    this.semaphore.acquire();
    if (isEmpty()) {
      this.currentGender = person.getGender();
    }

    if (isNotFull()
        && currentGender.equals(person.getGender())
        && this.isNotInBathroom(person)) {
      this.enterSemaphore.acquire();
      if (persons.add(person)) {
        System.out.println(person.getName() + " Entered into Bathroom");
      }
      this.enterSemaphore.release();
      if (isFull()) {
        System.out.println("Bathrom is Full");
      }

    }
  }

  public void exit(Person person) throws InterruptedException {
    this.semaphore.release();
    if (isNotEmpty()) {
      this.exitSemaphore.acquire();
      if (this.persons.remove(person)) {
        System.out.println(person.getName() + " exiting");
      }
      this.exitSemaphore.release();
      if (this.isEmpty()) {
        this.currentGender = Gender.NONE;
        System.out.println("BathRoom is Empty");
      }
    }
  }
}
