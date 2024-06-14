package Hashing;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
public class HashMapDemo {
	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<>();
		map.put("India", 140);
		map.put("China", 139);
		map.put("Pakistan", 25);
		map.put("US", 35);
		map.put("Indonesia", 30);
		
		System.out.println(map);
		
		map.put("India", 150);
		System.out.println(map);
		System.out.println("Population of India: "+map.get("India"));
		System.out.println("Population of England: "+map.get("England"));
		
		for(Map.Entry<String,Integer> e: map.entrySet()) 
			System.out.println(e.getKey()+": "+e.getValue());
		
		Set<String> keys=map.keySet();
		for(String key:keys)
			System.out.println(key+": "+map.get(key));
		
		map.remove("China");
		System.out.println(map);
	}
}
