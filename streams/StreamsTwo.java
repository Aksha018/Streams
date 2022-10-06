package com.chainsys.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

/* map() method
 * reduce() method in streams
 */

public class StreamsTwo {
	public static void main(String args[]) {
	
	List<Integer> values = Arrays.asList(1,2,3,4,5,6);
	
/*Method 1*/
	
	/*Functional object Interface*/
	
	Function<Integer,Integer> f = new Function<Integer,Integer>(){
		public Integer apply(Integer i) {
			return i*2;
		}
	};
	
	/*Binary object interface*/
	
	BinaryOperator<Integer> b = new BinaryOperator<Integer>() {
		
		public Integer apply(Integer i,Integer j) {
			return i+j;
		}
		
	}; 

	Stream<Integer> s = values.stream();
	
	Stream<Integer> s1 = s.map(f);
	
	Integer result = s1.reduce(0,b);
	
	System.out.println(result);

/*Method 2*/
	
	Stream<Integer> s = values.stream();
	
	Stream<Integer> s1 = s.map(new Function<Integer,Integer>()
	{
		public Integer apply(Integer i) {
		return i*2;
  }
	});
	
	Integer result = (Integer)s1.reduce(0,new BinaryOperator<Integer>() 
			{
		
		public Integer apply(Integer i,Integer j) {
			return i+j;
		}
		
	});
           System.out.println(result);
		
/*Method 3*/
           
	System.out.println(values.stream().map(i -> i*2).reduce(0,(c,e) -> c+e));
	
/*Method 4*/
	System.out.println(values.stream().map(i -> i*2).reduce(0,Integer::sum));

}
	
	
}