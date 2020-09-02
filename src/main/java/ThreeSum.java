public class ThreeSum{


  public static void main(String[] args) {
    int[] array = {-10, -10, -5, 0, 5, 10, 10, 15, 20};
    int[] arrayTest1 = {-3, -2, 2, 3, 5, 99};
    int[] arrayTest2 = {-10, -10, -10, 10};
    int[] arrayTest3 = {0, 0, 0, 0, 0, 0, 0};
    int[] arrayTest4 = {-2, -1, 0, 0, 0, 0, 0, 0, 3};

    System.out.println("Method 1");
    System.out.println("ThreeSumFaster: " + threeSumFaster(array) + " Expected: 8");
    System.out.println("ThreeSumFaster: " + threeSumFaster(arrayTest1) + " Expected: 1");
    System.out.println("ThreeSumFaster: " + threeSumFaster(arrayTest2) + " Expected: 0");
    System.out.println("ThreeSumFaster: " + threeSumFaster(arrayTest3) + " Expected: 35");
    System.out.println("ThreeSumFaster: " + threeSumFaster(arrayTest4) + " Expected: 21");

  }

  public static int threeSumFaster(int[] array){
    int count =0;

    int start =0;
    int end = array.length-1;

    if((array[start] >0 && array[end] >0) || array[start] < 0 && array[end] <0 ){
      return 0;
    }

    count = countZeroMatches(array);

    for(int i=0; i< array.length;i++){
      start = i+1;
      end = array.length-1;

      while(start< end){
        if(array[i] + array[start]+ array[end] >0){
          end--;
        }else if(array[i] + array[start] + array[end] <0){
          start++;
        }else{

          if(array[start] ==0 && array[end] ==0){
            start++;
            end--;
            continue;
          }

          int startElement = array[start];
          int countEqualsToStartElement =1;
          while(start+1 < end && array[start+1]== startElement){
            countEqualsToStartElement++;
            start++;
          }

          int endElement = array[end];
          int countEqualsToEndElement = 1;

          while(end-1 > start &&  array[end-1] == endElement){
            countEqualsToEndElement++;
            end--;
          }

          count += countEqualsToEndElement * countEqualsToStartElement;
          start++;
          end--;
        }
      }
    }

    return count;
  }

  private static int countZeroMatches(int[] array){
    int count =0;

    for(int value : array){
      if(value== 0){
        count++;
      }
    }
    return handleZeroEdgecases(count);
  }

  private static int handleZeroEdgecases(int count){
    return ((count-2) * (count -1) * count)/6;
  }
}
