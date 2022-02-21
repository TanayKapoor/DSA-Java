public class operators {
    static void andOperator(int x, int y){
        System.out.println(x & y);
    }

    static void orOperator(int x, int y){
        System.out.println(x | y);
    }

    static void xorOperator(int x, int y){
        System.out.println(x ^ y);
    }

    static void notOperator(int x){
        System.out.println(~x);
    }

    static void leftShiftOperator(int x, int y){
        System.out.println(x << y);
    }

    static void rightShiftOperator(int x, int y){
        System.out.println(x >> y);
    }

    static void unsignedRightShiftOperator(int x, int y){
        System.out.println(x >>> y);
    }




    public static void main(String[] args) {
        andOperator(1, 2);
        orOperator(1, 2);
        xorOperator(1, 2);
        notOperator(1);
        leftShiftOperator(1, 2);
        rightShiftOperator(1, 2);
    }
}
