public class computingPower {
    static void power (int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        power(2, 3);
    }
}
