package com.chainsys.streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class StreamOne {
	public static void main(String args[]) {
		
		List<Integer> values = Arrays.asList(1,2,3,4);
		
	/* Normal way to print output */	
		
	for(int i=0;i<4;i++)
	{
		System.out.println(values.get(i));
	}
		
	/* Using itration to print output */
		
		Iterator<Integer> i = values.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
   /* External Iteration */

		for(int i: values) {
        	System.out.println(i);
        }
	
	/* lambda method */
		
	values.forEach(i ->System.out.println(i));
		
		
	/* Functional Interface */
		
  values.forEach(new Consumer<Integer>()   {
	  public void accept(Integer i)
	  {
		  System.out.println(i);
	  }
		  });
	

		/*ForEach method reference */
		
	
	values.forEach(i -> doubleit(i));
	
	values.forEach(StreamOne::doubleit);
	
}

	public static void doubleit(int i) {
		System.out.println(i*2); 
	}
	

	}
