package leetcode.editor.cn;

//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
// Related Topics 数组 数学 矩阵 👍 1296 👎 0

class RotateImage{

    //将一个矩阵顺时针旋转90°  就是先将矩阵 左上至右下对角线进行镜像对称， 然后反转二维数组的每一行
    //会发现所成的矩阵就是旋转90°后的
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        //先遍历整个二维矩阵
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                //左上 右下对称交换
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //反转二维矩阵每一行
        for (int[] arr: matrix) {
            reverse(arr);
        }
    }

    //反转一维数组
    //左右指针思想 从两边替换依次向中间靠近
    void reverse(int[] arr){
        int left = 0; int right = arr.length - 1;
        while (left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}