package _21InterviewUseBathroom._01;

import java.util.LinkedHashSet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bathroom {



  private static final int CAPACITY =2;
  private static final Bathroom instance = new Bathroom(CAPACITY);

  private Gender currentGender;
  private LinkedHashSet<Person> persons;
  private int capacity;

  private final ReentrantLock lock = new ReentrantLock();
  private final Condition notFull = lock.newCondition();

  public static Bathroom getInstance() {
    return instance;
  }

  public Bathroom(int capacity) {
    this.currentGender = Gender.NONE;
    this.persons = new LinkedHashSet<>();
    this.capacity = capacity;
  }

  public boolean isFull(){
    return persons.size()==CAPACITY;
  }

  public boolean isEmpty(){
    return persons.isEmpty();
  }

  public boolean isNotEmpty(){
    return !isEmpty();
  }

  public void enter(Person person) throws InterruptedException {
    lock.lock();
    try{
      if(isEmpty()){
        this.currentGender = person.getGender();
      }

      while(isFull() || !person.getGender().equals(currentGender)){
        System.out.println(person.getName()+" Waiting");
        //wait for people to leave
        notFull.await();
      }

      if(persons.add(person)){
        System.out.println(person.getName()+ " Entered");
        System.out.println(person.getName()+ " is Bathing now");
      }
      if(isFull()){
        System.out.println("Bathroom is Full now");
      }


    }finally{
      lock.unlock();
    }

  }

  public void exit(Person person){
    lock.lock();
    try{
      if(isNotEmpty()){
        if(persons.remove(person)){
          System.out.println(person.getName()+ " is exiting");
          notFull.signalAll();
        }
        if(isEmpty()){
          currentGender = Gender.NONE;
        }
      }

    }finally{
      lock.unlock();
    }
  }



}
