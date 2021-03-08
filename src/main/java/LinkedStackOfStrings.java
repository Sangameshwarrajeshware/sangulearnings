public class LinkedStackOfStrings{
	private Node first = null;
	private int N =0;
	
	private class Node{
		String item;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void push(String item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public String pop(){
		String item = first.item;
		first = first.next;
		N--;
		return item;
	}
}