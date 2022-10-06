package com.chainsys.streams;

import java.util.Arrays;
import java.util.List;

public class StreamsFour {
	public static void main(String[] args) {
		
	List<Integer> values = Arrays.asList(11,20,35,42,55,67,75,88);
	
 /*Normal method*/
	
	int result = 0;
	for(int i : values) {
		if(i%5==0) {
			result = i*2;
			break;
		}
	}
   System.out.println(result);

	/*Method 1
	 * using filter(),map() :these are known as lazy methods or lazy functions
	 * findFirst() :used to find /evaluate 1st element
	 * orElse(): it is  optional
	 * */
	
 System.out.println(values.stream().filter(i -> i%5==0).map(i -> i*2).findFirst().orElse(0));
	
	/*Method 2*/
	
	System.out.println(values.stream()
			.filter(StreamsFour::isDivisible)
			.map(StreamsFour::mapDouble)
			.findFirst()
			.orElse(0));
}
	
	public static boolean isDivisible(int i) {
		System.out.println("in isDivs" +i);
		return i%5==0;
	}
	public static int mapDouble(int i) {
		System.out.println("in mapDouble" +i);
		return i*2;
	}
	
	
}