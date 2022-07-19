public class MyClass {
    private static void drawCircle(){
        int n=3;
        double dist;
        for (int i = 0; i <= 2 * 5; i++) {
            for (int j = 0; j <= 2 * 5; j++) {
                dist = Math.sqrt((i-n)*(i-n)+(j-n)*(j-n));
                if (dist>n-0.5&&dist<n+0.5)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.println();
        }
    }
    private static void drawTriangle(){
        int n=5;
        for(int i=1;i<=n;i++){
            for(int j=n-i;j>0;j--){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            for(int j=1;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    private static void drawSquare(){
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<n*2;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    private static void drawHexagon(){
        int n=5;
        for(int i=1;i<=n-1;i++){
            for(int j=n-i-1;j>0;j--){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            for(int j=1;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int j=0;j<(n-1)*2-1;j++){
            System.out.print("*");
        }
        System.out.println();
        for(int i=n-1;i>0;i--){
            for(int j=n-i-1;j>0;j--){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            for(int j=1;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    private static void drawOctagon(){
        int n=5;
        for(int i=1;i<=n-1;i++){
            for(int j=n-i-1;j>0;j--){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            for(int j=0;j<n-1;j++){
                System.out.print("*");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int j=0;j<n*3-3;j++){
            System.out.print("*");
        }
        System.out.println();
        for(int i=n-1;i>0;i--){
            for(int j=n-i-1;j>0;j--){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            for(int j=0;j<n-1;j++){
                System.out.print("*");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    private static void drawDecagon(){
        int n=5;
        for(int i=1;i<=n-1;i++){
            for(int j=0;j<n;j++){
                System.out.print(" ");
            }
            for(int j=n-i-1;j>0;j--){
                System.out.print("    ");
            }
            for(int j=0;j<i;j++){
                System.out.print("**");
            }
            for(int j=0;j<n-1;j++){
                System.out.print("*");
            }
            for(int j=0;j<i;j++){
                System.out.print("**");
            }
            System.out.println();
        }
        for(int i=1;i<=n-1;i++){
            for(int j=n-i-1;j>0;j--){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            for(int j=0;j<n*8-2;j++){
                System.out.print("*");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n*9+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n-1;i>0;i--){
            for(int j=n-i-1;j>0;j--){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            for(int j=0;j<n*8-2;j++){
                System.out.print("*");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
//        for(int i=n-1;i>0;i--){
//            for(int j=0;j<n;j++){
//                System.out.print(" ");
//            }
//            for(int j=n-i-1;j>0;j--){
//                System.out.print("    ");
//            }
//            for(int j=0;j<i;j++){
//                System.out.print("**");
//            }
//            for(int j=0;j<n-1;j++){
//                System.out.print("*");
//            }
//            for(int j=0;j<i;j++){
//                System.out.print("**");
//            }
//            System.out.println();
//        }
    }
    public static void draw(int sides){
        switch(sides){
            case 0: drawCircle();break;
            case 3: drawTriangle();break;
            case 4: drawSquare();break;
            case 6: drawHexagon();break;
            case 8: drawOctagon();break;
            case 10:drawDecagon();break;
            default: System.out.println("operation failed");
        }
    }
    public static void main(String args[]) {
//        draw(10);
        //   draw(3);
        //   System.out.println("\n\n");
        //   draw(4);
        //   System.out.println("\n\n");
        //   draw(6);
        //   System.out.println("\n\n");
        //   draw(8);
        //   System.out.println("\n\n");
           draw(10);
    }
}