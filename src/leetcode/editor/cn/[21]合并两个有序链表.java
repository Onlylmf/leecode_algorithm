package leetcode.editor.cn;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2414 👎 0

import java.util.Arrays;

class MergeTwoSortedLists{
    public static void main(String[] args) {

        Solution solution = new MergeTwoSortedLists().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = list1;
        ListNode p2 = list2;

        //对比p1和p2 p指向比较后小的那个 然后小的那个向后移动一位 然后p也向后移动一位
        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
                p.next = p2;
                p2 = p2.next;
            }else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;

        }
        //对比完成后 链表应该是没有走完的 所以判断不为null的 p进行连接
        if (p1 != null){
            p.next = p1;
        }

        if (p2 != null){
            p.next = p2;
        }

        return dummy.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}