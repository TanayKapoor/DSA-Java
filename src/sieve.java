public class sieve {
    static void sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int j = 2; j * j <= n; j++) {
            if (isPrime[j] == true) {
                for (int i = j * j; i <= n; i += j) {
                    isPrime[i] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i] == true) {
                System.out.println(i + " ");
            }
        }
    }


    public static void main(String[] args) {
        int n = 30;
        sieveOfEratosthenes(n);
    }
}
