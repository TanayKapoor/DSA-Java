import java.util.Arrays;
import java.util.Scanner;

class Pair implements Comparable<Pair> {
    int ind, val;

    Pair(int ind, int val) {
        this.ind = ind;
        this.val = val;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.val > o.val)
            return 1;
        return -1;
    }
}

public class maxWater {
    static int maxWaterCalc(int[] height, int n) {

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++)
            pairs[i] = new Pair(i, height[i]);

        Arrays.sort(pairs);

        int minIndSoFar = pairs[n - 1].ind;
        int maxIndSoFar = pairs[n - 1].ind;
        int max = 0;
        for (int i = n - 2; i >= 0; i--) {

            int left = 0;
            if (minIndSoFar < pairs[i].ind) {
                left = (pairs[i].val * (pairs[i].ind - minIndSoFar - 1));
            }

            int right = 0;
            if (maxIndSoFar > pairs[i].ind) {
                right = (pairs[i].val * (maxIndSoFar - pairs[i].ind - 1));
            }

            max = Math.max(left, Math.max(right, max));

            minIndSoFar = Math.min(minIndSoFar,
                    pairs[i].ind);
            maxIndSoFar = Math.max(maxIndSoFar,
                    pairs[i].ind);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        System.out.print(maxWaterCalc(height, n));
    }
}
