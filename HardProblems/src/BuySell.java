
public class BuySell {

	public static void main(String[] args) {
		/*
		 * A[i] depicts the share's value on day i.
		 * we have a share that changes value each day.
		 * with the power of hindsight, what's the most amount
		 * of money we could've made?
		 */
	
		int[] shares = {2,6,8,7,8,7,9,4,1,2,4,5,8,9};
		int result = oneTransaction_OnePass(shares);
		System.out.println(result);
	}
	
	public static int oneTransaction_BF(int[] A) {
		/*
		 * Start Easy; One Transaction only, Brute Force
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
				max = Math.max(max, A[j] - A[i]);
			}
		}
		
		return max;
	}
	public static int oneTransaction_OnePassArray(int[] A) {
		/*
		 * draw the change of the stock as a graph
		 * realize that if we know the lowestThusFar, then
		 * the CONSEQUENT highest point, we get a 
		 * possible highest value candidate. make an Array from right
		 * where A[i] is highest possible sell-value at that day;
		 */
		int n = A.length;
		int[] helperArray = new int[n];
		
		helperArray[n-1] = A[n-1];
		
		for(int i = n-2; i > 0; i--) {
			helperArray[i] = Math.max(A[i], helperArray[i+1]);
		}
		
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			max = Math.max(helperArray[i] - A[i], max);
		}
		
		return max;
	}
	public static int oneTransaction_OnePass(int[] A) {
		/*
		 * like upper solution but instead of array we can
		 * think with 2 pointers
		 */
		
		int n = A.length;
		int bestValueThusFar = 0;
		int lowestThusFar = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			if(A[i] < lowestThusFar) {
				lowestThusFar = A[i];
			}
			
			if(A[i] - lowestThusFar > bestValueThusFar) {
				bestValueThusFar = A[i] - lowestThusFar;
			}
		}
		
		return bestValueThusFar;
	}
	
	
}
