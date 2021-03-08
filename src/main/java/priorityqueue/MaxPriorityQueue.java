package priorityqueue;

public class MaxPriorityQueue<Key extends Comparable<Key>>{
	
	private Key[] pq;
	private int N;
	
	public MaxPriorityQueue(int capacity){
		pq = (Key[])new Comparable[capacity+1];
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public void insert(Key key){
		pq[++N]=key;
		swim(N);
	}
	
	private void swim(int k){
		while(k>1 && isLess(k/2,k)){
			exchange(k,k/2);
			k=k/2;
		}
	}
	
	private boolean isLess(int i,int j){
		return pq[i].compareTo(pq[j])<0;
	}
	
	private void exchange(int i,int j){
		Comparable temp = pq[i];
		pq[i] = pq[j];
		pq[j]= (Key)temp;
	}
	
	
	public Key deleteMax(){
		Key max = pq[1];
		exchange(1,N--);
		sink(1);
		return max;
	}
	
	private void sink( int k){
		while(2*k<=N){
			int j=2*k;
			if(j<N && isLess(j,j+1)) j++;
			if(!isLess(k,j)){
				break;
			}
			exchange(k,j);
			k=j;
		}
	}
}