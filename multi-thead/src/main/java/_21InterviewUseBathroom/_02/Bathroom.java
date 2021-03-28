package _21InterviewUseBathroom._02;

import _21InterviewUseBathroom._01.Gender;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;

public class Bathroom {

  private static final int CAPACITY = 5;

  public static final Bathroom instance = new Bathroom(CAPACITY);

  private Gender currentGender;
  private final LinkedHashSet<Person> persons;
  private final int size;

  public Gender getCurrentGender() {
    return currentGender;
  }

  private final ReentrantLock lock = new ReentrantLock();

  public Bathroom(int size) {
    this.currentGender = Gender.NONE;
    this.persons = new LinkedHashSet<>();
    this.size = size;
  }

  public static Bathroom getInstance() {
    return instance;
  }

  public boolean isEmpty() {
    return this.persons.isEmpty();
  }

  public boolean isNotEmpty(){
    return !this.isEmpty();
  }

  public boolean isFull() {
    return this.persons.size() == this.size;
  }

  public boolean isNotFull() {
    return !this.isFull();
  }

  public boolean isInBathroom(Person person) {
    return this.persons.contains(person);
  }

  public void enter(Person person) {
    lock.lock();
    try {
      if (isEmpty()) {
        this.currentGender = person.getGender();
      }
      if (isNotFull()
          && this.currentGender.equals(person.getGender())
          && !this.isInBathroom(person)) {
        if (this.persons.add(person)) {
          System.out.println(person.getName() + " is Entered into Bathroom");
        }
        if (isFull()) {
          System.out.println("Bathroom is Full now");
        }
      }

    } finally {
      lock.unlock();
    }
  }

  public void exit(Person person){
    lock.lock();
    try{
      if(this.isNotEmpty()){
        if(this.persons.remove(person)){
          System.out.println(person.getName()+ " is Leaving Bathroom");
        }
        if(isEmpty()){
          this.currentGender = Gender.NONE;
        }
      }
    }finally{
      lock.unlock();
    }
  }
}
