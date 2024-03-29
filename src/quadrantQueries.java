import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class quadrantQueries {
    private static final int[] BC = new int[1 << 16];

    public static void main(String[] argv) throws Exception {
        prep();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        int N = Integer.parseInt(line1);
        ArrayList<String> dump = new ArrayList<>(100000);
        int[] x = new int[N / 32 + 1];
        int[] y = new int[N / 32 + 1];
        for (int i = 0; i < N; i++) {
            String line2 = br.readLine();
            String[] tmp2 = line2.split(" ");
            if (tmp2[0].charAt(0) != '-') x[i / 32] |= 1 << i % 32;
            if (tmp2[1].charAt(0) != '-') y[i / 32] |= 1 << i % 32;
        }
        String line3 = br.readLine();
        int Q = Integer.parseInt(line3);
        for (int i = 0; i < Q; i++) {
            String line4 = br.readLine();
            String[] tmp4 = line4.split(" ");
            int sindex = Integer.parseInt(tmp4[1]);
            int eindex = Integer.parseInt(tmp4[2]);
            int sm = (sindex - 1) % 32;
            int sn = (sindex - 1) / 32;
            int em = eindex % 32;
            int en = eindex / 32;
            int es = eindex - sindex + 1;
            if (tmp4[0].equals("X")) {
                if (sn == en) {
                    int mask = ((1 << (es)) - 1) << (sm);
                    y[en] ^= mask;
                } else {
                    int mask = -1;
                    int fmask = mask << (sm);
                    int emask = (1 << (em)) - 1;
                    y[sn] ^= fmask;
                    for (int j = sn + 1; j < en; j++) y[j] ^= mask;
                    y[en] ^= emask;
                }
            } else if (tmp4[0].equals("Y")) {
                if (sn == en) {
                    int mask = ((1 << (es)) - 1) << (sm);
                    x[en] ^= mask;
                } else {
                    int mask = -1;
                    int fmask = mask << (sm);
                    int emask = (1 << (em)) - 1;
                    x[sn] ^= fmask;
                    for (int j = sn + 1; j < en; j++) x[j] ^= mask;
                    x[en] ^= emask;
                }
            } else {
                int maskes = ((1 << (es)) - 1) << (sm);
                int maskall = -1;
                int fmask = maskall << (sm);
                int emask = (1 << (em)) - 1;
                // 1st quadrant x bit: 1, y bit: 1 (x & y)
                int c1 = 0;
                if (sn == en) {
                    c1 += bitCount(x[en] & y[en] & maskes);
                } else {
                    c1 += bitCount(x[sn] & y[sn] & fmask);
                    for (int j = sn + 1; j < en; j++) c1 += bitCount(x[j] & y[j]);
                    c1 += bitCount(x[en] & y[en] & emask);
                }
                // 2nd quadrant x bit: 0, y bit: 1
                // 4th quadrant x bit: 1, y bit: 0
                // x xor y = c2 + c4
                // (x xor y) & y = c2
                int c24 = 0;
                int c2 = 0;
                int t2;
                if (sn == en) {
                    t2 = (x[en] ^ y[en]) & maskes;
                } else {
                    t2 = (x[sn] ^ y[sn]) & fmask;
                    c24 += bitCount(t2);
                    c2 += bitCount(t2 & y[sn]);
                    for (int j = sn + 1; j < en; j++) {
                        t2 = x[j] ^ y[j];
                        c24 += bitCount(t2);
                        c2 += bitCount(t2 & y[j]);
                    }
                    t2 = (x[en] ^ y[en]) & emask;
                }
                c24 += bitCount(t2);
                c2 += bitCount(t2 & y[en]);
                int c4 = c24 - c2;
                // 3rd quadrant x bit: 0, y bit: 0 (total - c1 - c2 - c4)
                int c3 = eindex - sindex + 1 - c1 - c2 - c4;
                dump.add(c1 + " " + c2 + " " + c3 + " " + c4);
                //System.out.println(c1+" "+c2+" "+c3+" "+c4);
            }
        }
        for (String s : dump) System.out.println(s);
        br.close();
    }

    private static void prep() {
        int max = 1 << 16;
        int step1 = 1 << 8;
        for (int i = 0; i < step1; i++) BC[i] = Integer.bitCount(i);
        for (int i = step1; i < max; i++) {
            BC[i] = BC[i & 0xFF] + BC[(i >> 8) & 0xFF];
        }
    }

    private static int bitCount(int i) {
        return BC[i & 0xFFFF] + BC[(i >> 16) & 0xFFFF];
    }
}