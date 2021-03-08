public class FixedCapacityStackOfString{
	private String[] items;
	private int N=0;
	
	public FixedCapacityStackOfString(int capacity){
		items = new String[capacity];
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public void push(String item){
		items[N++]=item;
	}
	
	public String pop(){
		return items[--N];
	}
}