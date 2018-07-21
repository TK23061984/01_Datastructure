package algorithm.string;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

/********
 * https://leetcode.com/problems/palindromic-substrings/description/
 * Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

	Example 1:
	Input: "abc"
	Output: 3
	Explanation: Three palindromic strings: "a", "b", "c".
	Example 2:
	Input: "aaa"
	Output: 6
	Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
	 *
 */
public class PalindromicSubstring {

	List<String> palindrome = new ArrayList<String>();
	int Counter = 0;
	@Test
	public void printPalindromicSubstring(){
		
		String input = "aaa";
		char[] charInput = input.toCharArray();
		for(int i=0; i< input.length(); i++){
			helper(charInput , i, i);
			helper(charInput, i, i+1);
		}	
		
		for(String palind : palindrome){
			System.out.println(palind);
		}
		
		System.out.println("Number of Palindrmic Substring :" + Counter);
	}
	
	private void helper(char[] input, int start, int end){
		int length = input.length;
		while(start >=0 && end < length && input[start] == input[end]){
			start--;
			end++;
			palindrome.add(new String(input).substring(start+1, end));
			Counter++;
		}
	}
}