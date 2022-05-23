package leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 7610 👎 0

import java.util.HashMap;

class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //依然使用滑动窗口算法 只是更为简单
        //记录窗口数据
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0,right = 0;
        int res = 0; //记录结果
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            //进行窗口内数据的更新
            window.put(c,window.getOrDefault(c,0)+1);
            //判断左侧窗口是否要收缩
            while (window.get(c) > 1){ //如果大于1 则证明有重复字符 （所以不符合条件了 需要进行缩小窗口了）
                char d = s.charAt(left);
                left++;
                //进行窗口内数据的一系列更新
                window.put(d,window.getOrDefault(d,0)-1);
            }
            //更新答案
            res = res > right-left ? res : right-left;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}