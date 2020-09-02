import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


public class FourSum{


  public static void main(String[] args) {

    // Method 1
    System.out.println("Method 1");
    int[] array1 = {5, 2, -2, -5, -2};
    System.out.println("4 sum: " + fourSum(array1));
    System.out.println("Expected: 2");

    int[] array2 = {1, 2, 3, 4, -4, -5, -6, 2, 4, -1};
    System.out.println("4 sum: " + fourSum(array2));
    System.out.println("Expected: 13");

    // Method 2
    System.out.println("\nMethod 2");
    System.out.println("4 sum: " + fourSum1(array1));
    System.out.println("Expected: 2");

    System.out.println("4 sum: " + fourSum1(array2));
    System.out.println("Expected: 13");
  }
  public static int fourSum1(int[] a){
    int N = a.length;
    int count =0;
      for(int i=0;i<N;i++){
        for(int j=i+1;j<N;j++){
          for(int k=j+1;k<N;k++){
            for(int l=k+1;l<N;l++){
              if(a[i]+a[j]+a[k]+a[l]==0){
                System.out.println(a[i]+" "+a[j]+" "+ a[k]+" "+a[l]);
                count++;
              }
            }
          }
        }
      }
      return count;
  }


  static class Pair{
    int index1;
    int index2;

    Pair(int index1,int index2){
      this.index1 = index1;
      this.index2 = index2;
    }
  }

  public  static int fourSum(int[] array){
    Map<Integer,List<Pair>> sumMap = new HashMap<>();

    for(int i=0;i<array.length;i++){
      for(int j=i+1;j<array.length;j++){
        int sum = array[i] + array[j];
        if(!sumMap.containsKey(sum)){
          sumMap.put(sum,new ArrayList<>());
        }
        sumMap.get(sum).add(new Pair(i,j));
      }
    }

    int count=0 ;

    for(int key : sumMap.keySet()){
      if(sumMap.containsKey(-key)){
        List<Pair> pairs = sumMap.get(key);
        List<Pair> complementPairs = sumMap.get(-key);

        for(Pair pair : pairs){
          for(Pair complementPair : complementPairs){
            if(pair.index2 < complementPair.index1){
              count++;
            }
          }
        }
      }
    }

    return count;
  }

public static int twoSumFaster(int[] array){
  int count =0;

  int start = 0;
  int end = array.length-1;

  count = countZeroMatches(array);

  while(start < end){
    if(array[start] + array[end] > 0){
      end--;
    }else if(array[start] + array[end] <0){
      start++;
    }else {

      if (array[start] == 0 && array[end] == 0) {
        start++;
        end--;
        continue;
      }

      int startElement = array[start];
      int equalsToStartElement = 1;

      while (start + 1 < end && array[start + 1] == startElement) {
        equalsToStartElement++;
        start++;
      }

      int endElement = array[end];
      int equalsToEndElement = 1;

      while (end - 1 > start && array[end - 1] == endElement) {
        equalsToEndElement++;
        end--;
      }

      count += equalsToEndElement * equalsToStartElement;
      start++;
      end--;

    }

  }
  return count;
}

private static int countZeroMatches(int[] array){
  int count =0;

  for(int a : array){
    if(a==0){
      count++;
    }
  }
  return handleZeroEdgecases(count);
}

private static int handleZeroEdgecases(int count){
  return ((count-2)*(count-1)*count)/6;
}

}
