package sorting;

public class ShellSort{
	
	
	public static void sort(Comparable[] items){
		int h=1;
		int N= items.length;
		
		while(h<N/3){
			h = 3*h +1;
		}
		
		while(h>=1){
			for(int i=h;i<N;i++){
				for( int j=i;j>=h && isLess(items[j],items[j-h]);j-=h){
					exchange(items,j,j-h);
				}
			}
			h=h/3;
		}
	}
	
	private static void exchange(Comparable[] items,int i,int j){
		Comparable temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}
	
	private static boolean isLess(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	
	private static void show(Comparable[] items){
		for(int i=0;i<items.length;i++){
			System.out.print(items[i]+" ");
		}
		System.out.println(" ");
	}
	
	private static boolean isSorted(Comparable[] items){
		for(int i=1;i<items.length;i++){
			if(isLess(items[i],items[i-1])) return false;
			
		}
		return true;
	}
}