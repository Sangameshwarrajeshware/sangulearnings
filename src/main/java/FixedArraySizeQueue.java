
public class FixedArraySizeQueue{
  private int N;
  private String[] items;
  private int first;
  private int last;

  FixedArraySizeQueue(int capacity){
    items = new String[capacity];
  }

  public boolean isEmpty(){
    return N==0;
  }

  public int size(){
    return N;
  }

  public void enqueue(String item){
    if(N!=items.length){
      if(last == items.length){
        last=0;
      }
      items[last++] = item;
      N++;
    }
  }

  public String dequeue(){
    if(isEmpty()){
      throw new RuntimeException("Queue is underflow");
    }else{
      String item = items[first];
      items[first] = null;
      first++;

      if(first == items.length){
        first = 0;
      }
      N--;
      return item;

    }
  }

}
