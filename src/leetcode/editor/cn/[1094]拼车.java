package leetcode.editor.cn;

//车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向） 
//
// 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有
// numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。 
//
// 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
// Related Topics 数组 前缀和 排序 模拟 堆（优先队列） 👍 173 👎 0

import java.util.Arrays;

class CarPooling{
    public static void main(String[] args) {
        Solution solution = new CarPooling().new Solution();
        solution.carPooling(new int[][]{{1,2,3,4,5},{2,2,3,3,4}},3);
    }

//leetcode submit region begin(Prohibit modification and deletion)
//提示中 已经说了差分数组的长度(车站的个数)为 0-1000 也就是1001个
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference df = new Difference(nums);
        for (int[] trip : trips) {
            //乘客数量
            int val = trip[0];
            //第trip[1]站乘客上车
            int i = trip[1];
            //第trip[2]站乘客已经下车
            //即乘客在车上的区域是[trip[1],trip[2] - 1]
            int j = trip[2] - 1;
            df.increment(i,j,val);
        }
        int[] res = df.result();

        //客车自始至终不应该超载
        for (int i = 0; i < res.length; i++) {
            if (capacity < res[i])
                return false;
        }
        return true;
    }
}


    /**
     * 差分数组工具类
     */
    class Difference {
        // 差分数组
        private int[] diff;

        /* 输入一个初始数组，区间操作将在这个数组上进行 */
        public Difference(int[] nums) {
            assert nums.length > 0;
            diff = new int[nums.length];
            // 根据初始数组构造差分数组
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /* 给闭区间 [i, j] 增加 val（可以是负数）*/
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        /* 返回结果数组 */
        public int[] result() {
            int[] res = new int[diff.length];
            // 根据差分数组构造结果数组
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}