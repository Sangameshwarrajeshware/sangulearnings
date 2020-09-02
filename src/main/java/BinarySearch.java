public class BinarySearch{


  public static int binarySearch(int[] array,int low, int high,int search){
    if(low>high){
      return -1;
    }
    int middle = low + (high-low)/2;

    if(array[middle] < search){
      return binarySearch(array,middle+1,high,search);
    }else if(array[middle]>search){
      return binarySearch(array,low,middle-1,search);
    }else{
      int lowIndexSearch = binarySearch(array,low,middle-1,search);
      if(lowIndexSearch == -1){
        return middle;
      }else{
        return lowIndexSearch;
      }
    }

  }



    public static void main(String[] args) {
        int[] testArray1 = {3, 4, 4, 5, 6, 10, 15, 20, 20, 20, 20, 21};
        int elementToSearch1 = 4;
        int elementToSearch2 = 20;
        int elementToSearch3 = -5;

        System.out.println("Binary search: " + binarySearch(testArray1 , 0, testArray1.length,elementToSearch1) +
                " Expected: 1");
      System.out.println("Binary search: " + binarySearch(testArray1, 0, testArray1.length,elementToSearch2) +
                " Expected: 7");
      System.out.println("Binary search: " + binarySearch(testArray1, 0, testArray1.length,elementToSearch3) +
                " Expected: -1");

        int[] testArray2 = {4, 4, 4, 4, 4, 4, 15, 20, 20, 20, 20, 21};
        int elementToSearch4 = 4;

      System.out.println("Binary search: " + binarySearch(testArray2, 0, testArray2.length,elementToSearch4) +
                " Expected: 0");
    }

}
