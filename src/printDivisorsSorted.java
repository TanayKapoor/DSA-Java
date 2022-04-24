public class printDivisorsSorted {
    static void printDivisorsSorted(int n) {
        int i = 1;
        for (i = 1; i * i < n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
        for (; i * i <= 1; i++) {
            if (n % i == 0) {
                System.out.println(n / i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 150;
        printDivisorsSorted(n);
    }
}
