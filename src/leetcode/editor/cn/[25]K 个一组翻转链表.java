package leetcode.editor.cn;

//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
// Related Topics 递归 链表 👍 1627 👎 0

import java.util.Comparator;

class ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode node = new ListNode(-1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(5);
        node.next.next.next = new ListNode(8);
        solution.reverseKGroup(node,2);
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a,b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null){
                return head;
            }
            b =b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = rerverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }


    /**
     * 反转以a为头结点到b的之间的节点
     * @param p1
     * @param p2
     * @return
     */
    public ListNode rerverse(ListNode p1,ListNode p2){
        ListNode pre,cur,nxt;
        //用了迭代的思想 从头结点开始
        //首先 pre 为null  cur和nxt为p1 也就是头结点 然后
        //后移动 pre为头结点 cur为p1.next  改变指向  nxt记录下个节点
        pre = null; cur = p1; nxt = p1;

        while (cur != p2){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}