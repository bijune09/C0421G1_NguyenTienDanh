package _10_dsa_danh_sach.exercise.ex2;

import java.util.LinkedList;

public class MyLinkedList<E> {
    private Node head,tail;
    private int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    private class Node {
        private Node next;
        private final Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, E e) {
        if (index == 0) addFirst(e); //
        else if (index >= numNodes) addLast(e);
        else {
            Node current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node temp = current.next;
            current.next = new Node(e);
            (current.next).next = temp;
            numNodes++;
        }
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(Object data) {
        if (tail == null){
            head = tail = new Node(data);
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
        numNodes++;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public E removeFirst(){
        if (numNodes==0){
            return null;
        } else {
            Node temp = head;
            head = head.next;
            numNodes--;
            if (head == null){
                tail = null;
            }
            return (E) temp.data;
        }
    }

    public E removeLast(){
        if (numNodes==0){
            return null;
        } else if (numNodes==1){
            Node temp = head;
            head = tail = null;
            numNodes=0;
            return (E) temp.data;
        } else {
            Node current = head;
            for (int i=0;i<numNodes-2;i++){
                current = current.next;
            }
            Node temp = tail;
            tail = current;
            tail.next = null;
            numNodes--;
            return (E) temp.data;
        }
    }

    public E remove(int index){
        if (index<0||index>=numNodes){
            return null;
        } else if (index==0){
            return removeFirst();
        } else if (index==numNodes-1){
            return removeLast();
        } else {
            Node previous = head;

            for (int i = 1; i<index;i++){
                previous =  previous.next;
            }
            Node current = previous.next;
            previous.next = current.next;
            numNodes--;
            return (E) current.data;
        }
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Boolean> myLinkedList = new MyLinkedList<>(5);
        myLinkedList.add(1,true);
        myLinkedList.add(2,false);
        myLinkedList.add(3,false);
        myLinkedList.remove();
        myLinkedList.printList();

    }

}
