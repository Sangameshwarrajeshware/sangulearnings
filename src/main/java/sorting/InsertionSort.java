package sorting;

public class InsertionSort{
	
	public static void sort(Comparable[] items){
		for(int i=1;i<items.length;i++){
			for(int j=i;j>0 && isLess(items[j],items[j-1]);j--)
				exchange(items,j,j-1);
		}
	}
	
	public static boolean isLess(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	
	public static void exchange(Comparable[] items,int i,int j ){
		Comparable temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}
	
	
	public static void show(Comparable[] items){
		for(int i=0;i<items.length;i++){
			System.out.print(items[i]+ " ");
		}
		System.out.println();
	}
	
	public static boolean isSorted(Comparable[] items){
		for(int i=1;i<items.length;i++){
			if(isLess(items[i],items[i-1])) return false;
		}
		return true;
	}
	
    public static void main(String[] args) { // Read strings from standard input, sort them, and print.
      String[] a = new String[]{"z","c","y","i","b","p"};
      sort(a);
      assert isSorted(a);
      show(a);
    }
}