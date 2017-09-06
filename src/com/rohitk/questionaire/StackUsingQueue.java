package com.rohitk.questionaire;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> queue = new LinkedList<>();

	public void push(int element) {
		queue.add(element);
		int size = queue.size();
		while (size > 1) {
			// Reverse push elements to simulate LIFO.
			queue.add(queue.remove());
			size--;
		}
	}

	/* Emulates the pop() behavior of stack. */
	public int pop() throws Exception {
		if (queue.isEmpty()) {
			throw new Exception("Cannot pop from an empty stack.");
		} else {
			return queue.poll();
		}

	}

	public static void main(String[] args) {
		StackUsingQueue stackUsingQueue = new StackUsingQueue();
		// push 1,2,3
		stackUsingQueue.push(1);
		stackUsingQueue.push(2);
		stackUsingQueue.push(3);
		// pop from stack
		try {
			System.out.println(stackUsingQueue.pop());
			System.out.println(stackUsingQueue.pop());
			System.out.println(stackUsingQueue.pop());
			// Following call should throw an exception.
			System.out.println(stackUsingQueue.pop());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
