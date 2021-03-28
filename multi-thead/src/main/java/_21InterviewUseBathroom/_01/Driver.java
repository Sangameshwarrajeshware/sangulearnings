package _21InterviewUseBathroom._01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {
  public static void main(String[] args){

    Bathroom bathroom = Bathroom.getInstance();

    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for(int i=0 ;i<10;i++){
      if(i%2==0){
        executorService.submit(new Person("Male"+i,Gender.MALE,bathroom) );
      }else{
        executorService.submit(new Person("Female"+i,Gender.FEMALE,bathroom) );
      }

    }
    executorService.shutdown();
  }

}
