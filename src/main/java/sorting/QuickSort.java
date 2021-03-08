package sorting;

public class QuickSort{
	
	public static void sort(Comparable[] items){
		//shuffle the array
		sort(items,0,items.length-1);
	}
	
	private static void sort(Comparable[] items,int low,int high){
		if(low>high) return;
		
		int j = partition(items, low, high);
		sort(items,low,j-1);
		sort(items,j+1,high);
	}
	
	private static int partition(Comparable[] items,int low,int high){
		int i= low;
			int j=high;
		
		while(true){
			while(isLess(items[++i],items[low]))
				if(i==high) break;
			while(isLess(items[low],items[--j]))
				if(j==low) break;
			
			if(i>=j) break;
			
			exchange(items,i,j);
		}
		exchange(items,low,j);
		return j;
	}
	
	
	private static void exchange(Comparable[] items,int i,int j){
		Comparable temp = items[i];
		items[i] = items[j];
		items[j] =temp;
	}
	
	private static boolean isLess(Comparable v,Comparable w){
		return v.compareTo(w) <0;
	}
}