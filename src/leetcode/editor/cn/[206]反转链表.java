package leetcode.editor.cn;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2505 👎 0

import java.util.List;

class ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();

        ListNode node = new ListNode(-1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(5);
        node.next.next.next = new ListNode(8);
//        System.out.println(solution.reverseList(node));
        ListNode node1 = solution.reverseNList(node, 3);
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
    //递归函数要有终止递归的条件
    //就是如果链表为空或者只有一个节点的时候，反转结果就是它自己，直接返回即可

    // 例如传递 [-1，3,5,8] 第一次经过 reverseList(head.next)
    //head.next 为3 在经过 reverseList(head.next)进行压栈
    //head.next 为5 在经过 reverseList(head.next) 进行压栈
    //...
    //最后当last为最后一个8时 head为8的前一个节点5 此时5指向8 8指向null
    //          head.next.next = head; 意思是将8指向5 进行了反转  此时8->5->8->5循环
    //          head.next = null; 将5的指向改为null 然后出栈
    //上一个出栈后 last为5  head为3 此时 3指向5  5指向null
    //          head.next.next = head; 意思是将5指向3 进行了反转  此时5->3->5->3循环
    //          head.next = null; 将3的指向改为null 然后出栈
    //...
    // 最后 尾节点8变成了头节点
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    /**
     * 反转链表的前N个节点
     */
    ListNode successor = null; //后驱节点
    public ListNode reverseNList(ListNode head, int k){

        //反转以 head 为起点的 n 个节点，返回新的头结点
        if (k == 1){
            successor = head.next;
            return head;
        }
        //以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseNList(head.next, k - 1);
        head.next.next = head;
        //让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }


    /**
     * 反转链表部分节点
     */
    //如果 m == 1，就相当于反转链表开头的 n 个元素嘛，也就是我们刚才实现的功能
    //如果不等于1 如果我们把 head 的索引视为 1，那么我们是想从第 m 个元素开始反转对吧；
    //如果把 head.next 的索引视为 1 呢？那么相对于 head.next，反转的区间应该是从第 m - 1 个元素开始的
    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseNList(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}