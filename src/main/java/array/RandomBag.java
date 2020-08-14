package array;

import java.util.Iterator;
import java.util.Random;
import java.util.StringJoiner;

public class RandomBag<Item> implements Iterable<Item>{

  private Item[] array;
  private int size;

  public RandomBag(){
    array = (Item[])new Object[1];
    size = 0;
  }

  public boolean isEmpty(){
    return size ==0;
  }

  public int size(){
    return size;
  }

  public void add(Item item){
    if(size == array.length){
      resize(array.length*2);
    }
    array[size] = item;
    size++;
  }


  private void resize(int newLength){
    Item[] newArray = (Item[])new Object[newLength];
    for(int i =0; i< size(); i++){
      newArray[i] = array[i];
    }
    array = newArray;
  }

  @Override
  public Iterator iterator(){
    return new  RandomBagIterator();
  }

  private class RandomBagIterator<Item> implements Iterator<Item>{
    int index ;
    Item[] arrayCopy;

    public RandomBagIterator(){
      index =0;
      arrayCopy = (Item[]) new Object[size];
      for(int i=0;i<size;i++){
        arrayCopy[i] = (Item) array[i];
      }
      sortArrayCopy();
    }

    private void sortArrayCopy(){
      Random random = new Random(System.currentTimeMillis());
      for(int i=0;i<size;i++){
        int randomIndex = random.nextInt(size-1);
        Item item = arrayCopy[i];
        arrayCopy[i] = arrayCopy[randomIndex];
        arrayCopy[randomIndex] =item;

      }

    }

    @Override
    public boolean hasNext(){
      return index < size;
    }

    public Item next(){
      Item item = arrayCopy[index];
      index++;
      return item;
    }
  }

  public static void main(String[] args) {
    RandomBag<Integer> randomBag = new RandomBag<>();
    randomBag.add(1);
    randomBag.add(2);
    randomBag.add(3);
    randomBag.add(4);
    randomBag.add(5);
    randomBag.add(6);
    randomBag.add(7);
    randomBag.add(8);

    System.out.print("Random bag items: ");

    StringJoiner randomBagItems = new StringJoiner(" ");
    for (int item : randomBag) {
      randomBagItems.add(String.valueOf(item));
    }

    System.out.println(randomBagItems.toString());
  }
}
