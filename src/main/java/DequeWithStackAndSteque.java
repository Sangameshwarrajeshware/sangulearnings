import stack.Stack;

public class DequeWithStackAndSteque<Item>{
	
	private Stack<Item> stack;
	private Steque<Item> steque;
	
	public DequeWithStackAndSteque(){
		stack = new Stack<Item>();
		steque = new Steque<Item>();
	}
	
	public boolean isEmpty(){
		return stack.isEmpty() && steque.isEmpty();
	}
	
	public int size(){
		return stack.size() + steque.size();
	}
	
	public void pushRight(Item item){
		steque.push(item);
	}
	
	public Item popRight(){
		if(isEmpty()){
			throw new RuntimeException("stack underflow");
		}
		
		if(steque.isEmpty()){
			moveAllItemsToSteque();
		}
		
		return steque.pop();
	}
	
	private void moveAllItemsToSteque(){
		while(!stack.isEmpty()){
			steque.push(stack.pop());
		}
	}
	
	public void pushLeft(Item item){
		stack.push(item);
	}
	
	public Item popLeft(){
		if(isEmpty()){
			throw new RuntimeException("stack is underflow");
		}
		
		if(stack.isEmpty()){
			moveHalfItemsToStack();
		}
		return stack.pop();
	}
	
	private void moveHalfItemsToStack(){
		int halfsize = size()/2;
		int remainingSize = size() - halfsize;
		
		for(int i=0;i<halfsize;i++){
			steque.enqueue(steque.pop());
		}
		
		for(int i=0;i< remainingSize;i++){
			stack.push(steque.pop());
		}
	}


	public static void main(String[] args) {
		DequeWithStackAndSteque<Integer> exercise30_dequeWithStackAndSteque = new DequeWithStackAndSteque<>();
		System.out.println("IsEmpty: " + exercise30_dequeWithStackAndSteque.isEmpty() + " Expected: true");

		exercise30_dequeWithStackAndSteque.pushLeft(1);
		exercise30_dequeWithStackAndSteque.pushLeft(2);
		exercise30_dequeWithStackAndSteque.pushLeft(3);
		exercise30_dequeWithStackAndSteque.pushLeft(4);

		System.out.println(exercise30_dequeWithStackAndSteque.popRight());
		System.out.println(exercise30_dequeWithStackAndSteque.popLeft());
		System.out.println(exercise30_dequeWithStackAndSteque.popLeft());

		System.out.println("Expected output from pop(): 1 4 3");

		exercise30_dequeWithStackAndSteque.pushRight(7);
		exercise30_dequeWithStackAndSteque.pushRight(8);

		System.out.println("Size: " + exercise30_dequeWithStackAndSteque.size() + " Expected: 3");
		System.out.println("IsEmpty: " + exercise30_dequeWithStackAndSteque.isEmpty() + " Expected: false");

		System.out.println(exercise30_dequeWithStackAndSteque.popLeft());
		System.out.println(exercise30_dequeWithStackAndSteque.popLeft());
		System.out.println(exercise30_dequeWithStackAndSteque.popRight());

		System.out.println("Expected output from pop(): 2 7 8");
	}

}