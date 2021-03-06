package algorithms.string;

import org.testng.annotations.Test;

public class String04_LongestSubstringWithSameLettersReplacement {

	/*
	 * https://www.youtube.com/watch?v=00FmUN1pkGE
	 * https://leetcode.com/problems/longest-repeating-character-replacement/
	 * 
	 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.

	In one operation, you can choose any character of the string and change it to any other uppercase English character.
	
	Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
	
	Note:
	Both the string's length and k will not exceed 104.
	
	Example 1:
	
	Input:
	s = "ABAB", k = 2
	
	Output:
	4
	
	Explanation:
	Replace the two 'A's with two 'B's or vice versa.
	 
	
	Example 2:
	
	Input:
	s = "AABABBA", k = 1
	
	Output:
	4
	
	Explanation:
	Replace the one 'A' in the middle with 'B' and form "AABBBBA".
	The substring "BBBB" has the longest repeating letters, which is 4.

	 */
	 public int findLength(String str, int k) {
	    int N = str.length();
	    int[] char_input = new int[128];
	    int left = 0;
	    int max_length = 0;
	    int current_max = 0;

	    for(int right =0; right < str.length(); right++){
	      char_input[str.charAt(right) - 'a']++;
	      int char_count = char_input[str.charAt(right)-'a'];
	      current_max = Math.max(current_max, char_count);

	      while(right - left - current_max + 1 > k){
	        char_input[str.charAt(left)-'a']--;
	        left++;
	      }
	      max_length = Math.max(max_length, right-left + 1);
	    }

	    return max_length;
	  }

	  @Test
	  public  void test() {
	    System.out.println(this.findLength("aabccbb", 2)); //"bbbbb" (after replacing c with b)
	    System.out.println(this.findLength("abbcb", 1));
	    System.out.println(this.findLength("abccde", 1));
	  }
	
}
