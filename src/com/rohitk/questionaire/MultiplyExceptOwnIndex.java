package com.rohitk.questionaire;

public class MultiplyExceptOwnIndex {

	private static int[] multiplyArray(int [] arr, int n) {
		int [] result = new int[n];
		int product = 1;
		for (int i=0; i<n ; i++) 
			product = arr[i]  * product;
		for (int i=0; i<n; i++)
			result[i] = product / arr[i];
		return result;
	}
	
	public static void main(String[] args) {
		int [] arr = new int[] {1,2,3};
		int size = arr.length;
		int [] result = multiplyArray(arr, size);
		for (int i=0; i<size; i++) 
			System.out.print(result[i] + " ");
	}
}
