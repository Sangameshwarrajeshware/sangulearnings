public class BitonicSearch{
	
	public static void main(String[] args){
		int[] array7 = {23,45,67,78,79,-10,-20,-40,-60};
		int[] array1 = {1, 2, 3, 4, -1, -2, -3};
		int[] array2 = {1, 5, 4, 3, 2, 0};
		int[] array3 = {2, 4, 8, 16, 32, 1};
		int[] array4 = {2, 4, 8, 16, 32};
		int[] array5 = {2, 1};
		int[] array6 = {9};
		
		int indexOfElement1 = bitonicSearch(array1, -1);
		int indexOfElement2 = bitonicSearch(array2, 5);
		int indexOfElement3 = bitonicSearch(array3, 2);
		int indexOfElement4 = bitonicSearch(array3, 99);
		int indexOfElement5 = bitonicSearch(array4, 32);
		int indexOfElement6 = bitonicSearch(array5, 1);
		int indexOfElement7 = bitonicSearch(array6, 9);
		
        System.out.println("Index of element: " + indexOfElement1 + " Expected: 4");
        System.out.println("Index of element: " + indexOfElement2 + " Expected: 1");
        System.out.println("Index of element: " + indexOfElement3 + " Expected: 0");
        System.out.println("Index of element: " + indexOfElement4 + " Expected: -1");
        System.out.println("Index of element: " + indexOfElement5 + " Expected: 4");
        System.out.println("Index of element: " + indexOfElement6 + " Expected: 1");
        System.out.println("Index of element: " + indexOfElement7 + " Expected: 0");
	}
	
	
	public static int bitonicSearch(int[] array,int value){
		if(array == null || array.length ==0){
			return -1;
		}
		
		int tippingPoint = findTipping(array,0,array.length-1);
		int low =0;
		int high = tippingPoint;
		
		int increasingSequenceSearchIndex = ascendingBinarySearch(array,value,low,high);
		
		if(increasingSequenceSearchIndex != -1){
			return increasingSequenceSearchIndex;
		}
		
		low = tippingPoint+1;
		high = array.length-1;
		
		
		int decreasingSequenceSearchIndex = decreasingBinarySearch(array,value,low,high);
		return decreasingSequenceSearchIndex;
	}
	
	private static int decreasingBinarySearch(int[] array,int value,int low,int high){
		while(low<=high){
			int middle = low + (high-low)/2;
			if(array[middle] > value){
				return decreasingBinarySearch(array,value,middle+1,high);
			}else if(array[middle] < value){
				return decreasingBinarySearch(array,value,low,middle-1);
			}else{
				return middle;
			}
		}
		return -1;
	}
	
	private static int ascendingBinarySearch(int[] array,int value,int low,int high){
		
		while(low<= high){
			int middle = low + (high-low)/2;
		
			if(array[middle] > value ){
				return ascendingBinarySearch(array,value,low,middle-1);
			}else if(array[middle] < value){
				return ascendingBinarySearch(array,value,middle+1,high);
			}else{
				return middle;
			}
		}
		return -1;
	}
	
	private static int findTipping(int[] array,int low,int high){
		if(low > high){
			return array.length-1;
		}
        if (high == low) {
             return high;
         }
		int middle = low + (high-low)/2;
		
		if(middle == 0){
			if(array[middle] < array[middle+1]){
				return findTipping(array,middle+1,high);
			}else{
				return 0;
			}
		}
		
		if(middle == array.length-1){
			return array.length-1;
		}
		
		if(array[middle] > array[middle-1] && array [middle] < array[middle+1]){
			return findTipping(array,middle+1,high);
		}else if(array[middle] < array[middle-1] && array[middle] > array[middle+1]){
			return findTipping(array,low,middle-1);
		}
		else{
			return middle;
		}
	}
}