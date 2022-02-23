public class powerSets {
    void printPowerSet(String str) {
        int n = str.length();
        int max = (int)Math.pow(2, n);
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        powerSets ps = new powerSets();
        ps.printPowerSet("abc");
    }
}
