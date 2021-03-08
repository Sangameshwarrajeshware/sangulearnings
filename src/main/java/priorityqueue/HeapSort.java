package priorityqueue;

public class HeapSort{
	
	public static void sort(Comparable[] pq){
		int N = pq.length;
		for(int k=N/2;k>=1;k--){
			sink(pq,k,N);
		}
		while(N>1){
			exchange(pq,1,N--);
			sink(pq,1,N);
		}
	}
	
	private void sink(Comparable[] pq,int k,int N){
		while(2*k<=N){
			j = 2*k;
			if(j<N && isLess(pq,j,j+1)) j++;
			if(!isLess(pq,k,j)) break;
			exchange(pq,k,j);
			k=j
		}
	}
	
	private void exchange(Comparable[] pq,int i , int j){
		Comparable temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
	
	private boolean isLess(Comparable[] pq, int i, int j){
		return pq[i].compareTo(pq[j]);
		}
}