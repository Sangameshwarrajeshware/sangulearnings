package stack;

import linkedlist.Deque;
import java.util.Iterator;

public class TwoStackByDeque<Item> implements Iterable<Item>{
  private Deque<Item> deque;
  private int sizeStack1;
  private int sizeStack2;

  public TwoStackByDeque(){
    deque = new Deque();
  }

  public boolean isStack1Empty(){
    return sizeStack1 ==0;
  }

  public boolean isStack2Empty(){
    return sizeStack2 ==0;
  }

  public int sizeStack1(){
    return sizeStack1;
  }

  public int sizeStack2(){
    return sizeStack2;
  }

  public void pushStack1(Item item){
    deque.pushLeft(item);
    sizeStack1++;
  }

  public void pushStack2(Item item){
    deque.pushRight(item);
    sizeStack2++;
  }

  public Item popStack1(){
    if(isStack1Empty()){
      throw new RuntimeException("stack1 is underflow");
    }
    sizeStack1--;
    return deque.popLeft();
    }

    public Item popStack2(){
      if(isStack2Empty()){
        throw new RuntimeException("stack2 is underflow");
      }
      sizeStack2--;
      return deque.popRight();
    }

    @Override
    public Iterator<Item> iterator(){
      return new TwoStackByDequeIterator();
    }

    private class TwoStackByDequeIterator<Item> implements Iterator<Item>{
      private int index =0;
      private Item[] items ;
      private boolean hasNext;

      public TwoStackByDequeIterator(){
        int currentIndex=0;
        items = (Item[])new Object[deque.size()];
        hasNext = true;
          for(Object item : deque){
            items[currentIndex]=(Item) item;
            currentIndex++;
          }
        if(isStack1Empty() && !isStack2Empty()){
            index = deque.size() -1;
          }
      }

      @Override
      public boolean hasNext(){
        return hasNext;
      }
      @Override
      public Item next(){
        if(index ==0 && sizeStack1() > 0){
          System.out.println("Stack1");
        }
        if(index == deque.size()-1 && sizeStack2() >0){
          System.out.println("Stack 2");
        }

        Item item = items[index];

        if(isStack1Iterating(index)){
          if(index != sizeStack1()-1){
            index++;
          }else if(!isStack2Empty()){
            index = deque.size()-1;
          }else{
            hasNext = false;
          }
        }else{
          if(index != sizeStack1()){
            index--;
          }else{
            hasNext = false;
          }
        }
        return item;

      }

      private boolean isStack1Iterating(int index){
        return index < sizeStack1();
      }
    }

  public static void main(String[] args) {
    TwoStackByDeque<String> deque = new TwoStackByDeque<>();

    deque.testPushStack1();
    deque.testPushStack2();
    deque.testPopStack1();
    deque.testPopStack2();
    deque.testMixedOperations();
  }

  private void testPushStack1() {
    TwoStackByDeque<String> deque = new TwoStackByDeque<>();
    deque.pushStack1("a");
    deque.pushStack1("b");
    deque.pushStack1("c");

    System.out.println("Test Push on stack 1:");
    for (String item : deque) {
      System.out.println(item);
    }

    System.out.println("Expected: c b a");
    System.out.println();
  }

  private void testPushStack2() {
    TwoStackByDeque<String> deque = new TwoStackByDeque<>();
    deque.pushStack2("a");
    deque.pushStack2("b");
    deque.pushStack2("c");

    System.out.println("Test Push on stack 2:");
    for (String item : deque) {
      System.out.println(item);
    }

    System.out.println("Expected: c b a");
    System.out.println();
  }

  private void testPopStack1() {
    TwoStackByDeque<String> deque = new TwoStackByDeque<>();
    deque.pushStack1("a");
    deque.pushStack1("b");
    deque.pushStack1("c");

    deque.popStack1();
    deque.popStack1();

    System.out.println("Test Pop on stack 1:");
    for (String item : deque) {
      System.out.println(item);
    }

    System.out.println("Expected: a");
    System.out.println();
  }

  private void testPopStack2() {
    TwoStackByDeque<String> deque = new TwoStackByDeque<>();
    deque.pushStack2("a");
    deque.pushStack2("b");
    deque.pushStack2("c");

    deque.popStack2();
    deque.popStack2();

    System.out.println("Test Pop on stack 2:");
    for (String item : deque) {
      System.out.println(item);
    }

    System.out.println("Expected: a");
    System.out.println();
  }

  private void testMixedOperations() {
    TwoStackByDeque<String> deque = new TwoStackByDeque<>();
    deque.pushStack1("rene");
    deque.pushStack2("a");
    deque.pushStack1("stack");
    deque.pushStack2("b");
    deque.pushStack1("deque");
    deque.pushStack2("c");

    System.out.println("Test stack 1 and stack 2 together:");
    for (String item : deque) {
      System.out.println(item);
    }

    System.out.println("Expected: Stack 1 - deque stack rene");
    System.out.println("Expected: Stack 2 - c b a");

    System.out.println();
    System.out.println("Test stack 1 and stack 2 after pop:");

    deque.popStack1();
    deque.popStack2();

    for (String item : deque) {
      System.out.println(item);
    }

    System.out.println("Expected: Stack 1 - stack rene");
    System.out.println("Expected: Stack 2 - b a");
  }
}
