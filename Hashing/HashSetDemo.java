package Hashing;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
	public static void main(String[] args) {
		Set<Integer> set=new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(1);
		
		System.out.println(set);
		System.out.println("Size of set: "+set.size());
		
		if(set.contains(1)) System.out.println("Set contains 1.");
		if(!set.contains(5)) System.out.println("Set doesn't contain 5");
		
		set.remove(1);
		if(!set.contains(1)) System.out.println("Set doesn't contain 1");
		
		System.out.println(set);
		System.out.println("Size of set: "+set.size());
		
		Iterator<Integer> it=set.iterator();
		while(it.hasNext()) System.out.print(it.next()+" ");
	}
}
