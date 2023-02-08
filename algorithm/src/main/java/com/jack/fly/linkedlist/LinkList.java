package com.jack.fly.linkedlist;

//链表的管理类
public class LinkList {
    ListNode head = null;

    // 写一个方法，创建链表，链表的插入方法
    // 尾插法
    public void insert(int value) {
        ListNode listNode = new ListNode(value);
        if (head == null){
            head = listNode;
            return;
        }
        ListNode tempNode = head;
        while (tempNode.next !=null){
            tempNode = tempNode.next;
        }
        tempNode.next = listNode;
    }

    // 输出链表的值
    public void printLink() {
        //定义右边指向链表当中的第一个节点
        ListNode tempNode = head;
        while (tempNode !=null){
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
    }
    //反转链表
    public void fz() {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;

        }
        head = pre;
    }
    /**
     * 当前节点类，在堆内存当中创建节点
     */
    private class ListNode {
        public int value; // 数据域
        public ListNode next; // 下一个节点的地址域

        public ListNode(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insert(5);
        linkList.insert(7);
        linkList.insert(8);
        linkList.insert(9);
        System.out.println("反转之前");
        linkList.printLink();
        linkList.fz();
        System.out.println("反转之后");
        linkList.printLink();
    }

}