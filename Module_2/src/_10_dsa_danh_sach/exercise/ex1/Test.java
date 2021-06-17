package _10_dsa_danh_sach.exercise.ex1;

public class Test {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(1,2);
        System.out.println(myList);
        myList.ensureCapacity(4);
        System.out.println(myList);
        myList.clear();
        System.out.println(myList);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(3,10);
        System.out.println(myList);
        myList.remove(-1);
        System.out.println(myList.contains(3));
        System.out.println(myList.clone());
        System.out.println(myList.get(4));
        myList.ensureCapacity(4);
        System.out.println(myList);
    }
}
