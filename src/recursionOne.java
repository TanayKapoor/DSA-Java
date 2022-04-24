public class recursionOne {
    static void fun1() {
        System.out.println("fun1");
    }

    static void fun2() {
        System.out.println("before fun1");
        fun1();
        System.out.println("after fun1");
    }

    public static void main(String[] args) {
        System.out.println("Before fun2");
        fun2();
        System.out.println("After fun2");
    }
}
