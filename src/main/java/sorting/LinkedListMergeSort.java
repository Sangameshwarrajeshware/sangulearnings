package sorting;

import linkedlist.LinkedList;
import linkedlist.Node;

public class LinkedListMergeSort{

	public static Node sort(Node head){
		
		if(head == null || head.next == null){
			return head;
		}

		Node middle = getMiddleNode(head);
		Node middleNext = middle.next;
		middle.next = null;
		return merge(sort(head),sort(middleNext));
	}
	
	private static Node merge(Node a,Node b){
		Node dummyHead = new Node();
		for(Node current = dummyHead; a!=null && b!=null ;current = current.next){
			if((int)a.item <=(int)b.item){
				current.next =a;
				a = a.next;
			}else{
				current.next =b;
				b= b.next;
			}
		}
		dummyHead.next = (a==null) ? b:a;
		return dummyHead.next;
	}
	
	private static Node getMiddleNode(Node head){
		Node slow= head;
		Node fast = head;
		
		if(head == null){
			return head;
		}
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

public static void main(String[] args){
	LinkedList<Integer> list = new LinkedList<>();
	list.add(34);
	list.add(20);
	list.add(10);
	list.add(54);

	System.out.println(sort(list.getFirst()));
}

}