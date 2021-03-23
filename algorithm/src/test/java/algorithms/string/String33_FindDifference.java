package algorithms.string;

/***
 * https://leetcode.com/problems/find-the-difference/
 * You are given two strings s and t.
 * 
 * String t is generated by random shuffling string s and then add one more
 * letter at a random position.
 * 
 * Return the letter that was added to t.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcd", t = "abcde" Output: "e" Explanation: 'e' is the letter
 * that was added. Example 2:
 * 
 * Input: s = "", t = "y" Output: "y" Example 3:
 * 
 * Input: s = "a", t = "aa" Output: "a" Example 4:
 * 
 * Input: s = "ae", t = "aea" Output: "a"
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 1000 t.length == s.length + 1 s and t consist of lower-case
 * English letters.
 *
 */

public class String33_FindDifference {

	public char findTheDifference(String s, String t) {
		int[] input = new int[26];
		for (char c : s.toCharArray()) {
			input[c - 'a'] += 1;
		}
		for (char c : t.toCharArray()) {
			if (input[c - 'a'] == 0) {
				return c;
			} else {
				input[c - 'a'] -= 1;
			}
		}
		return Character.MIN_VALUE;
	}
}
