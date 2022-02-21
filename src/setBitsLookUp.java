public class setBitsLookUp {
    static int[] table = new int[256];

    static void initialize(){
        table [0] = 0;
        for (int i = 1; i < 256; i++) {
            table[i] = (i & 1) + table[i / 2];
        }
    }

    static int countSetBits(int n){
        return table[n & 0xFF] + table[(n >> 8) & 0xFF] + table[(n >> 16) & 0xFF] + table[(n >> 24) & 0xFF];
    }

    public static void main(String[] args) {
        initialize();
        int n = 9;
        System.out.println(countSetBits(n));
    }
}
