package com.rohitk.questionaire;

import java.util.PriorityQueue;

// Class to get kth element in unsorted array using heap in O(nlogk).
// The same logic would 
public class KthLargestElementInStream {

	private static int kthLargestElementInStream(int[] stream, int k) {

		// Heap abstracted out as a priority queue.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int size = stream.length;
		// Offer first k elements to the heap.
		for (int i = 0; i<k; i++)
			pq.offer(stream[i]);
		for (int i=k; i < size; i++) {
			if (stream[i] > pq.peek()) {
				pq.poll();
				pq.offer(stream[i]);
			}
		}
		return pq.poll();
	}

	public static void main(String[] args) {
		int[] stream = new int[] { 7, 10, 4, 3, 20, 15 };
		int k = 2;
		System.out.println(kthLargestElementInStream(stream, k));
	}
}
