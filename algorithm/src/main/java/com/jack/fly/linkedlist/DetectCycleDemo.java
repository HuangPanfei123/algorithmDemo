package com.jack.fly.linkedlist;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-30 21:45
 * @Description: 环形链表 II
 */
public class DetectCycleDemo {

    public ListNode detectCycle(ListNode head) {
        //快慢指针
        ListNode fast =  head;
        ListNode slow =  head;

        //判断是否有环
        while(fast!=null&&fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            //判断是否有环
            if(fast==slow){
               while (head!=slow){
                   head = head.next;
                   slow =slow.next;
               }
                return  slow;
            }

        }

        return null;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
