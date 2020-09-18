public class ThrowOnlyTwoEgg{
	public static void main(String[] args) {
		int[] array = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1};

		int[] array2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1};

		int[] array3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 1};

		ThrowOnlyTwoEgg exercise25_throwing2Eggs = new ThrowOnlyTwoEgg();

		//findFloorIn2SqrtN

		int floor = exercise25_throwing2Eggs.findFloorIn2SqrtN(array);
		System.out.println("Floor: " + floor + " Expected: 7");

		int floor2 = exercise25_throwing2Eggs.findFloorIn2SqrtN(array2);
		System.out.println("Floor: " + floor2 + " Expected: 0");

		int floor3 = exercise25_throwing2Eggs.findFloorIn2SqrtN(array3);
		System.out.println("Floor: " + floor3 + " Expected: 40");

		//findFloorInCSqrtF

		int floor4 = exercise25_throwing2Eggs.findFloorInCSqrtF(array);
		System.out.println("Floor: " + floor4 + " Expected: 7");

		int floor5 = exercise25_throwing2Eggs.findFloorInCSqrtF(array2);
		System.out.println("Floor: " + floor5 + " Expected: 0");

		int floor6 = exercise25_throwing2Eggs.findFloorInCSqrtF(array3);
		System.out.println("Floor: " + floor6 + " Expected: 40");
	}

	private static int findFloorIn2SqrtN(int[] array) {
		int low = 0;
		int high = array.length - 1;

		return findFloorIn2SqrtN(array, low, high, 0);
	}


	public static int findFloorIn2SqrtN(int[] array,int low,int high,int searchLevel){
		int key=1;
		if(low<=high){
			int seperator = searchLevel * (int)Math.sqrt(array.length-1);
			if(seperator>=array.length){
				seperator = array.length-1;
			}
			
			if(array[seperator] < key){
				return findFloorIn2SqrtN(array,seperator+1,high,++searchLevel);
			}else{
				if (searchLevel != 0) {
					searchLevel = searchLevel - 1;
				}
				int previousSeperator =  searchLevel * (int)Math.sqrt(array.length-1);
				for(int i=previousSeperator;i<=seperator;i++){
					if(array[i]==key){
						return i;
					}
				}
			}
		}
		
		return -1;
	}

	private int findFloorInCSqrtF(int[] array) {
		int low = 0;
		int high = array.length - 1;

		return findFloorInCSqrtF(array, low, high, 0, 0);
	}

	public int findFloorInCSqrtF(int[] array,int low,int high,int searchlevel,int increment){
		int key=1;
		
		if(low<=high){
			searchlevel = searchlevel + increment;
			if(searchlevel>=array.length){
				searchlevel = array.length-1;
			}
			
			if(array[searchlevel]<key){
				return findFloorInCSqrtF(array,searchlevel+1,high,searchlevel,++increment);
			}else{
				if(searchlevel!=0){
					searchlevel = searchlevel - increment;
				}
				
				for(int i= searchlevel;i<= searchlevel+increment;i++){
					if(array[i]==key){
						return i;
					}
				}
			}
		}
		

		return -1;
	}
	
}