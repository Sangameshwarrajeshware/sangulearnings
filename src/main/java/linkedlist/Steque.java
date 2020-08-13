package linkedlist;

import java.util.Iterator;
import java.util.StringJoiner;

public class Steque<Item> implements Iterable<Item>{
  private int totalItems;
  private Node first;
  private Node last;

  private class Node{
    Item item;
    Node next;
    Node previous;
  }

  public int size(){
    return totalItems;
  }

  public boolean isEmpty(){
    return totalItems == 0;
  }

  public void push(Item item){
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;

    if(oldFirst != null){
      oldFirst.previous = first;
    }else{
      last = first;
    }
    totalItems++;
  }

  public Item pop(){
    if(isEmpty()){
      return null;
    }
    Item item = first.item;
    first = first.next;
    if(first != null){
      first.previous = null;
    }else{
      last = null;
    }
    totalItems--;
    return item;
  }

  public void enqueue(Item item){
    Node oldLast = last;
     last = new Node();
    last.item = item;
    last.previous = oldLast;
    if(oldLast != null){
      oldLast.next = last;
    }else{
      first = last;
    }
    totalItems++;
  }


    public Iterator<Item> iterator() {
        return new StequeIterator();
    }

    private class StequeIterator implements Iterator<Item>{

        Node current = first;
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < totalItems;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;

            index++;

            return item;
        }
    }

    public static void main(String[] args) {
    Steque<Integer> steque = new Steque<>();
    steque.push(1);
    steque.push(2);
    steque.push(3);
    steque.pop();
    steque.enqueue(5);
    steque.enqueue(6);

    StringJoiner stequeItems = new StringJoiner(" ");
    for (int number : steque) {
        stequeItems.add(String.valueOf(number));
    }

    System.out.println("Steque items: " + stequeItems.toString());
    System.out.println("Expected: 2 1 5 6");
}

}
