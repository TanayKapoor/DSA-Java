import java.io.IOException;
import java.util.*;

public class similarStrings {
    static final int NUM_CHARS = 11;
    static final int ENCODE_LENGTH = 85;

    static long encode(final char[] chars, final int start) {
        final int length = Math.min(similarStrings.ENCODE_LENGTH, chars.length - 1);
        long hash = 31;//5381;
        int[] sim = new int[NUM_CHARS];
        int count = 1;
        int i = start;
        for (; i <= start + length && i < chars.length; i++) {
            int sim_index = chars[i] - 'a';
            if (sim[sim_index] == 0) {
                sim[sim_index] = count;
                count++;
            }
            hash = hash * sim[sim_index] + 33;
        }
        return hash;
    }

    static Map<Long, List<Integer>> buildIndex(final char[] chars) {
        Map<Long, List<Integer>> index = new HashMap<>();

        for (int i = 0; i < chars.length - ENCODE_LENGTH; i++) {
            final long encoded = encode(chars, i);
            List<Integer> indexes = index.computeIfAbsent(encoded, k -> new LinkedList<>());
            indexes.add(i);
        }

        return index;
    }

    static boolean isSimilar(final char[] chars, final int aStart, final int aEnd, final int bOffset) {
        final int checkLength = aEnd - aStart + 1;
        int[] simI = new int[NUM_CHARS + 1];
        int[] simJ = new int[NUM_CHARS + 1];
        for (int i = 0; i < checkLength; i++) {
            int indexI = chars[i + aStart] - 'a' + 1;
            int indexJ = chars[i + bOffset] - 'a' + 1;
            if (simI[indexI] == 0 && simJ[indexJ] == 0) {
                simI[indexI] = indexJ;
                simJ[indexJ] = indexI;
            } else if (simI[indexI] != indexJ || simJ[indexJ] != indexI)
                return false;
        }
        return true;
    }

    /*
     * Complete the similarStrings function below.
     */
    static int similarStrings(final char[] chars, int start, int end, Map<Long, List<Integer>> charIndex) {
        final int sLength = chars.length;
        final int checkLength = end - start + 1;
        int answer = 0;
        if (checkLength == 1)
            answer = sLength;
        else if (checkLength == ENCODE_LENGTH) {
            List<Integer> indexes = charIndex.get(encode(chars, start - 1));
            answer = indexes == null ? 1 : indexes.size();
        } else if (checkLength < ENCODE_LENGTH) {
            for (int index = 0; index <= sLength - checkLength; index++)
                if (index == start - 1 ||
                        isSimilar(chars, start - 1, end - 1, index))
                    answer++;
        } else {
            List<Integer> indexes = charIndex.get(encode(chars, start - 1));
            if (indexes == null)
                answer = 1;
            else {
                for (Integer index : indexes) {
                    if (index + checkLength > chars.length) {
                        break;
                    } else if (index == start - 1 ||
                            isSimilar(chars, start - 1, end - 1, index))
                        answer++;
                }
            }
            if (answer == 0)
                answer = 1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        final Scanner input = new Scanner(System.in);

        String[] nq = input.nextLine().split(" ");
        final int n = Integer.parseInt(nq[0].trim());
        final int q = Integer.parseInt(nq[1].trim());

        final String s = input.nextLine().trim();
        final char[] sChars = s.toCharArray();
        final Map<Long, List<Integer>> index = buildIndex(sChars);

        StringBuilder answer = new StringBuilder(q * 3);
        for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
            final int l = input.nextInt();
            final int r = input.nextInt();

            final int result = similarStrings(sChars, l, r, index);

            answer.append(result);
            answer.append('\n');
        }
        System.out.print(answer);

        input.close();
    }
}