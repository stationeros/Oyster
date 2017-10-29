package com.rohitk.questionaire;

public class HeapSort {

	private static int getLeft(int i) {
		return 2 * i + 1;
	}

	private static int getRight(int i) {
		return 2 * i + 2;
	}

	private static void heapSort(int[] arr) {
		int size = arr.length;
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(arr, i, size);
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			// Swap the last element with root.
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			// Removing the element from further heapify process.
			size = size - 1;
			// Start heapifying the root again.
			heapify(arr, 0, size);
		}
		
		// Printing the final sorted array.
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	private static void heapify(int [] arr, int i, int size) {
		int largestElementIndex = i;
		int right = getRight(i);
		if (right < size && arr[right] > arr[largestElementIndex])
			largestElementIndex = right;
		int left = getLeft(i);
		if (left < size && arr[left] > arr[largestElementIndex])
			largestElementIndex = left;
		if (i != largestElementIndex) {
			int temp = arr[i];
			arr[i] = arr[largestElementIndex];
			arr[largestElementIndex] = temp;
			heapify(arr, largestElementIndex, size);
		}
	}
	
	public static void main(String[] args) {
		int [] arr = new int[] {8, 4, 3, 5, 1};
		heapSort(arr);
	}
}
