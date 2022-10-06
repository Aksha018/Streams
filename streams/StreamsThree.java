package com.chainsys.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*filter()method
 * reduce()method in streams
 */
public class StreamsThree {

	public static void main(String[] args) {
		
		List<Integer> values = Arrays.asList(11,20,35,42,50,67,75);
/*External itration */
		
		int result = 0;
		for(int i : values) {
			if(i%5==0) {
				result +=i;
			}
		}
       System.out.println(result);
		
/*Internal Itration*/
	/*Method 1*/	
		
    System.out.println(values.stream().filter(i -> i%5==0).reduce(0,(c,e) -> c+e));
    
    
/*Method 2:
     * 	Predicate is a functional interface which has only one method called test and has only one parameter which turns into boolean
     */
    
    Predicate<Integer> p = new Predicate<Integer>() {
    	 public boolean test(Integer i) {
    		 return i%5==0;
    	 }
	};
	System.out.println(values.stream().filter(p).reduce(0,(c,e) -> c+e));
	
	/*Method 3*/
	
	System.out.println(values.stream().filter(new Predicate<Integer>() {
   	 public boolean test(Integer i) {
		 return i%5==0;
	 }
   }).reduce(0,(c,e) -> c+e));

	/*Method 4:
	 * using filter(),map(),reduce()
	 */
		System.out.println(values.stream().filter(i -> i%5==0).map(i ->i*2).reduce(0,(c,e) -> c+e));

		
	}
	

}
