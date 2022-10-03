import java.util.Arrays;

public class BuySell {

	public static void main(String[] args) {
		/*
		 * A[i] depicts the share's value on day i.
		 * we have a share that changes value each day.
		 * with the power of hindsight, when was best day to buy/sell?
		 */
	
		int[] shares = {7,5,8,4,2,1,7};
		int result = oneTransaction_BF(shares);
		System.out.println(result);
	}
	
	public static int oneTransaction_BF(int[] A) {
		/*
		 * brute force; just try all combinations, take max of them'
		 * -> Math.max(∀(i,j)), for which: i ≤ j ≤ n
		 * explain how this can be optimized to ~(n*n)/2 - n
		 * explain what n^2 means for calculation time by drawing graph
		 * and saying worst case that n^2 will always be out-competed by n
		 */
		
		int n = A.length;
		int max = 0;
		
		for(int i = 0; i < (n-1); i++) {
			for(int j = (i+1); j < n; j++) {
				int temp = A[j] - A[i];
				if(temp > max) {
					max = temp;
				}
			}
		}
		
		return max;
	}

}
