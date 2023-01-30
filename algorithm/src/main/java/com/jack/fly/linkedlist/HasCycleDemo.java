package com.jack.fly.linkedlist;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-28 22:17
 * @Description: 环形链表 I
 */
public class HasCycleDemo {
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast.next!=null){
            fast =fast.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
             next = null;
     }
    }
}
