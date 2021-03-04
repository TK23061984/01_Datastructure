package algorithms.string;

import java.util.Stack;

/******
 * 
 * 
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * Note that after backspacing an empty text, the text will continue empty.
 * 
 * Example 1:
 * 
 * Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T become
 * "ac". Example 2:
 * 
 * Input: S = "ab##", T = "c#d#" Output: true Explanation: Both S and T become
 * "". Example 3:
 * 
 * Input: S = "a##c", T = "#a#c" Output: true Explanation: Both S and T become
 * "c". Example 4:
 * 
 * Input: S = "a#c", T = "b" Output: false Explanation: S becomes "c" while T
 * becomes "b". Note:
 * 
 * 1 <= S.length <= 200 1 <= T.length <= 200 S and T only contain lowercase
 * letters and '#' characters. Follow up:
 * 
 * Can you solve it in O(N) time and O(1) space?
 *
 */

public class String33_BackspaceCompare {

	class Solution {
		public boolean backspaceCompare(String S, String T) {
			Stack<Character> sStack = new Stack<Character>();

			for (char c : S.toCharArray()) {
				if (c != '#') {
					sStack.push(c);
				} else {
					if (!sStack.isEmpty()) {
						sStack.pop();
					}
				}
			}

			Stack<Character> tStack = new Stack<Character>();
			for (char c : T.toCharArray()) {
				if (c != '#') {
					tStack.push(c);
				} else {
					if (!tStack.isEmpty()) {
						tStack.pop();
					}
				}
			}

			while (!sStack.isEmpty() && !tStack.isEmpty()) {
				if (sStack.pop() != tStack.pop()) {
					return false;
				}
			}

			return sStack.isEmpty() && tStack.isEmpty();
		}
	}
}
