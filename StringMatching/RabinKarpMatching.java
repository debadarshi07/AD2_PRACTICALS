package StringMatching;

public class RabinKarpMatching {
	public final static int d = 256;

	static void matching(String pattern, String text, int q) {

		int m = pattern.length(),n = text.length(),i,j,p=0,t=0,h=1;

		for (i = 0; i < m - 1; i++)
			h = (h * d) % q;
		
		for (i = 0; i < m; i++) {
			p = (d * p + pattern.charAt(i)) % q;
			t = (d * t + text.charAt(i)) % q;
		}

		for (i = 0; i <= n - m; i++) {
			if (p == t) {
				for (j = 0; j < m; j++) {
					if (text.charAt(i + j) != pattern.charAt(j)) break;
				}
				if (j == m)
					System.out.println("Pattern found at index " + i);
			}
			if (i < n - m) {
				t = (d * (t - text.charAt(i) * h)+ text.charAt(i + m))% q;
				if (t < 0)
					t += q;
			}
		}
	}

	public static void main(String[] args) {

		String text = "GEEKS FOR GEEKS";
		String pattern = "GEEK";

		int q = 101;

		matching(pattern, text, q);
	}
}