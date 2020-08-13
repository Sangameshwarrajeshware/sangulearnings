import org.junit.Test;

import java.util.StringJoiner;

public class DeleteKthElementInLinkedListTest {

  @Test
  public void testDeleteLastNode() {

    DeleteKthElementInLinkedList<Integer> deleteKthElementInLinkedList = new DeleteKthElementInLinkedList<>();
    deleteKthElementInLinkedList.add(1);
    deleteKthElementInLinkedList.add(2);
    deleteKthElementInLinkedList.add(3);
    deleteKthElementInLinkedList.add(4);
    deleteKthElementInLinkedList.add(5);
    deleteKthElementInLinkedList.add(6);
    deleteKthElementInLinkedList.add(7);
    deleteKthElementInLinkedList.add(8);
    deleteKthElementInLinkedList.add(9);

    StringJoiner listBeforeDelete = new StringJoiner(" ");

    deleteKthElementInLinkedList.forEach(integer -> {
      System.out.println(integer);
      listBeforeDelete.add(String.valueOf(integer));
    });

    System.out.println(listBeforeDelete.toString());

    deleteKthElementInLinkedList.deleteLastNode();


    StringJoiner listAfterDelete = new StringJoiner(" ");

    for(Integer integer : deleteKthElementInLinkedList){
      System.out.println(integer);
      listAfterDelete.add(String.valueOf(integer));
    }

    System.out.println(listAfterDelete.toString());

    deleteKthElementInLinkedList.delete(5);

    StringJoiner listAfterDeletekth = new StringJoiner(" ");

    for(Integer integer : deleteKthElementInLinkedList){
      System.out.println(integer);
      listAfterDeletekth.add(String.valueOf(integer));
    }

    System.out.println(listAfterDeletekth.toString());




  }
}
