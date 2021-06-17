package _10_dsa_danh_sach.exercise.ex2;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1,"2");
        myLinkedList.add(2,"3");
        myLinkedList.add(3,"4");
        myLinkedList.add(4,"5");
        myLinkedList.addFirst("1");
        myLinkedList.remove(3);
        System.out.println("remove");
        myLinkedList.printList();
        System.out.println(myLinkedList.indexOf("4"));
        System.out.println(myLinkedList.indexOf("5"));
        myLinkedList.clone().printList();
    }
}
