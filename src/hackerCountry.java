import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class hackerCountry {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scan.nextInt();
        int[][] ar = new int[n][n];
        int p = 6;
        int[][][] mat = new int[p][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int s = scan.nextInt();
                if (s == 0) {
                    ar[i][j] = 1000000;
                } else {
                    ar[i][j] = s;
                }
            }
        }

        scan.close();

        for (int i = 0; i < p; i++) {
            if (i >= n) {
                break;
            }

            System.arraycopy(ar[i], 0, mat[i][0], 0, n);
        }

        for (int i = 0; i < p; i++) {
            if (i >= n) {
                break;
            }
            if (i == 4) {
                continue;
            }
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int mini = 1000000;
                    for (int s = 0; s < n; s++) {
                        int temp = mat[i][j - 1][s] + ar[s][k];
                        if (temp < mini) mini = temp;
                    }
                    mat[i][j][k] = mini;
                }
            }
        }

        double min = 1000000;
        int a = 0, b = 0;
        for (int i = 0; i < p; i++) {
            if (i >= n) {
                break;
            }
            if (i == 4) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                double s = ((double) mat[i][j][i]) / (j + 1);
                if (s < min) {
                    min = s;
                    a = mat[i][j][i];
                    b = j + 1;
                }
            }
        }
        BigInteger w = new BigInteger("" + a);
        BigInteger q = new BigInteger("" + b);
        int gcd = (w.gcd(q)).intValue();

        System.out.println((a / gcd) + "/" + (b / gcd));
    }
}