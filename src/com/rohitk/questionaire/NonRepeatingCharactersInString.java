package com.rohitk.questionaire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NonRepeatingCharactersInString {

	//This does not solve first non repeating character. It gives all the non-repeating charcaters.
	private static List<Character> nonRepeatingCharactersInStrng(String str) {
		int length = str.length();
		List<Character> result = new ArrayList<>();
		Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
		for (int i=0; i<length; i++) {
			char ch = str.charAt(i);
			if (frequencyMap.containsKey(ch)) 
				frequencyMap.put(ch, frequencyMap.get(ch) + 1);
			else
				frequencyMap.put(ch, 1);
		}
		for (Map.Entry<Character, Integer> entry: frequencyMap.entrySet()) {
			if (entry.getValue() == 1) {
				result.add(entry.getKey());
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String str = "ESPNCRICINFO";
		List<Character> result = nonRepeatingCharactersInStrng(str);
		int size = result.size();
		for (int i=0; i < size; i++) {
			System.out.print(result.get(i) + " ");
		}
	}
}
