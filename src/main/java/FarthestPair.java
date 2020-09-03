
import java.util.Arrays;

public class FarthestPair{

  public static void main(String[] args) {
    double[] array1 = {-5.2, 9.4, 20, -10, 21.1, 40, 50, -20};
    double[] array2 = {-4, -3, 0, 10, 20};
    double[] array3 = {-10, -3, 0, 2, 4, 20};

    double[] farthestPair1 = farthestPair(array1);
    double[] farthestPair2 = farthestPair(array2);
    double[] farthestPair3 = farthestPair(array3);

    System.out.println("Farthest pair: " + farthestPair1[0] + " " + farthestPair1[1] + " Expected: -20.0 50.0");
    System.out.println("Farthest pair: " + farthestPair2[0] + " " + farthestPair2[1] + " Expected: -4.0 20.0");
    System.out.println("Farthest pair: " + farthestPair3[0] + " " + farthestPair3[1] + " Expected: -10.0 20.0");


    double[] farthestPair4 = farthestPairNew(array1);
    double[] farthestPair5 = farthestPairNew(array2);
    double[] farthestPair6 = farthestPairNew(array3);
    System.out.println("Farthest pair: " + farthestPair4[0] + " " + farthestPair4[1] + " Expected: -20.0 50.0");
    System.out.println("Farthest pair: " + farthestPair5[0] + " " + farthestPair5[1] + " Expected: -4.0 20.0");
    System.out.println("Farthest pair: " + farthestPair6[0] + " " + farthestPair6[1] + " Expected: -10.0 20.0");

  }

  public static double[] farthestPair(double[] array){

    double[] farthestPair = new double[2];

    double currentMin = Double.MIN_VALUE;

    Arrays.sort(array);

    farthestPair[0] = array[0];
    farthestPair[1] = array[array.length-1];
    return farthestPair;
  }

  public static double[] farthestPairNew(double[] array){
    double[] farthestPair = new double[2];

    double min = array[0];
    double max = array[0];

    farthestPair[0] = array[0];
    farthestPair[1] = array[1];

    for(int i=0 ; i< array.length; i++){
      if(array[i] < min){
        min = array[i];
        farthestPair[0] = min;
      }
      if(array[i] > max){
        max = array[i];
        farthestPair[1] = max;
      }

    }
    return farthestPair;
  }
}
