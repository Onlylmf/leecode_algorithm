package leetcode.editor.cn;

//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1386 👎 0

class PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        
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
    public boolean isPalindrome(ListNode head) {
        //定义快慢节点 然后获取到中间点
        //如果是奇数 （1,2,3,4,5,4,3,2,1） 走完时slow指向5 fast指向1
        //  因为fast没有指向null 所以 slow需要在走一位  因为是奇数所以要获取中间值后面的倒叙链表
        //如果是偶数 （1,2,3,4,5,5,4,3,2,1）走完时slow指向第二个5 fast 指向null
        ListNode fast,slow;
        fast = slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null){
            slow = slow.next;
        }
        //以上步骤为了获取中间点后面的链表 然后将后面的链表进行反转 根据right链表进行比对 看是否相等
        ListNode left = head;
        ListNode right = reverser(slow);
        while (right != null){
            if (left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverser(ListNode head){
//       if (head == null || head.next == null){
//           return head;
//       }
//      ListNode last = reverser(head.next);
//        head.next.next = head;
//        head.next = null;
//       return last;
        ListNode pre = null,cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}