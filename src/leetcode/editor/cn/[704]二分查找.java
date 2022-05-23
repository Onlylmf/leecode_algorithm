package leetcode.editor.cn;

//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 数组 二分查找 👍 831 👎 0

class BinarySearch{
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        int search = solution.searchRight(new int[]{1, 2, 3, 3, 3, 4,4, 4, 5, 6}, 4);
        System.out.println(search);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }




    /**
     * 寻找靠左侧边界的二分查找
     * @param nums
     * @param target
     * @return
     */
    public int searchLeft(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        //比如对于有序数组 nums = [2,3,5,7], target = 1，算法会返回 0，含义是：nums 中小于 1 的元素有 0 个。
        //再比如说 nums = [2,3,5,7], target = 8，算法会返回 4，含义是：nums 中小于 8 的元素有 4 个。
        if (left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }


    /**
     * 寻找靠右侧边界的二分查找
     * @param nums
     * @param target
     * @return
     */
    public int searchRight(int[] nums,int target){
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意 锁定右侧边界
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return left; // 注意
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}