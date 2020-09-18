public class BitonicSearch2LogN{
	public static void main(String[] args) {
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
	private static int bitonicSearch(int[] array, int value) {
		if (array == null || array.length == 0) {
			return -1;
		}

		return bitonicSearch(array, value, 0, array.length - 1);
	}
	
	public static int bitonicSearch(int[] array,int value,int low,int high){
		
		
		int middle = low + (high-low)/2;
		
		if(array[middle] == value){
			return middle;
		}else if(array[middle] < value && array[middle+1] > array[middle]){
			return bitonicSearch(array,value,middle+1,high);
		}else if(array[middle] < value && array[middle-1] > array[middle]){
			return bitonicSearch(array,value,low,middle-1);
		}else{
			int leftHalfSearch = ascendingBinarySearch(array,value,low,middle-1);
			if(leftHalfSearch!=-1){
				return leftHalfSearch;
			}
			
			int rightHalfSearch = descendingBinarySearch(array,value,middle+1,high);
			return rightHalfSearch;
		}
	}
	
	private static int ascendingBinarySearch(int[] array,int value,int low, int high){
		while(low < high){
			int middle = low + (high-low)/2;
			if(array[middle] > value){
				return ascendingBinarySearch(array,value,low,middle-1);
			}else if(array[middle] < value){
				return ascendingBinarySearch(array,value,middle+1,high);
			}else{
				return middle;
			}
		}
		return -1;
	}
	
	private static int descendingBinarySearch(int[] array,int value,int low,int high){
		while(low< high){
			int middle = low + (high-low)/2;
			if(array[middle] > value){
				return descendingBinarySearch(array,value,middle+1,high);
			}else if (array[middle] < value){
				return descendingBinarySearch(array,value,low,middle-1);
			}else{
				return middle;
			}
		}
		return -1;
	}
}