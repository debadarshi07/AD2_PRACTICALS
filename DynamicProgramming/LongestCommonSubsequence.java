package DynamicProgramming;
public class LongestCommonSubsequence {
	static double findSubsequence(String str1,String str2,int m,int n) {
		if(m==0 || n==0) return 0;
		if(str1.charAt(m-1) == str2.charAt(n-1)) return 1+findSubsequence(str1,str2,m-1,n-1);
		else return Math.max(findSubsequence(str1,str2,m,n-1),findSubsequence(str1,str2,m-1,n));
	}
	
	public static void main(String[] args) {
		String str1="ABC",str2="ACD";
		System.out.println((int)findSubsequence(str1,str2,str1.length(),str2.length()));
	}
}
