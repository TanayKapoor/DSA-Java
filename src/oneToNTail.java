public class oneToNTail {
    static void printN(int n, int k) {
        if (n == 0) {
            return;
        }
        System.out.println(k);
        printN(n - 1, k + 1);
    }

    static int factorial (int n){
        if (n == 1){
            return 1;
        }
        return( n * factorial(n - 1));
    }

    static void factorialTail(int n, int k){
        if (n == 1 || n == 0){
            System.out.println(k);
            return;
        }
        factorialTail(n - 1, n * k);
    }

    public static void main(String[] args) {
        printN(5, 1);
    }
}
