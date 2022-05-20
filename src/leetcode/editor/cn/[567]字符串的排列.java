package leetcode.editor.cn;

//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 676 👎 0

import java.util.HashMap;

class PermutationInString{
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        solution.checkInclusion("ab","eidbaoo");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[128];
        //count for specific position
        int left = 0, right = 0;
        int count = 0;
        int n = s2.length();
        int len = s1.length();

        //将需要的字符根据ASCII 在对应数组中的位置++
        for (char ch : s1.toCharArray())
            map[ch]++;

        while (right < n) {
            char cRight = s2.charAt(right);
            right++;
            if (map[cRight] > 0)
                count++;

            map[cRight]--;
            //
            if (right - left >= len) {
                if (count == len)
                    return true;

                char cLeft = s2.charAt(left);
                map[cLeft]++;
                left++;
                if (map[cLeft] > 0)
                    count--;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}