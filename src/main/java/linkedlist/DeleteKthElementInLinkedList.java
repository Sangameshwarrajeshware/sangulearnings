import java.util.Iterator;
import java.util.StringJoiner;

public class DeleteKthElementInLinkedList<Item> implements Iterable<Item>{

  private class Node{
    Item item;
    Node next;
  }

  private int numberOfElements;
  private Node first;

  public boolean isEmpty(){
    return numberOfElements == 0;
  }

  public int size(){
    return numberOfElements;
  }

  public void add(Item item){
    if(isEmpty()){
      first = new Node();
      first.item = item;
    }else{
      Node currentNode ;
      for(currentNode=first;currentNode.next!=null;currentNode=currentNode.next);
      Node newNode = new Node();
      newNode.item = item;
      currentNode.next = newNode;
    }
    numberOfElements++;
  }

  public void deleteLastNode(){
    if(!isEmpty()){
      if(size()==1){
        first = null;
      }else{
        Node currentNode = first;
        for(int i=0; i< numberOfElements-2; i++){
          currentNode = currentNode.next;
        }
        currentNode.next = null;
      }
      numberOfElements--;
    }
  }

  public void delete(int k){
    if(numberOfElements < k || isEmpty()){
      throw new RuntimeException("Number of elements are less than k");
    }else{
        if(k==1){
          first = first.next;
        }
      
        Node currentNode = first;
        for(int i=0; i < k-1; i++){
          currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
    }
    numberOfElements--;
  }

  @Override
  public Iterator<Item> iterator()
  {
    return new ListIterator();
  }


  private class ListIterator<Item> implements Iterator<Item>{
     Node current;

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

  public static void main(String[] args) {
    DeleteKthElementInLinkedList<Integer> linkedList = new DeleteKthElementInLinkedList<>();
    linkedList.add(0);
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);

    System.out.println("Before removing second node");

    StringJoiner listBeforeRemove = new StringJoiner(" ");
    for (int number : linkedList) {
      listBeforeRemove.add(String.valueOf(number));
    }

    System.out.println(listBeforeRemove.toString());
    System.out.println("Expected: 0 1 2 3");

    linkedList.delete(2);

    System.out.println("\nAfter removing second node");
    StringJoiner listAfterRemove = new StringJoiner(" ");
    for (int number : linkedList) {
      listAfterRemove.add(String.valueOf(number));
    }

    System.out.println(listAfterRemove.toString());
    System.out.println("Expected: 0 2 3");
  }
}
