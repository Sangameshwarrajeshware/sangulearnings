import java.util.Arrays;
public class StaticToInts
{
  private int[] a;
  public StaticToInts(int[] keys)
  {
    a = new int[keys.length];
    for (int i = 0; i < keys.length; i++)
      a[i] = keys[i]; // defensive copy
    Arrays.sort(a);
  }
  public int howMany(int key){
    int indexFromRank = rank(key);
    if(indexFromRank == -1){
      return 0;
    }
    int previousIndex = indexFromRank;
    int currentPreviousIndex = previousIndex;
    int nextIndex = indexFromRank;
    int currentNextIndex = nextIndex;

    while(currentPreviousIndex!=-1){
      currentPreviousIndex = binarySearch(0,currentPreviousIndex-1,key);
      if(currentPreviousIndex!=-1){
        previousIndex = currentPreviousIndex;
      }
    }

    while(currentNextIndex !=-1){
      currentNextIndex = binarySearch(currentNextIndex+1,a.length-1,key);
      if(currentNextIndex != -1){
        nextIndex = currentNextIndex;
      }
    }
    return nextIndex - previousIndex +1;

  }

  private int binarySearch(int low,int high,int search){
    if(low>high){
      return -1;
    }

    int middle = low + (high-low)/2;

    if(a[middle] > search){
      return binarySearch(low,middle-1,search);
    }else if(a[middle] < search){
      return binarySearch(middle+1, high, search);
    }else{
      return middle;
    }
  }

  public boolean contains(int key)
  { return rank(key) != -1; }
  private int rank(int key)
  { // Binary search.
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi)
    { // Key is in a[lo..hi] or not present.
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] array = {2, 4, 8, 16, 16, 16, 32, 64, 128, 128};
    StaticToInts exercise11 = new StaticToInts(array);

    System.out.println("How many 2: "  + exercise11.howMany(2) + " Expected: 1");
    System.out.println("How many 16: "  + exercise11.howMany(16) + " Expected: 3");
    System.out.println("How many 128: "  + exercise11.howMany(128) + " Expected: 2");
    System.out.println("How many -99: "  + exercise11.howMany(-99) + " Expected: 0");
  }
}
