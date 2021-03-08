package sorting;


public class SelectionSort {

  public static void sort(Comparable[] items) {
		for(int i=0;i< items.length;i++){
			int min =i;
			for(int j=i+1;j< items.length;j++){
				if(isLess(items[j], items[min])){
					min = j;
				}
			}
			exchange(items,i,min);
		}
  }

  private static boolean isLess(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exchange(Comparable[] items, int i, int j) {
    Comparable temp = items[i];
    items[i] = items[j];
    items[j] = temp;
  }

  private static void show(Comparable[] items) {
    for (int i = 0; i < items.length; i++) {
      System.out.println(items[i] + " ");
    }
    System.out.println();
  }

  public static boolean isSorted(Comparable[] items) {
    for (int i = 1; i < items.length; i++) {
      if (isLess(items[i], items[i - 1])) return false;
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