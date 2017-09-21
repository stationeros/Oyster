package com.rohitk.questionaire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Data to hold the index of which row and which col we added to the heap.
class Data  {
	int data;
	int rowIndex;
	int colIndex;

	public Data(int data, int rowIndex, int colIndex) {
		this.data = data;
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}
}

//Data comparator for the heap.
class DataComparator implements Comparator<Data> {

	@Override
	public int compare(Data o1, Data o2) {
		return o1.data - o2.data;
	}
}

public class MergeKSortedArraysFromDisk {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		List<Integer> result = sortKArrays(arr);
		int size = result.size();
		for (int i=0; i< size; i++)
			System.out.print(result.get(i) + " ");
	}

	private static List<Integer> sortKArrays(int[][] arr) {
		List<Integer> list = new ArrayList<>();
		PriorityQueue<Data> pq = new PriorityQueue<>(new DataComparator());
		int rows = arr.length;
		int cols = arr[0].length;
		//Initially add first elements of all rows to the heap.
		for (int i = 0; i < rows; i++) {
			pq.offer(new Data(arr[i][0], i, 0));
		}
		//Till the heap is not empty poll and add the data to the heap from the
		//last index we go that out.
		while (!pq.isEmpty()) {
			Data data = pq.poll();
			list.add(data.data);
			int rowIndex = data.rowIndex;
			int colIndex = data.colIndex;
			if (rowIndex < rows && colIndex+1 < cols) 
				pq.offer(new Data(arr[rowIndex][colIndex+1], rowIndex, colIndex+1));
		}
		return list;
	}
}
