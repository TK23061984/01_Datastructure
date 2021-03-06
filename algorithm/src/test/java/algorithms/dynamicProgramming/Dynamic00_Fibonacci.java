package algorithms.dynamicProgramming;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dynamic00_Fibonacci {

	
	/**https://leetcode.com/problems/fibonacci-number/
	 * 
	 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

	F(0) = 0, F(1) = 1
	F(n) = F(n - 1) + F(n - 2), for n > 1.
	Given n, calculate F(n).
	
	 
	
	Example 1:
	
	Input: n = 2
	Output: 1
	Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
	Example 2:
	
	Input: n = 3
	Output: 2
	Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
	Example 3:
	
	Input: n = 4
	Output: 3
	Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
	 
	
	Constraints:
	
	0 <= n <= 30
	 */
	@Test
	public void Test(){
		int result = fibDP(5);
		System.out.println(result);
		Assert.assertEquals(result, 5);
	}

	public int fibDP(int n) {
		 if(n < 2) return n;
	        int[] dp = new int[n+1];
	        dp[0] = 0;
	        dp[1] = 1;
	        
	        for(int i=2; i <= n; i++){
	            dp[i] = dp[i-1] + dp[i-2]; 
	        }
	        
	        /***
	         * 0	1	2	3	4	5	6	7	8	9
	         * 0	1	1	2	3	5	8	13	21	34
	         * 
	         */
	        return dp[n];
	}
}
