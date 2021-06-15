package _10_dsa_danh_sach.practise.practise1;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(3);
        listInteger.add(4);

        System.out.println(listInteger);
        listInteger.get(-1);
        System.out.println("element -1: " + listInteger.get(-1));
    }
}
