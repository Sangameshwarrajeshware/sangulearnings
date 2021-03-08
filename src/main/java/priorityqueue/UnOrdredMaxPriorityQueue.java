public class UnOrderedMaxPriorityQueue<Key extends Comparable<Key>>{
	
	private Key[] priorityQueue;
	private int N;
	
	public UnOrderedMaxPriorityQueue(int capacity){
		priorityQueue = (Key[])new Comparable[capacity];
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public void insert(Key key){
		priorityQueue[N++] = key;
	}
	
	public Key deleteMax(){
		int max =0;
		
		for(int i=0;i<N;i++){
			if(isLess(max,i)){
				max=i;
			}
		}
		
		exchange(max,N-1);
		return priorityQueue[--N];
	}
	
	private boolean isLess(int i,int j){
		return priorityQueue[i].compareTo(priorityQueue[j]);
	}
	
	private void exchange(int i,int j){
		Comparable temp = priorityQueue[i];
		priorityQueue[i] = priorityQueue[j];
		priorityQueue[j] = temp;
	}
}