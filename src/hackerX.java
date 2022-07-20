import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class hackerX {

    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (x == o.x) {
                return y - o.y;
            }
            return x - o.x;
        }
    }

    public static void solve(Input in, PrintWriter out) throws IOException {
        int n = in.nextInt();
        Point[] ps = new Point[n];
        for (int i = 0; i < n; ++i) {
            int t = in.nextInt();
            int f = in.nextInt();
            ps[i] = new Point(t - f, t + f);
        }

        Arrays.sort(ps);

        int[] max = new int[n + 1];
        Arrays.fill(max, Integer.MIN_VALUE);
        max[0] = Integer.MAX_VALUE;

        for (Point p : ps) {
            int l = 0, r = n;
            while (l < r - 1) {
                int mid = (l + r) / 2;
                if (max[mid] > p.y) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            max[l + 1] = p.y;
        }

        int ans = 0;
        while (ans < n && max[ans + 1] > Integer.MIN_VALUE) {
            ++ans;
        }

        out.println(ans);
    }


    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        solve(new Input(new BufferedReader(new InputStreamReader(System.in))), out);
        out.close();
    }

    static class Input {
        BufferedReader in;
        StringBuilder sb = new StringBuilder();

        public Input(BufferedReader in) {
            this.in = in;
        }

        public String next() throws IOException {
            sb.setLength(0);
            while (true) {
                int c = in.read();
                if (c == -1) {
                    return null;
                }
                if (" \n\r\t".indexOf(c) == -1) {
                    sb.append((char) c);
                    break;
                }
            }
            while (true) {
                int c = in.read();
                if (c == -1 || " \n\r\t".indexOf(c) != -1) {
                    break;
                }
                sb.append((char) c);
            }
            return sb.toString();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

    }
}