package framework;

import java.util.HashSet;
import java.util.Set;

public class TestSetData {

	  // Set is a collection data type
	  // allows to store non-primitive data types
	  // ensures that data is unique, no duplicates allowed
	
		public static void main (String[] args) {
			Set<String> set1 = new HashSet<String>();
			set1.add("A");
			set1.add("B");
			set1.add("C");
			set1.add("D");
			System.out.println("Size of set : " + set1.size());
			set1.remove("B");
			
			
		}
	
	
	
}
