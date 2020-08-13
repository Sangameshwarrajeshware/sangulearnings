package linkedlist;

import java.util.Iterator;
import java.util.ListIterator;

public class DoubleLinkedList<Item> implements Iterable<Item>{
  private int totalItems;
  private DoubleNode first;
  private DoubleNode last;

  @Override
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class DoubleNode{
    private Item item;
    private DoubleNode previous;
    private DoubleNode next;
  }

  public int size(){
    return totalItems;
  }

  public boolean isEmpty(){
    return totalItems == 0;
  }

  public void insertAtTheBeginning(Item item){
    DoubleNode oldFirst = first;
    first = new DoubleNode();
    first.item = item;
    first.previous = null;
    first.next = oldFirst;
    if(oldFirst != null){
      oldFirst.previous = first;
    }
    if(isEmpty()){
      last = first;
    }
    totalItems++;
  }

  public void insertAtLast(Item item){
    DoubleNode oldLast = last;

    last = new DoubleNode();
    last.item = item;
    last.next = null;
    last.previous = oldLast;
    if(oldLast != null){
      oldLast.next = last;
    }
    if(isEmpty()){
      first = last;
    }
    totalItems++;
  }


  public void insertBeforeNode(Item itemBefore, Item item){
    if(isEmpty()){
      return;
    }

    DoubleNode currentNode ;
    for(currentNode = first;currentNode != null; currentNode = currentNode.next){
      if(currentNode.item.equals(itemBefore)){
        break;
      }
    }

    if(currentNode != null){
      DoubleNode newNode = new DoubleNode();
      newNode.item = item;
      DoubleNode previousNode = currentNode.previous;

      currentNode.previous = newNode;
      newNode.previous = previousNode;
      newNode.next = currentNode;
      previousNode.next = newNode;

    }
  }

  private class ListIterator<Item> implements Iterator<Item>{
    private DoubleNode currentNode;

    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public Item next() {
      return null;
    }
  }
}
