public class ElementSameInBothArray{

  public static void main(String[] args) {
      int[] array1 = { 0, 1, 2, 2, 5, 6, 6, 8, 25, 25 };
      int[] array2 = { -2, 0, 1, 2, 2, 2, 3, 4, 5, 10, 20, 25, 25 };

      System.out.print("Elements: ");
      printElementsSameInBothArray(array1, array2);
      System.out.println("\nExpected: 0 1 2 5 25");
  }

  public static void printElementsSameInBothArray(int[] a1,int[] a2){
    int a1Index =0;
    int a2Index=0;
    Integer recentValue = null;

    while(a1Index<a1.length && a2Index < a2.length){
      if(a1[a1Index] > a2[a2Index]){
        a2Index++;
      }else if(a1[a1Index] < a2[a2Index]){
        a1Index++;
      }else{
        if(recentValue == null || recentValue != a1[a1Index]){
          System.out.println(a1[a1Index]+" ");
          recentValue = a1[a1Index];
        }
        a1Index++;
        a2Index++;
      }
    }
  }
}
