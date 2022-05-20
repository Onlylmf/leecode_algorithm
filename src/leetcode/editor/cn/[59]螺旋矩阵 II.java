package leetcode.editor.cn;

//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 709 👎 0

//螺旋矩阵 顺时针旋转得出

/**
 *                   ----> upper_bound
 *                 1   2   3   4   5   6
 *  left_bound ^   7   8   9  10  11  12  |
 *             |  13  14  15  16  17  18  |
 *             |  19  20  21  22  23  24  |
 *             |  25  26  27  28  29  30  V right_bound
 *                31  32  33  34  35  36
 *                 < ---- lower_bound
 */
class SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int upper_bound = 0;
        int lower_bound = n - 1;
        int left_bound = 0;
        int right_bound = n-1;
        //需要填入矩阵的数字
        int num = 1;

        while (num <= n * n){
            if (upper_bound <= lower_bound){
                //在顶部从左向右遍历
                for (int i = left_bound; i <= right_bound; i++) {
                    matrix[upper_bound][i] = num++;
                }
                //上边界下移
                upper_bound++;
            }

            if (lower_bound <= right_bound){
                //右侧从上向下遍历
                for (int i = upper_bound; i <= lower_bound; i++) {
                    matrix[i][right_bound] = num++;
                }
                //右边界左移
                right_bound--;
            }

            if (upper_bound <= lower_bound){
                //底部从右往左遍历
                for (int i = right_bound; i >= left_bound; i--) {
                    matrix[lower_bound][i] = num++;
                }
                //下边上移
                lower_bound--;
            }

            if (left_bound <= right_bound){
                //从下向上遍历
                for (int i = lower_bound; i >= upper_bound; i--) {
                    matrix[i][left_bound] = num++;
                }
                //左侧边界右移
                left_bound++;
            }
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}