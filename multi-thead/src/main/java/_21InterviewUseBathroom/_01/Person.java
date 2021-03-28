package _21InterviewUseBathroom._01;

public class Person implements Runnable{

  private final String name;
  private final Gender gender;
  private final Bathroom bathroom;

  public Person(String name, Gender gender,Bathroom bathroom) {
    this.name = name;
    this.gender = gender;
    this.bathroom = bathroom;
  }

  public String getName() {
    return name;
  }

  public Gender getGender() {
    return gender;
  }

  @Override
  public void run() {
    try {
      System.out.println(this.getName()+" in Queue");
      bathroom.enter(this);
      //Thread.sleep(10000);
      bathroom.exit(this);
      System.out.println(this.getName()+" in Done");
    } catch (InterruptedException exception) {
      exception.printStackTrace();
    }

  }
}
