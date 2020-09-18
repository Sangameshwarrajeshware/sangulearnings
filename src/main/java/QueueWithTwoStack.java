import java.util.Stack;

public class QueueWithTwoStack<Item>{
	
	private Stack<Item> headStack;
	private Stack<Item> tailStack;
	
	public QueueWithTwoStack(){
		headStack = new Stack();
		tailStack = new Stack();
	}
	
	public boolean isEmpty(){
		return headStack.isEmpty() && tailStack.isEmpty();
	}
	
	public int size(){
		return headStack.size() + tailStack.size();
	}
	
	public void enqueue(Item item){
		tailStack.push(item);
	}
	
	public Item dequeue(){
		if(headStack.isEmpty()){
			moveAllToHeadStack();
		}
		return headStack.pop();
	}
	
	private void moveAllToHeadStack(){
		headStack.push(tailStack.pop());
	}

	public static void main(String[] args) {

		QueueWithTwoStack<String> exercise27_queueWith2Stacks = new QueueWithTwoStack<>();

		System.out.println("IsEmpty: " + exercise27_queueWith2Stacks.isEmpty() + " Expected: true");
		System.out.println("Size: " + exercise27_queueWith2Stacks.size() + " Expected: 0");

		exercise27_queueWith2Stacks.enqueue("A");
		exercise27_queueWith2Stacks.enqueue("B");
		System.out.println(exercise27_queueWith2Stacks.dequeue());
		System.out.println(exercise27_queueWith2Stacks.dequeue());

		exercise27_queueWith2Stacks.enqueue("C");
		exercise27_queueWith2Stacks.enqueue("D");
		exercise27_queueWith2Stacks.enqueue("E");
		exercise27_queueWith2Stacks.enqueue("F");

		System.out.println("Size: " + exercise27_queueWith2Stacks.size() + " Expected: 4");

		System.out.println(exercise27_queueWith2Stacks.dequeue());
		System.out.println(exercise27_queueWith2Stacks.dequeue());

		System.out.println("Expected output from dequeue(): A B C D");

		System.out.println("IsEmpty: " + exercise27_queueWith2Stacks.isEmpty() + " Expected: false");
		System.out.println("Size: " + exercise27_queueWith2Stacks.size() + " Expected: 2");
	}
	
}