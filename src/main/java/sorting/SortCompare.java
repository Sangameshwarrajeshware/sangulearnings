package sorting;

import java.time.Duration;
import java.time.Instant;

public class SortCompare {

  public static final String SELECTION = "SELECTION";
  public static final String INSERTION = "INSERTION";
  public static final String SHELL = "SHELL";

  public static double time(String algorithm, Double[] array) {

    Instant start = Instant.now();
    if (algorithm.equals(INSERTION)) InsertionSort.sort(array);
    if (algorithm.equals(SELECTION)) SelectionSort.sort(array);
    		if (algorithm.equals(SHELL)) ShellSort.sort(array);
    //		if (alg.equals("Merge")) Merge.sort(a);
    //		if (alg.equals("Quick")) Quick.sort(a);
    //		if (alg.equals("Heap")) Heap.sort(a);
    Instant finish = Instant.now();
    return Duration.between(start, finish)
                   .toMillis();

  }

  public static double timeRandomInput(String algorithm, int N, int T) {
    double total = 0.0;
    Double[] array = new Double[N];
    for (int t = 0; t < T; t++) {
      for (int i = 0; i < N; i++) {
        array[i] = Math.random();
      }
      total += time(algorithm, array);
    }
    return total;
  }

  public static void main(String[] args) {
    String alg1 = INSERTION;
    String alg2 = SELECTION;
    int N = 1000;
    int T = 100;
    double t1 = timeRandomInput(alg1, N, T); // total for alg1
    double t2 = timeRandomInput(alg2, N, T); // total for alg2
    System.out.printf("For %d random Doubles\n %s is", N, alg1);
    System.out.printf(" %.1f times faster than %s\n", t2 / t1, alg2);

    String alg3 = SHELL;
    String alg4 = INSERTION;
    double t3 = timeRandomInput(alg3, N, T); // total for alg1
    double t4 = timeRandomInput(alg4, N, T); // total for alg2
    System.out.printf("For %d random Doubles\n %s is", N, alg3);
    System.out.printf(" %.1f times faster than %s\n", t4 / t3, alg4);


  }
}