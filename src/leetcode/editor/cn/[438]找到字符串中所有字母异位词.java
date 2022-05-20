package leetcode.editor.cn;

//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 890 👎 0

import java.util.ArrayList;
import java.util.List;

class FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        solution.findAnagrams("cbaebabacd","abc");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //根据需要选择map或者array
        int[] map = new int[128];
        int left = 0, right = 0;
        int len = p.length();
        int n = s.length();
        List<Integer> res = new ArrayList();
        int count = 0;
        int last_l = -1;

        for(char c : p.toCharArray()){
            map[c]++;
        }

        //开始遍历
        while(right < n){
            //首先选择右边的index并且做一些常规操作
            char cRight = s.charAt(right);
            right++;
            //这里是我们要对所需要处理的index对应map的操作，之所以是>0判断是因为之前加过了
            //没加过的结果肯定是0，这个判断方法是可以处理duplication的
            if(map[cRight] > 0){
                count++;
            }
            //判断完再--，right什么时候++都可以，因为这里是根据char做判断
            map[cRight]--;

            while(count == len){
                char cLeft = s.charAt(left);
                //注意right已经++过了，所以判断长度的时候不需要用right - left + 1
                if(right - left == len){
                    res.add(left);
                    last_l = left;
                }
                /*
                最后，当我们判断左边指针所对应的char的时候，因为在count == 0的时候会有两种情况：

                1. s.charAt(left)不在t里面，那么在之前它的初始值必然是0而且还在我们的（left, right)区间内，
                所以他肯定是负<0 那么最多map[cLeft]++ 也只会让它==0，
                而不会>0, 不会影响到我们对count的计算
                2. s.charAt(left)在t里面，因为我们前面判断了只有map[cRight] > 0时，
                count才会-1， 所以我们可以确定这个时候map[s.charAt(left)]一定是等于0的，
                在map[cLeft]++之后，他肯定是大于0的
                并且因为永远都是先判断再后++，所以就算不在t里的char被+到0了，那也是判断之后的事情了
                */
                if(map[cLeft] >= 0){
                    count--;
                }

                map[cLeft]++;
                left++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}