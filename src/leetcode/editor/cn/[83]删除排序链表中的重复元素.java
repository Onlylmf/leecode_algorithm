package leetcode.editor.cn;

//给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics 链表 👍 789 👎 0

class RemoveDuplicatesFromSortedList{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode fast = head,slow = head;
        //如果fast和slow的值不同 就让slow 等于 fast 如果比较值不同 fast向下移动
        while (fast != null){
            if (slow.val != fast.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        //最后将slow的指向设置为null 断开之后重复元素的连接
        slow.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}