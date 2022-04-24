public class directRecursion {
    static void fun1(int n) {
        if (n == 1) return;
        System.out.println("Fun1");
        fun1(n - 1);
    }

    public static void main(String[] args) {
        fun1(2);
    }
}
