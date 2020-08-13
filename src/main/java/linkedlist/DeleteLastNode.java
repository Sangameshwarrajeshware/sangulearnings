import java.util.Iterator;

public class DeleteLastNode<Item> implements Iterable<Item> {

  @Override
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class Node {
    Item item;
    Node next;
  }

  private int n;
  private Node first;

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public void addItem(Item item) {
    if (isEmpty()) {
      first = new Node();
      first.item = item;
    } else {
      Node currentNode;
      for (currentNode = first; currentNode.next != null; currentNode = currentNode.next) ;

      Node newNode = new Node();
      newNode.item = item;
      currentNode.next = newNode;
    }
    n++;

  }

  public void deleteLastNode(){
    if(!isEmpty()){
      if(n==1){
        first = null;
      }else{
        Node currentNode = first;
        for(int i = 0; i < n-2; i++){
          currentNode = currentNode.next;
        }
        currentNode.next = null;
      }
        n--;
    }
  }

  private class ListIterator implements Iterator<Item>{
    private Node current = first;

    @Override
    public boolean hasNext(){
      return current != null;
    }

    @Override
    public Item next(){
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

}
