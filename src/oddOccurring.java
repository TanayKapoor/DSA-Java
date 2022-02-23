public class oddOccurring {
    static int findOdd(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = count ^ arr[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 2, 3};
        int n = arr.length;
        System.out.println(findOdd(arr, n));
    }
}
