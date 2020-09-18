public class ThrowEggs{
  public static void main(String[] args) {
    int[] floors = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};

    ThrowEggs exercise24_throwingEggs = new ThrowEggs();

    int floor = exercise24_throwingEggs.findFloorInLgN(floors);
    System.out.println("Floor: "  + floor + " Expected: 6");

    int[] lotOfFloors = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
   // int floor2 = exercise24_throwingEggs.findFloorIn2LgF(lotOfFloors);
   // System.out.println("Floor: "  + floor2 + " Expected: 18");
  }

  private int findFloorInLgN(int[] floors) {
    int low = 0;
    int high = floors.length - 1;

    return findFloorInLgN(floors, low, high);
  }
	
	public static int findFloorInLgN(int[] stories,int low,int high){
		int key=1;
		while(low<=high){
			int middle = low + (high-low)/2;
			if(key>stories[middle]){
				return findFloorInLgN(stories,middle+1,high);
			}else{
				int lowestfloor = findFloorInLgN(stories,low,middle-1);
				if(lowestfloor==-1){
					return middle;
				}else{
					return lowestfloor;
				}
			}
		}

		return -1;

	}
	

}