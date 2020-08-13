package linkedlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

public class LinkedListProblem<Item> implements Iterable<Item> {

  private class Node {
    Item item;
    Node next;
  }

  private int totalItems;
  private Node first;

  public Node createNode(Item item) {
    Node node = new Node();
    node.item = item;
    return node;
  }

  public boolean isEmpty() {
    return totalItems == 0;
  }

  public int size() {
    return totalItems;
  }

  public void add(Item item) {
    if (size() == 0) {
      first = new Node();
      first.item = item;
    } else {
      Node current;
      for (current = first; current.next != null; current = current.next) ;
      Node newNode = new Node();
      newNode.item = item;
      current.next = newNode;
    }
    totalItems++;
  }

  public void removeAfter(Node node) {
    if(size() == 0 || node == null){
      return ;
    }
    Node current;
    for (current = first; current != null; current = current.next) {
      if (current.item.equals(node.item)) {
        if (current.next != null) {
          current.next = current.next.next;
          totalItems--;
        }
      }
      break;
    }
  }

  public void insertAfter(Node node,Node toBeInsert){
    if(size() == 0 || node == null || toBeInsert == null){
      return ;
    }

    Node current;
    for(current= first; current != null; current = current.next){
      if(current.item.equals(node.item)){
        toBeInsert.next = current.next;
        current.next = toBeInsert;
        totalItems ++ ;
        break;
      }
    }
  }


  public void remove(Item key){
    if(size() == 0 || key == null){
      return ;
    }

    while(first!=null &&  first.item.equals(key)){
      first = first.next;
      totalItems--;
    }

    Node current;
    for(current = first; current != null; current = current.next){
      Node next = current.next;
      while(next!=null && next.item.equals(key)){
        next = next.next;
        totalItems--;
      }
      current.next = next;

    }
  }


  public int max(){
    if(size()==0){
      return 0;
    }

    int max = (Integer) first.item;
    Node current;
    for(current = first.next ; current != null; current = current.next){
      if((Integer)current.item > max){
        max = (Integer) current.item;
      }
    }
    return max;
  }


  public int maxValue(){
    if(size()==0){
      return 0;
    }

    int max = (Integer) first.item;
    return getMax(first.next,max);
  }

  private int getMax(Node current,Integer max){
    if(current == null){
      return max;
    }
    if((Integer)current.item > max ){
      max = (Integer) current.item;
    }
    return getMax(current.next,max);

  }

  @Override
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    Node current = first;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  public static void main(String[] args) {
    LinkedListProblem<Integer> linkedList = new LinkedListProblem<>();
    linkedList.add(0);
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(4);

    System.out.println("Before removing node after node 0");

    List<Integer> listBeforeRemove = new ArrayList<>();
    for (int number : linkedList) {
      listBeforeRemove.add(number);
    }

    System.out.println(listBeforeRemove.toString());
    System.out.println("Expected: 0 1 2 3 4");

    LinkedListProblem<Integer>.Node nodeToBeDeleted = linkedList.createNode(0);
    linkedList.removeAfter(nodeToBeDeleted);

    System.out.println("\nAfter removing node after node 0");

    List<Integer> listAfterRemove = new ArrayList<>();
    for (int number : linkedList) {
      listAfterRemove.add(number);
    }

    System.out.println(listAfterRemove.toString());
    System.out.println("Expected: 0 2 3 4");


    System.out.println("Before inserting node 99 (after node 2)");

    StringJoiner listBeforeInsert = new StringJoiner(" ");
    for (int number : linkedList) {
      listBeforeInsert.add(String.valueOf(number));
    }

    System.out.println(listBeforeInsert.toString());
    System.out.println("Expected: 0 1 2 3 4");

    LinkedListProblem<Integer>.Node nodeOfReference = linkedList.createNode(2);
    LinkedListProblem<Integer>.Node nodeToBeInserted = linkedList.createNode(99);
    linkedList.insertAfter(nodeOfReference, nodeToBeInserted);

    System.out.println("\nAfter inserting node 99 (after node 2)");

    StringJoiner listAfterInsert = new StringJoiner(" ");
    for (int number : linkedList) {
      listAfterInsert.add(String.valueOf(number));
    }

    System.out.println(listAfterInsert.toString());
    System.out.println("Expected: 0 1 2 99 3 4");



    LinkedListProblem<String> removeLinkedlist = new LinkedListProblem<>();
    removeLinkedlist.add("Mark");
    removeLinkedlist.add("Bill");
    removeLinkedlist.add("Elon");
    removeLinkedlist.add("Rene");
    removeLinkedlist.add("Mark");
    removeLinkedlist.add("Mark");
    removeLinkedlist.add("Mark");
    removeLinkedlist.add("Elon");

    System.out.println("Before removing Mark");

    StringJoiner listBeforeRemove1 = new StringJoiner(" ");
    for (String name : removeLinkedlist) {
      listBeforeRemove1.add(name);
    }

    System.out.println(listBeforeRemove1.toString());
    System.out.println("Expected: Mark Bill Elon Rene Mark Mark Mark Elon");

    String itemToBeRemoved = "Mark";
    removeLinkedlist.remove(itemToBeRemoved);

    System.out.println("\nAfter removing Mark");

    StringJoiner listAfterRemove2 = new StringJoiner(" ");
    for (String name : removeLinkedlist) {
      listAfterRemove2.add(name);
    }

    System.out.println(listAfterRemove2.toString());
    System.out.println("Expected: Bill Elon Rene Elon");


    LinkedListProblem<Integer> linkedlistProblem = new LinkedListProblem<>();
    linkedlistProblem.add(3);
    linkedlistProblem.add(91);
    linkedlistProblem.add(2);
    linkedlistProblem.add(9);

    int maxValue = linkedlistProblem.max();
    System.out.println("Max value: " + maxValue);
    System.out.println("Expected: 91");
  }

}
