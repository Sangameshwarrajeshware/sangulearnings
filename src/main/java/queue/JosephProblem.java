package queue;

public class JosephProblem {

  public static void josephSeats(int personOrder, int numberOfPeople) {
    Queue<Integer> queue = new Queue<>();
    for (int i = 0; i < numberOfPeople; i++) {
      queue.enqueue(i);
    }

    while (numberOfPeople > 0) {
      for (int i = 1; i < personOrder; i++) {
        queue.enqueue(queue.dequeue());
      }
      System.out.print(queue.dequeue() + ",");
      numberOfPeople--;
    }
  }

  public static void main(String[] args) {
    int personOrder = 2;
    int numberOfPeople = 7;

    System.out.println("Order in which people are eliminated:");
    josephSeats(personOrder, numberOfPeople);
  }
}
