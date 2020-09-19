import java.util.Stack;

public class DequeWithThreeStack<Item>{
	
	private Stack<Item> headStack;
	private Stack<Item> tailStack;
	private Stack<Item> middleStack;
	
	public DequeWithThreeStack(){
		headStack = new Stack<Item>();
		tailStack = new Stack<Item>();
		middleStack = new Stack<Item>();
	}
	
	public boolean isEmpty(){
		return headStack.isEmpty() &&
			tailStack.isEmpty() && 
				middleStack.isEmpty();
	}
	
	public int size(){
		return headStack.size()+ tailStack.size()+middleStack.size();
	}
	
	public void pushRight(Item item){
		tailStack.push(item);
	}
	
	public Item popRight(){
		if(isEmpty()){
			throw new RuntimeException("stack underflow");
		}
		
		if(tailStack.isEmpty()){
			moveHalfItems(headStack,tailStack);
		}
		return tailStack.pop();
	}
	
	public void pushLeft(Item item){
		headStack.push(item);
	}
	
	public Item popLeft(){
		if(isEmpty()){
			throw new RuntimeException("stack underflow");
		}
		
		if(headStack.isEmpty()){
			moveHalfItems(tailStack,headStack);
		}
		return headStack.pop();
	}
	
	private void moveHalfItems(Stack<Item> fullStack,Stack<Item> emptyStack){
		int halfSize = size()/2;
		int remainingSize = size() - halfSize;
		
		for(int i=0;i<halfSize;i++){
			middleStack.push(fullStack.pop());
		}
		
		for(int i=0;i<remainingSize;i++){
			emptyStack.push(fullStack.pop());
		}
		
		while(!middleStack.isEmpty()){
			fullStack.push(middleStack.pop());
		}
		
	}



	public static void main(String[] args) {
		DequeWithThreeStack<Integer> exercise31_dequeWith3Stacks = new DequeWithThreeStack<>();
		System.out.println("IsEmpty: " + exercise31_dequeWith3Stacks.isEmpty() + " Expected: true");

		exercise31_dequeWith3Stacks.pushLeft(1);
		exercise31_dequeWith3Stacks.pushLeft(2);
		exercise31_dequeWith3Stacks.pushLeft(3);
		exercise31_dequeWith3Stacks.pushLeft(4);

		System.out.println(exercise31_dequeWith3Stacks.popRight());
		System.out.println(exercise31_dequeWith3Stacks.popLeft());
		System.out.println(exercise31_dequeWith3Stacks.popLeft());

		System.out.println("Expected output from pop(): 1 4 3");

		exercise31_dequeWith3Stacks.pushRight(7);
		exercise31_dequeWith3Stacks.pushRight(8);

		System.out.println("Size: " + exercise31_dequeWith3Stacks.size() + " Expected: 3");
		System.out.println("IsEmpty: " + exercise31_dequeWith3Stacks.isEmpty() + " Expected: false");

		System.out.println(exercise31_dequeWith3Stacks.popLeft());
		System.out.println(exercise31_dequeWith3Stacks.popLeft());
		System.out.println(exercise31_dequeWith3Stacks.popRight());

		System.out.println("Expected output from pop(): 2 7 8");
	}
}