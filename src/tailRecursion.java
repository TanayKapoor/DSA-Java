public class tailRecursion {
    static void fun1(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        fun1(n - 1);
    }

    static void fun2(int n) {
        if (n == 0) {
            return;
        }
        fun2(n - 1);
        System.out.println(n);
    }
}
