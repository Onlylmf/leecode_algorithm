package leetcode.editor.cn;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1878 👎 0

import java.util.HashMap;

class MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        solution.minWindow("abcdefghif","efg");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 滑动窗口算法思路:
    //      1.在字符串中使用双指针中的左右指针技巧， 初始化left=right=0，把索引 左闭右开 区间[left,right)称一个窗口
    //      2.先不断的增加right指针扩大窗口[left,right)，直到窗口的字符串符合要求 （包含了所需要的所有字符）
    //      3.停止增加right 转而不断增加left 指针缩小窗口[left,right),直到窗口中的字符串不再符合要求（不包含所需要的所有字符了）。
    //        每增加left都要更新一轮结果
    //      4.重复第2和第3步，直到right到达字符串的尽头
    public String minWindow(String s, String t) {
        //初始化
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        //将需要的字符记录在need哈希表中
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need.put(ch,need.getOrDefault(ch,0)+1); //当ch已经存在的时候 返回默认值0 随后+1记录存在个数
        }
        //初始化左右指针，valid表示窗口中所满足need条件的字符个数  如果need和valid大小相同则说明满足条件
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        //右指针没有走完就继续循环
        while (right < s.length()){
            char ch = s.charAt(right);
            right++;//扩大

            //从第一位开始判断need中是否存在 有的话加入window窗口 （窗口内数据的更新）
            if (need.containsKey(ch)){
                window.put(ch,window.getOrDefault(ch,0) + 1);
                //如果window中已经包含了该字符 则+1
                if (window.get(ch).equals(need.get(ch))){
                    valid++;
                }
            }

            //左侧是否要收缩
            while (valid == need.size()){
                if (right - left < len){
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++; //缩小
                //窗口内数据的更新
                if (need.containsKey(d)){ //一次判断 缩小的那个字符属不属于need
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put( d, window.get( d ) - 1 );
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring( start, start+len );
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

