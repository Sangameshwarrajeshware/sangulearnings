import queue.Queue;



public class StackWithQueue<Item>{
	
	private Queue<Item> queue;
	
	public StackWithQueue(){
		queue = new Queue<>();
	}
	

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
	
	public void push(Item item){
		queue.enqueue(item);
	}
	
	public Item pop(){
		if(queue.isEmpty()){
			throw new RuntimeException("stack underflow");
		}
		
		int currentsize = size();
		
		for(int i=0;i<currentsize-1;i++){
			queue.enqueue(queue.dequeue());
		}
		return queue.dequeue();
	}

	public static void main(String[] args) {
		StackWithQueue<Integer> exercise28_stackWithAQueue = new StackWithQueue<>();

		System.out.println("IsEmpty: " + exercise28_stackWithAQueue.isEmpty() + " Expected: true");

		exercise28_stackWithAQueue.push(1);
		exercise28_stackWithAQueue.push(2);
		exercise28_stackWithAQueue.push(3);

		System.out.println(exercise28_stackWithAQueue.pop());
		System.out.println(exercise28_stackWithAQueue.pop());

		exercise28_stackWithAQueue.push(4);
		exercise28_stackWithAQueue.push(5);

		System.out.println("Size: " + exercise28_stackWithAQueue.size() + " Expected: 3");
		System.out.println("IsEmpty: " + exercise28_stackWithAQueue.isEmpty() + " Expected: false");

		System.out.println(exercise28_stackWithAQueue.pop());
		System.out.println(exercise28_stackWithAQueue.pop());

		System.out.println("Expected output from pop(): 3 2 5 4");
	}
}