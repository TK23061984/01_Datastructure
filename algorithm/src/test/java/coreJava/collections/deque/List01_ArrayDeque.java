package coreJava.collections.deque;
import java.util.ArrayDeque;
import java.util.Deque;

import org.testng.annotations.Test;

import algorithms.singlyLinkedList.ListNode;

public class List01_ArrayDeque {

	
	@Test
	public void Queue_ArrayDeque(){		
		
		//With integer values
		Deque<Integer> intQue = new ArrayDeque<Integer>();
		intQue.offerLast(1);
		intQue.offerLast(2);
		intQue.offerLast(3);
		intQue.offerLast(4);
		
		while(!intQue.isEmpty()){
			System.out.println(intQue.pollFirst());
		}		
		
		//With Objects
		Deque<ListNode> nodeQue = new ArrayDeque<ListNode>();
		nodeQue.offerLast(new ListNode(10));
		nodeQue.offerLast(new ListNode(20));
		nodeQue.offerLast(new ListNode(30));
		//nodeQue.offerLast(null); // Will throw Null pointer exception.But linkedList will not throw exception for null values
		nodeQue.offerLast(new ListNode(40));
		
		while(!nodeQue.isEmpty()){
			if(nodeQue.peekFirst() != null){
				System.out.println(nodeQue.pollFirst().value);
			}
			else{
				nodeQue.pollFirst();
				System.out.println("null");
			}
		}
		
	}
}
