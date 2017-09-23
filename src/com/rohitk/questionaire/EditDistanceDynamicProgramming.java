package com.rohitk.questionaire;

/*
 * Dynamic Programming solution to the edit distance problem.
 * https://leetcode.com/problems/edit-distance/description/ 
 */

public class EditDistanceDynamicProgramming {

	private static int editDistance(String str1, String str2) {
		int str1Length = str1.length();
		int str2Length = str2.length();
		Integer [][] dp = new Integer[str1Length + 1][str2Length + 1];
		for(int i=0; i<dp.length; i++) {
			dp[i][0] = i;
		}
		for(int i=0; i<dp[0].length; i++) {
			dp[0][i] = i;
		}
		for (int i=1; i<=str1Length; i++) {
			for (int j=1; j<=str2Length; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) 
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = 1 + min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]);
			}
		}
		return dp[str1Length][str2Length];
	}
	
	private static int min(int n1, int n2, int n3) {
		return Math.min(Math.min(n1, n2), n3);
	}
	
	public static void main(String[] args) {
		String str1 = "azced";
		String str2 = "abcdef";
		System.out.println(editDistance(str1, str2));
	}
	
}
