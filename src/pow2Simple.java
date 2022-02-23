public class pow2Simple {
    static boolean pow2S(int n) {
        if (n == 0) return false;
        while (n != 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(pow2S(8));
    }
}
