import java.util.Stack;

public class StequeWithTwoStack<Item>{
	private Stack<Item> headStack;
	private Stack<Item> tailStack;
	
	public StequeWithTwoStack(){
		headStack = new Stack<Item>();
		tailStack = new Stack<Item>();
	}
	
	public boolean isEmpty(){
		return headStack.isEmpty() && tailStack.isEmpty();
	}
	
	public int size(){
		return headStack.size() + tailStack.size();
	}
	
	public void push(Item item){
		tailStack.push(item);
	}
	
	public Item pop(){
		if(isEmpty()){
			throw new RuntimeException("stack underflow");
		}
		
		if(tailStack.isEmpty()){
			moveAllItemsToTailStack();
		}
		
		return tailStack.pop();
	}
	
	private  void moveAllItemsToTailStack(){
		while(!headStack.isEmpty()){
			tailStack.push(headStack.pop());
		}
	}
	
	public void enqueue(Item item){
		headStack.push(item);
	}

	public static void main(String[] args) {
		StequeWithTwoStack<Integer> exercise29_stequeWith2Stacks = new StequeWithTwoStack<>();

		System.out.println("IsEmpty: " + exercise29_stequeWith2Stacks.isEmpty() + " Expected: true");

		exercise29_stequeWith2Stacks.push(1);
		exercise29_stequeWith2Stacks.push(2);
		exercise29_stequeWith2Stacks.push(3);

		System.out.println(exercise29_stequeWith2Stacks.pop());
		System.out.println(exercise29_stequeWith2Stacks.pop());

		exercise29_stequeWith2Stacks.enqueue(4);
		exercise29_stequeWith2Stacks.enqueue(5);

		System.out.println("Size: " + exercise29_stequeWith2Stacks.size() + " Expected: 3");
		System.out.println("IsEmpty: " + exercise29_stequeWith2Stacks.isEmpty() + " Expected: false");

		System.out.println(exercise29_stequeWith2Stacks.pop());
		System.out.println(exercise29_stequeWith2Stacks.pop());

		System.out.println("Expected output from pop(): 3 2 1 4");
	}
}