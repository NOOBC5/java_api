package ExArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetDemo {
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(2);
		A.add(2);
		A.add(2);
		A.add(3);
		
		Iterator hi = (Iterator) A.iterator();
		while(hi.hasNext()) {
			System.out.println(hi.next()); // > 1 2 2 2 2 3
		}
		
//		HashSet<Integer> B = new HashSet<Integer>();
//		A.add(1);
//		A.add(2);
//		A.add(2);
//		A.add(2);
//		A.add(2);
//		A.add(3);
//		
//		Iterator hello = (Iterator) B.iterator();
//		while(hello.hasNext()) {
//			System.out.println(hello.next()); > 1 2 3
//		}
	}
}
