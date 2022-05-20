package leetcode.editor.cn;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 1100 👎 0

import java.util.LinkedList;
import java.util.List;


/**
 *                   ----> upper_bound
 *                 1   2   3   4   5   6
 *  left_bound ^   7   8   9  10  11  12  |
 *             |  13  14  15  16  17  18  |
 *             |  19  20  21  22  23  24  |
 *             |  25  26  27  28  29  30  √ right_bound
 *                31  32  33  34  35  36
 *                 < ---- lower_bound
 */
class SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int[][] a = new int[][]{{1,2,3,4,5},{1,1,1,1,1},{2,3,4,5,6}};
        System.out.println(solution.spiralOrder(a));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 给一个矩阵以顺时针旋转 返回所有元素, 类似花卷一样
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; //行长度
        int n = matrix[0].length; //第一列的长度
        int uppper_bound = 0;
        int lower_bound = m - 1;
        int left_bound = 0;
        int rigth_bound = n - 1;
        LinkedList<Integer> res = new LinkedList<>();
        while (res.size() < m * n){ //res.size == m * n 时相当于遍历完了整个数组
            if (uppper_bound <= lower_bound){//根据行判断在
                //早顶部从左向右遍历
                for (int j = left_bound; j <= rigth_bound; j++) {
                    res.add(matrix[uppper_bound][j]);
                }
                //上边界下移
                uppper_bound++;
            }

            if (left_bound <= rigth_bound){
                //在右侧从上向下遍历
                for (int i = uppper_bound; i <= lower_bound; i++) {
                    res.add(matrix[i][rigth_bound]);
                }
                //右边界左移
                rigth_bound--;
            }

            if (uppper_bound <= lower_bound){
                //在底部从右向左遍历
                for (int j = rigth_bound; j >=left_bound ; j--) {
                    res.add(matrix[lower_bound][j]);
                }
                //下边界向上移
                lower_bound--;
            }

            if (left_bound <= rigth_bound){
                //在左侧从下向上遍历
                for (int i = lower_bound; i >= uppper_bound; i--) {
                    res.add(matrix[i][left_bound]);
                }
                //左边界右移
                left_bound++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}