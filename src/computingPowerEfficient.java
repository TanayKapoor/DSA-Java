public class computingPowerEfficient {
    static int computingpowerefficient(int x, int y) {
        if (y == 0)
            return 1;
        int temp = computingpowerefficient(x, y / 2);
        temp = temp * temp;
        if (y % 2 == 0)
            return temp;
        else
            return temp * x;
    }

    public static void main(String[] args) {
        System.out.println(computingpowerefficient(3, 500));
    }
}