package _10_dsa_danh_sach.exercise.ex2;

public class MyLinkedList<E> {
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    private Node head, tail;
    private int numNodes;

    public MyLinkedList() {
    }

    public void add(int index, E data) {
//        if (index == 0) addFirst(e); //
//        else if (index >= numNodes) addLast(e);
//        else {
//            Node current = head;
//            for (int i = 1; i < index; i++)
//                current = current.next;
//            Node temp = current.next;
//            current.next = new Node(e);
//            (current.next).next = temp;
//            numNodes++;
//        }
        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E element) {//1,2,3,4
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        if (tail == null) {
            head = tail = new Node(element);
        } else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        numNodes++;
    }

    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public E removeFirst() {
        if (numNodes == 0) {
            return null;
        } else {
            Node temp = head;
            head = head.next;
            numNodes--;
            if (head == null) {
                tail = null;
            }
            return (E) temp.data;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return removeFirst();
        } else {
            Node previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node current = previous.next;
            previous.next = current.next;
            numNodes--;
            return (E) current.data;
        }
    }

    public boolean remove(E element){
        if (head.data.equals(element)){
            remove(0);
            return true;
        } else {
            Node temp = head;

            while (temp.next != null){
                if (temp.next.data.equals(element)){
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }

    public MyLinkedList<E> clone(){
        if (numNodes==0){
            throw new NullPointerException();
        }
        MyLinkedList<E> temp =new MyLinkedList<E>();
        Node tempNode = head;
        temp.addFirst((E) tempNode.data);
        tempNode = tempNode.next;
        while (tempNode!= null){
            temp.addLast((E) tempNode.data);
            tempNode = tempNode.next;
        }
        return temp;
    }

    public int size() {
        return numNodes;
    }

    public boolean contains(E element) {
        Node temp = head;

        while (temp.next != null) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        if (temp.data.equals(element)) {
            return true;
        }
        return false;
    }

    public int indexOf(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(element)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


}
