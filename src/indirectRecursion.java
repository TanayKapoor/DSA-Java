public class indirectRecursion {
    static void fun1(int n) {
        if (n > 0) {
            System.out.println("Fun1");
        }
    }

    static void fun2(int n) {
        fun1(n - 1);
    }

    public static void main(String[] args) {
        fun2(2);
    }
}
