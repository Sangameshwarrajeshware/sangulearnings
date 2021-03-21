package _01threadlocal.usecase2;

public class Example1 {


  static class  UserContextHolder{
    public static ThreadLocal<Object> holder = new ThreadLocal<>();
  }

  class Service1{
    public void process(){
      Object ob  = new Object();
      UserContextHolder.holder.set(ob); // set it user for this thread

    }
  }


  class Service2{
    public void process(){
      Object ob = UserContextHolder.holder.get();// use it whenever we want

    }
  }

  class LastService{
    public void process(){
      UserContextHolder.holder.remove();// ensure that clear it once the request comes to end
    }
  }

}
