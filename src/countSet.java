public class countSet {
    static int countSetBitsSimple(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                res++;
                n = n >> 1;
            }
        }
        return res;
    }

    static int countSetBitsBrian(int n) {
        int res = 0;
        while (n > 0) {
            n = (n & (n - 1));
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(countSetBitsSimple(5));
        System.out.println(countSetBitsBrian(5));
    }
}
