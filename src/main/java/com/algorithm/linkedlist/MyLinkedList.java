package com.algorithm.linkedlist;

public class MyLinkedList {

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(2);
        Node c = new Node(51);
        Node e = new Node(4);
        Node d = new Node(15);

        head = a;
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;

        head = sortList(a);

        Node current = head;
        while(current!=null){
            System.out.println(current.value);
            current=current.next;
        }


    }

    private static Node swap(Node a) {
        int tmp = a.value;
        a.value = a.next.value;
        a.next.value = tmp;
        return a;
    }

    static Node head;

    private static  class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //Asc
    static Node sortList(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node a = head;
        Node prev =null;

        boolean swapped = true;
        while(swapped){
            swapped = false;
            a=head;
            while(a.next !=null){
                if(a.value > a.next.value){
                    swapped = true;
                    //swap nodes
                    int tmp = a.next.value;
                    a.next.value = a.value;
                    a.value = tmp;
                }
                a=a.next;
            }
        }
        return head;
    }



}
