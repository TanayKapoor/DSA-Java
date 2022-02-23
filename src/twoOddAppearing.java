public class twoOddAppearing {
    static void oddAppearing(int[] arr) {
        int xor = 0; int res1 = 0; int res2 = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        int mask = xor & ~(xor - 1);
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & mask) != 0) {
                res1 ^= arr[i];
            } else {
                res2 ^= arr[i];
            }
        }
        System.out.println(res1 + " " + res2);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 3, 4, 5, 4, 4, 6, 7, 7};
        oddAppearing(arr);
    }
}
