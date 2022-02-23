public class pow2 {
    static boolean pow2Efficient(int n) {
        if (n == 0) return false;
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(pow2Efficient(8));
    }
}
