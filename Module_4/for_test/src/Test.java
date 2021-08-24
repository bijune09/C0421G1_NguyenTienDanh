public class Test {
//    Cho mảng số nguyên A bao gồm n phần tử. Viết chương trình tìm các cặp số liên tiếp nhau có tổng chia hết cho 2.
//    Hai số liền nhau tạo thành 1 cặp số.
    static int findNumber(int[] array){
        int number = 0;
        for (int i = 0; i < array.length-1;i++){
            if ( ((array[i]+array[i+1])%2) == 0){
                  number++;
//                System.out.println(array[i]);
//                System.out.println(array[i+1]);
            }
        }
        return number;
    }

    public static void main(String[] args) {
        int[] array = {2,2,3,4,5,5,12,194,18,281,28,10};
        System.out.println(findNumber(array));
    }
}
