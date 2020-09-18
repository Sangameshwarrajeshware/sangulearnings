public class BinarySearchFibonacci{
	public static void main(String... args) {
		int[] array = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7};

		BinarySearchFibonacci exercise22_binarySearchAddSub = new BinarySearchFibonacci();
		int index1 = exercise22_binarySearchAddSub.search(array, 2);
		int index2 = exercise22_binarySearchAddSub.search(array, 9);
		int index3 = exercise22_binarySearchAddSub.search(array, -3);
		int index4 = exercise22_binarySearchAddSub.search(array, 7);
		int index5 = exercise22_binarySearchAddSub.search(array, -2);

		System.out.println("Is element in the array: " + (index1 != -1) + " Expected: true");
		System.out.println("Is element in the array: " + (index2 != -1) + " Expected: false");
		System.out.println("Is element in the array: " + (index3 != -1) + " Expected: false");
		System.out.println("Is element in the array: " + (index4 != -1) + " Expected: true");
		System.out.println("Is element in the array: " + (index5 != -1) + " Expected: true");
	}
	
	public int search(int[] array,int key){
		if(array.length ==0){
			return -1;
		}
		
		int fibonacciN =1;
		int fibonacciBeforeN =0;
		int temp;
		
		while(fibonacciN<array.length){
			temp = fibonacciN;
			fibonacciN = fibonacciN + fibonacciBeforeN;
			fibonacciBeforeN = temp;
		}
		int low =0;
		int high = array.length-1;
		
		while(low<=high){
			
			while(fibonacciBeforeN > 0 &&fibonacciN>= high-low){
				temp = fibonacciBeforeN;
				fibonacciBeforeN = fibonacciN - fibonacciBeforeN;
				fibonacciN = temp;
			}
			
			int elementSearchIndex = low + fibonacciBeforeN;
			if(key<array[elementSearchIndex]){
				high = elementSearchIndex -1;
			}else if(key> array[elementSearchIndex]){
				low = elementSearchIndex +1;
			}else{
				return elementSearchIndex;
			}
		}
		return -1;
	}
}