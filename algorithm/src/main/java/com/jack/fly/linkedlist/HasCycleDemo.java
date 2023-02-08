package com.jack.fly.linkedlist;

import java.util.List;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-28 22:17
 * @Description: 环形链表 I
 */
public class HasCycleDemo {
    HasCycleDemo.ListNode head = null;
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        //快指针先走 N步
        for(int i = 0 ; i<n ;i++){
            fast = fast.next;
        }
        if(fast==null){
            return head.next;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;

    }
    public void insert(int value) {
        HasCycleDemo.ListNode listNode = new HasCycleDemo.ListNode(value);
        if (head == null){
            head = listNode;
            return;
        }
        HasCycleDemo.ListNode tempNode = head;
        while (tempNode.next !=null){
            tempNode = tempNode.next;
        }
        tempNode.next = listNode;
    }

    // 输出链表的值
    public void printLink() {
        //定义右边指向链表当中的第一个节点
        HasCycleDemo.ListNode tempNode = head;
        while (tempNode !=null){
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
    }

    public class ListNode{
        int value;
        ListNode next;
        ListNode(int x) {
            value = x;
             next = null;
     }
    }

    public static void main(String[] args) {
        HasCycleDemo hasCycleDemo = new HasCycleDemo();
        hasCycleDemo.insert(1);
        hasCycleDemo.insert(2);
        hasCycleDemo.insert(3);
//        hasCycleDemo.insert(4);
//        hasCycleDemo.insert(5);
//        hasCycleDemo.insert(6);
//        hasCycleDemo.insert(7);
        System.out.println("删除前：");
        hasCycleDemo.printLink();
        hasCycleDemo.removeNthFromEnd(hasCycleDemo.head, 2);
        System.out.println("删除后：");
        hasCycleDemo.printLink();



    }

    
}
