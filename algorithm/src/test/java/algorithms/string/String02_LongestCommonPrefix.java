package algorithms.string;

import org.testng.Assert;
import org.testng.annotations.Test;

/*******
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.

	If there is no common prefix, return an empty string "".

	Example 1:
	
	Input: strs = ["flower","flow","flight"]
	Output: "fl"
	Example 2:
	
	Input: strs = ["dog","racecar","car"]
	Output: ""
	Explanation: There is no common prefix among the input strings.
	 
	
	Constraints:
	
	0 <= strs.length <= 200
	0 <= strs[i].length <= 200
	strs[i] consists of only lower-case English letters.
 *
 */

public class String02_LongestCommonPrefix {

	@Test
	public void getLongestPrefix(){
		String[] inputs = new String[4];
		inputs[0]= "leets";
		inputs[1] = "leetcode";
		inputs[2] = "leeds";
		inputs[3] = "leeed";
		
		Assert.assertEquals(longestPrefix(inputs), "lee");
	}

	
	/*
	 * Time complexity : O(S)O(S) , 
	 * where S is the sum of all characters in all strings.
	 * In the worst case all nn strings are the same. 
	 * The algorithm compares the string S1S1 with the other strings [S_2 \ldots S_n][S 
2
​	
 …S 
n
​	
 ] There are SS character comparisons, where SS is the sum of all characters in the input array.

Space complexity : O(1)O(1). We only used constant extra space.
	 */
	private String longestPrefix(String[] inputs){
		if(inputs == null || inputs.length == 0)
			return "";
		if(inputs.length == 1)
			return inputs[0];
		String prefix = inputs[0];
		
		for(int i=0; i< inputs.length; i++){
			while(inputs[i].indexOf(prefix) != 0){
				prefix = prefix.substring(0, prefix.length()-1);
				if(prefix.isEmpty())
					return "";
			}
		}		
		return prefix;
	}
}
