import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

@SuppressWarnings("StatementWithEmptyBody")
public class ashtonAndString {

    static char ashtonString(String a, int k) {

        TreeSet<String> subStringSet = new TreeSet<>();
        //TreeSet<String> nextSubStringSet = new TreeSet<>();
        TreeSet<String> resultSet = new TreeSet<>();

        long len;
        int tempIndex;
        String str;
        int charIndex;
        for (int i = 97; i < 123; i++) {

            //System.out.println(i+"-----"+i);
            str = a;
            int fromIndex = 0;
            while ((charIndex = str.indexOf(i, fromIndex)) != -1) {
                str = str.substring(charIndex);
                subStringSet.add(str);
                fromIndex = 1;
                //str = str.replaceFirst("["+((char)i)+"]", "");
            }
            while ((str = subStringSet.pollFirst()) != null) {
                if (str.length() > 1) {
                    //char ch = str.charAt(0);
                    if (str.charAt(1) == i) {
                        //subStringSet.add(str.replaceFirst("["+ch+"]", ""));
                    } else if (str.charAt(0) != i) {
                        //nextSubStringSet.add(str.substring(1));
                        subStringSet.clear();
                        resultSet.clear();
                        break;
                    }
                }

                len = str.length();
                tempIndex = 0;
                long totLen = (len * (len + 1)) / 2;
                if (totLen >= k) {
                    //if((len*(len+1))/2 >= k){
                    int lenFnd = 0;
                    for (String strFnd : resultSet) {
                        if (str.startsWith(strFnd)) {
                            lenFnd += strFnd.length();
                        }
                    }
                    k += lenFnd;
                    for (int n = 1; n <= len; n++) {
                        if ((n * (n + 1)) / 2 > k) {
                            int diff = k - ((n - 1) * n) / 2;
                            return str.charAt(diff - 1);
                        } else if ((n * (n + 1)) / 2 == k) {
                            return str.charAt(n - 1);
                        }
                    }
                } else {
                    while (tempIndex++ < (len > 100 ? 100 : len)) {
                        String res = str.substring(0, tempIndex);
                        if (resultSet.add(res)) {
                            k -= res.length();
                        }
                    }

                    for (int n = tempIndex; n < len + 1; n++) {
                        k -= n;
                    }
                    resultSet.add(str);
                }
            }
        }

        return '$';
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            int k = Integer.parseInt(scanner.nextLine().trim());

            char res = ashtonString(s, k);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}