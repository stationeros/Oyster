package com.rohitk.questionaire;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> stack = new Stack<>();

	public void enqueue(int element) {
		stack.add(element);
	}

	public void dequeue() throws Exception {
		if (stack.size() < 1) 
				throw new Exception("Cannot dequeue from empty queue");
		if (stack.size() == 1) {
			System.out.println(stack.pop());
			return;
		}
		//Use a second recursive stack to push the data to maintain FIFO order.
		int element = stack.pop();
		dequeue();
		stack.push(element);
	}
	
	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();
		//Enqueue 1,2,3
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		try {
			queue.dequeue();
			queue.dequeue();
			queue.dequeue();
			// Will throw an exception.
			queue.dequeue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}