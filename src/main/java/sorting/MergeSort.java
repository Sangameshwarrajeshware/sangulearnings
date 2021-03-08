package sorting;
public class MergeSort{
	
	private static Comparable[] aux;
	
	public static void sort(Comparable[] items){
		
		aux = new Comparable[items.length];
		sort(items,0,items.length-1);
	}
	
	private static void sort(Comparable[] items,int low,int high){
		
		if(low>= high) return;
		int middle = low+ (high-low)/2;
		sort(items,0,middle);
		sort(items,middle+1,high);
		merge(items,low,middle,high);
	}
	
	private static void merge(Comparable[] items,int low,int middle,int high){
		
		int i=low,j = middle+1;
		
		for(int k=low;k<high;k++){
			aux[k]=items[k];
		}
		
		for(int k=0;k<high;k++){
			if(i>middle) items[k] = aux[j++];
			else if(j>high) items[k] =aux[i++];
			else if(isLess(aux[i],aux[j])) items[k]= aux[i++];
			else items[k] = aux[j++];
		}
	}
	
	private static boolean isLess(Comparable v,Comparable w){
		return v.compareTo(w) <0;
	}
}