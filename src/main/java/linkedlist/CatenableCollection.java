package linkedlist;

import queue.Queue;
import stack.Stack;

import java.util.StringJoiner;

public class CatenableCollection<Item> {

  public LinkedListCircular<Item> cancatQueues(Queue<Item> queue1, Queue<Item> queue2) {
    if (queue1 == null || queue2 == null) {
      return null;
    }

    LinkedListCircular<Item> linkedList = new LinkedListCircular<>();

    while (!queue1.isEmpty()) {
      Item item = queue1.dequeue();
      linkedList.insert(item);
    }

    while (!queue2.isEmpty()) {
      Item item = queue2.dequeue();
      linkedList.insert(item);
    }

    return linkedList;
  }

  public LinkedListCircular<Item> cancatStack(Stack<Item> stack1, Stack<Item> stack2) {
    if (stack1 == null || stack2 == null) {
      return null;
    }

    LinkedListCircular<Item> linkedList = new LinkedListCircular<>();

    while (!stack1.isEmpty()) {
      Item item = stack1.pop();
      linkedList.insert(item);
    }

    while (!stack2.isEmpty()) {
      Item item = stack2.pop();
      linkedList.insert(item);
    }

    return linkedList;
  }

  public LinkedListCircular<Item> cancatSteque(Steque<Item> steque1, Steque<Item> steque2) {
    if (steque1 == null || steque2 == null) {
      return null;
    }

    LinkedListCircular<Item> linkedList = new LinkedListCircular<>();
    while (!steque1.isEmpty()) {
      Item item = steque1.pop();
      linkedList.insert(item);
    }

    while (!steque2.isEmpty()) {
      Item item = steque2.pop();
      linkedList.insert(item);
    }

    return linkedList;
  }

  public static void main(String[] args) {
    CatenableCollection<Integer> catenableCollections = new CatenableCollection<>();

    System.out.println("Catenation of queues");
    testQueueCatenation(catenableCollections);

    System.out.println("Catenation of stacks");
    testStackCatenation(catenableCollections);

    System.out.println("Catenation of steques");
    testStequeCatenation(catenableCollections);
  }

  private static void testQueueCatenation(CatenableCollection<Integer> catenableCollections) {
    Queue<Integer> queue1 = new Queue<>();
    queue1.enqueue(0);
    queue1.enqueue(1);
    queue1.enqueue(2);
    queue1.enqueue(3);

    Queue<Integer> queue2 = new Queue<>();
    queue2.enqueue(7);
    queue2.enqueue(8);
    queue2.enqueue(9);

    LinkedListCircular<Integer> linkedListCircular = catenableCollections.cancatQueues(queue1, queue2);

    StringJoiner linkedListItems = new StringJoiner(" ");
    for (int item : linkedListCircular) {
      linkedListItems.add(String.valueOf(item));
    }
    System.out.println("Result after catenation: " + linkedListItems.toString());
    System.out.println("Expected: 0 1 2 3 7 8 9");

    System.out.println();

    StringJoiner queue1Items = new StringJoiner(" ");
    for (int item : queue1) {
      queue1Items.add(String.valueOf(item));
    }
    System.out.println("Queue 1 after catenation: " + queue1Items.toString());
    System.out.println("Expected: ");

    System.out.println();

    StringJoiner queue2Items = new StringJoiner(" ");
    for (int item : queue2) {
      queue1Items.add(String.valueOf(item));
    }
    System.out.println("Queue 2 after catenation: " + queue2Items.toString());
    System.out.println("Expected: ");
    System.out.println();
  }

  private static void testStackCatenation(CatenableCollection<Integer> catenableCollections) {
    Stack<Integer> stack1 = new Stack<>();
    stack1.push(0);
    stack1.push(1);
    stack1.push(2);
    stack1.push(3);

    Stack<Integer> stack2 = new Stack<>();
    stack2.push(7);
    stack2.push(8);
    stack2.push(9);

    LinkedListCircular<Integer> linkedListCircular = catenableCollections.cancatStack(stack1, stack2);

    StringJoiner linkedListItems = new StringJoiner(" ");
    for (int item : linkedListCircular) {
      linkedListItems.add(String.valueOf(item));
    }
    System.out.println("Result after catenation: " + linkedListItems.toString());
    System.out.println("Expected: 3 2 1 0 9 8 7");

    System.out.println();

    StringJoiner stack1Items = new StringJoiner(" ");
    for (int item : stack1) {
      stack1Items.add(String.valueOf(item));
    }
    System.out.println("Stack 1 after catenation: " + stack1.toString());
    System.out.println("Expected: ");

    System.out.println();

    StringJoiner stack2Items = new StringJoiner(" ");
    for (int item : stack2) {
      stack2Items.add(String.valueOf(item));
    }
    System.out.println("Stack 2 after catenation: " + stack2Items.toString());
    System.out.println("Expected: ");
    System.out.println();
  }

  private static void testStequeCatenation(CatenableCollection<Integer> catenableCollections) {
    Steque<Integer> steque1 = new Steque<>();
    steque1.enqueue(0);
    steque1.enqueue(1);
    steque1.enqueue(2);
    steque1.enqueue(3);

    Steque<Integer> steque2 = new Steque<>();
    steque2.push(7);
    steque2.push(8);
    steque2.push(9);

    LinkedListCircular<Integer> linkedListCircular = catenableCollections.cancatSteque(steque1, steque2);

    StringJoiner linkedListItems = new StringJoiner(" ");
    for (int item : linkedListCircular) {
      linkedListItems.add(String.valueOf(item));
    }
    System.out.println("Result after catenation: " + linkedListItems.toString());
    System.out.println("Expected: 0 1 2 3 9 8 7");

    System.out.println();

    StringJoiner steque1Items = new StringJoiner(" ");
    for (int item : steque1) {
      steque1Items.add(String.valueOf(item));
    }
    System.out.println("Steque 1 after catenation: " + steque1Items.toString());
    System.out.println("Expected: ");

    System.out.println();

    StringJoiner steque2Items = new StringJoiner(" ");
    for (int item : steque2) {
      steque2Items.add(String.valueOf(item));
    }
    System.out.println("Steque 2 after catenation: " + steque2Items.toString());
    System.out.println("Expected: ");
  }

}

