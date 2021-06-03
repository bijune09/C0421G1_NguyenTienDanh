package _03_array_n_method.exercise;

public class MergeArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {5,6,7,8,9};
        int[] arr3 = new int[arr1.length+arr2.length];
        for (int i = 0; i<arr1.length;i++){
            arr3[i] = arr1[i];
        }
        for (int j = 0; j<arr2.length;j++){
            arr3[arr1.length+j] = arr2[j];
        }
        for (int array : arr3) {
            System.out.print(array+" ");
        }
    }
}
