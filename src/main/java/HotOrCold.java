public class HotOrCold {

  public int hotOrCold(int number, int target) {
    int firstGuessIndex = number / 2;
    if (firstGuessIndex == target) {
      return firstGuessIndex;
    }

    int secondGuessIndex = firstGuessIndex + 1;
    if (secondGuessIndex == target) {
      return secondGuessIndex;
    } else {
      boolean isItHotter = isItHotter(firstGuessIndex, secondGuessIndex, target);
      if (isItHotter) {
        return binarySearch(target, secondGuessIndex, secondGuessIndex + 1, number);
      } else {
        return binarySearch(target, secondGuessIndex, 1, firstGuessIndex - 1);
      }
    }
  }

  private int binarySearch(int target, int lastGuess, int low, int high) {
    if (low == high) {
      if (low == target) {
        return low;
      } else {
        return -1;
      }
    }

    if (low > high) {
      return -1;
    }

    int middle = low + (high - low) / 2;

    boolean isItHotterFirstHalf = isItHotter(lastGuess, middle, target);

    if (isItHotterFirstHalf && target == middle) {
      return middle;
    }

    boolean isItHotterSecondHalf = isItHotter(middle, middle + 1, target);

    if (target == middle + 1) {
      return middle + 1;
    } else if (isItHotterSecondHalf) {
      return binarySearch(target, middle + 1, middle + 2, high);
    } else {
      return binarySearch(target, middle + 1, low, middle - 1);
    }

  }

  private boolean isItHotter(int previousGuess, int currentGuess, int target) {
    if (currentGuess == target) {
      return true;
    }

    return Math.abs(target - currentGuess) < Math.abs(target - previousGuess);
  }


  public static void main(String[] args) {
    HotOrCold hotOrCold = new HotOrCold();
    System.out.println("Hot or Cold: " + hotOrCold.hotOrCold(10, 3) + " Expected: 3");
    System.out.println("Hot or Cold: " + hotOrCold.hotOrCold(20, 12) + " Expected: 12");
    System.out.println("Hot or Cold: " + hotOrCold.hotOrCold(10, 11) + " Expected: -1");
  }
}