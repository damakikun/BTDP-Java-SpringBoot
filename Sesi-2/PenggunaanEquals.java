public class PenggunaanEquals {
    public static void main(String[] args) {
        String x = new String("Test");
        String y = new String("Test");
        String sameX = x;

        boolean hasil1 = x == y;
        boolean hasil2 = x.equals(y);
        boolean hasil3 = x == sameX;

        System.out.println(hasil1);
        System.out.println(hasil2);
        System.out.println(hasil3);
    }
}
