public class kthbitrs {
    static void kthbitLeftShift(int n, int k) {
        if ((n & (1 << k - 1)) != 0) {
            System.out.println("YES");
        } else System.out.println("NO");
    }

    static void kthbitRightShift(int n, int k) {
        if (((n >> k) & 1) != 1) {
            System.out.println("YES");
        } else System.out.println("NO");
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 1;
        kthbitRightShift(5, 1);
        kthbitLeftShift(8, 2);
    }
}
