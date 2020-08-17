package linkedlist;

import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class MoveToFront<Item> implements Iterable<Item>{
  private class Node{
    Item item;
    Node next;
  }
  private int size;
  private Node first;

  private Set<Item> existingCharacter;

  public MoveToFront(){
    existingCharacter = new HashSet<Item>();
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public int size(){
    return size;
  }

  public void insert(Item item){
    if(existingCharacter.contains(item)){
      delete(item);
    }
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    existingCharacter.add(item);
    size++;

  }

  private void delete(Item item){
    if(isEmpty()){
      return ;
    }
    Node current = first;

    if(current.item.equals(item)){
      first = first.next;
      size--;
    }else{
      for(current=first;current.next!=null;current=current.next){
        if(current.next.item.equals(item)){
          break;
        }
      }
      if(current.next!=null){
        current.next = current.next.next;
        size--;
      }
    }
  }

  public Iterator<Item> iterator(){
    return new MoveToFrontIterator();
  }

  private class MoveToFrontIterator<Item> implements Iterator<Item>{
    private Node current = first;

    @Override
    public boolean hasNext(){
      return current != null;
    }

    @Override
    public Item next(){
      Item item = (Item) current.item;
      current = current.next;
      return item;
    }
  }

  public static void main (String[] args) {
    MoveToFront<Character> moveToFront = new MoveToFront<>();

    // Test data
            moveToFront.insert('a');
            moveToFront.insert('b');
            moveToFront.insert('c');
            moveToFront.insert('d');
            moveToFront.insert('c');
            moveToFront.insert('d');
            moveToFront.insert('z');

    StringJoiner list = new StringJoiner(" ");

    for (char character : moveToFront) {
      list.add(String.valueOf(character));
    }

    System.out.println("Characters: " + list.toString());
    // StdOut.println("Expected: z d c b a");
  }
}
