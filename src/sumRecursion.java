public class sumRecursion {
    static int getSum(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + getSum(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(getSum(5));
    }
}
