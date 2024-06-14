package DynamicProgramming;
import java.util.Arrays;

public class MatrixChainMultiplication {
	static int dp[][]=new int[100][100];
	static int matrixChainMemoised(int arr[],int i,int j) {
		if(i==j) return 0;
		if(dp[i][j] != -1) return dp[i][j];
		dp[i][j]=Integer.MAX_VALUE;
		for(int k=i;k<j;k++) 
			dp[i][j]=Math.min(dp[i][j], matrixChainMemoised(arr,k+1,j))+matrixChainMemoised(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
		return dp[i][j];
	}
	
	static int matrixChainOrder(int arr[]) {
		int i=1,j=arr.length-1;
		return matrixChainMemoised(arr,i,j);
	}
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		for(int row[]:dp) Arrays.fill(row, -1);
		
		System.out.println("Minimum no of multiplication is: "+matrixChainOrder(arr));
	}
}
