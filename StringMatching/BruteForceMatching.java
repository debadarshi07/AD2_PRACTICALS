package StringMatching;
import java.util.ArrayList;

public class BruteForceMatching {
	public static ArrayList<Integer> matching(String text, String pattern){
		
		int n = text.length(),m = pattern.length();
		
		char textArr[]= text.toCharArray(),patternArr[]=pattern.toCharArray();
		
		ArrayList<Integer> list = new ArrayList<>();
		int shift, j;
		
		for(shift=0; shift<=n-m; shift++) {
			for(j=0; j<m; j++) {
				if(patternArr[j]!=textArr[shift+j]) 
					break;
			}
				if(j==m)
					list.add(shift-1);
		}
		return list;
	}

	public static void main(String[] args) {
		
		String text = "abcaabcabccabbcaa";
		String pattern="cab";
		
		ArrayList<Integer> shiftList = matching(text, pattern);
		
		if(shiftList.isEmpty()) {
			System.out.println("Pattern not found!!!");
		}else {
			System.out.print("Pattern found at shifts: ");
			for(int i=0; i<shiftList.size(); i++) 
				System.out.print(shiftList.get(i)+" ");
		}
	}
}
