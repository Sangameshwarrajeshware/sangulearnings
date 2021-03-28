package _21InterviewUseBathroom;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class Bathroom {

  private final static int CAPACITY=2;

  ReentrantLock lock = new ReentrantLock();

  private static final Bathroom instance = new Bathroom(CAPACITY);

  private int capacity;
  private Sex currentSex;
  private LinkedHashSet<Person> users;

  public static Bathroom getInstance(){
    return instance;
  }

  public Bathroom(int capacity) {
    this.capacity = capacity;
    this.currentSex = Sex.NONE;
    this.users = new LinkedHashSet<>();
  }

  public boolean isFull(){
    return this.users.size()== this.capacity;
  }

  public boolean isEmpty(){
    return this.users.isEmpty();
  }

  public void addUser(Person user){
    lock.lock();
    try{
      if(users.isEmpty()){
        this.currentSex = user.getSex();
      }
      //Check if bathroom is full
      if(!this.isFull() && !this.users.contains(user) && this.currentSex.equals(user.getSex())){
        if(this.users.add(user)){
          System.out.println(user.getName()+" Entered into Bathroom");
        }
        if(isFull()){
          System.out.println("Bathroom is Full");
        }
      }
    }finally{
      lock.unlock();
    }
  }

  public boolean isInBathroom(Person person){
    return this.users.contains(person);
  }

  public Sex getCurrentSex(){
    return this.currentSex;
  }

  public Set<Person> getUsers(){
    return this.users;
  }


  public void removeUser(Person person){
    this.lock.lock();
    try{
      if(!this.isEmpty()){
        if(users.remove(person)){
          System.out.println(person.getName() +  " left the bathroom");
        }
        if(this.isEmpty()){
          System.out.println("Bathroom is Empty");
          this.currentSex = Sex.NONE;
        }
      }
    }finally{
      this.lock.unlock();
    }
  }
}
