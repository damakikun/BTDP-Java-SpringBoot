public class Cetak {
    static double maxNumber(double a, double b){
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    static int maxNumber(int a, int b){
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        System.out.println(maxNumber(10, 20));
        System.out.println(maxNumber(4.5, 7.5));
        // System.out.println(4,5,7,5);
    }
}
