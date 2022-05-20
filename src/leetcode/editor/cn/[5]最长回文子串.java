package leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 5213 👎 0

class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //回文串的的长度可能是奇数也可能是偶数，解决该问题的核心是从中心向两端扩散的双指针技巧
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //以s[i]为中心的最长回文子串
            String s1 = palindrome(s,i,i);
            //以s[i]和s[i + 1] 为中心的回文子串
            String s2 = palindrome(s,i,i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    //如果回文串的长度为奇数，则它有一个中心字符；如果回文串的长度为偶数，则可以认为它有两个中心字符。
    // 所以我们可以先实现这样一个函数
    //在s中寻找已s[l]和s[r]为中心的最长回文串
    String palindrome(String s,int l,int r){
        //防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            //双指针，向两边展开
            l--; r++;
        }
        //返回以s[l]和s[r] 为中心的最长回文串
        return s.substring(l + 1,r);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}