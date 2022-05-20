package leetcode.editor.cn;

//给定一个整数数组 nums，处理以下类型的多个查询: 
//
// 
// 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right 
// 
//
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 使用数组 nums 初始化对象 
// int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 
//right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] ) 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//输出：
//[null, 1, -1, -3]
//
//解释：
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
//numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
//numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 0 <= i <= j < nums.length 
// 最多调用 10⁴ 次 sumRange 方法 
// 
// Related Topics 设计 数组 前缀和 👍 459 👎 0

class RangeSumQueryImmutable{
    public static void main(String[] args) {
        NumArray solution = new RangeSumQueryImmutable().new NumArray(new int[]{3,5,2,-2,4,1});
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {

    private int[] nums;

    private int[] preSum; //前缀和数组

    //preSum数组中每个位子 存放的是前面的累加和
    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        //计算nums的累加和 例如nums为 [3,5,2,-2,4,1] 那么preSum就为[0,3,8,10,8,12,13]
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    //方法二 利用前缀和
    public int sumRange(int left, int right) {
        //因为数组中第一位存的为0
        return preSum[right + 1] - preSum[left];
    }


//    方法一  就进行累加 但效率差 因为sumRange方法会被频繁调用  时间复杂度是O(N)  N代表数组的长度
//    public int sumRange(int left, int right) {
//        int res = 0
//        for (int i = left; i <= right; i++) {
//            res += nums[i];
//        }
//        return res;
//    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}