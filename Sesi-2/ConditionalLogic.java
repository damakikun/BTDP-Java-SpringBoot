public class ConditionalLogic {
    public static void main(String[] args) {
        int x = 5;
        int z = 10;
        boolean y = x == 5;
        boolean hasil;

        if (y) {
            System.out.println("True");
        }
        if (x == 5) {
            System.out.println("x bernilai 5!");
        }

        hasil = x < z;
        System.out.println("Hasil = " + hasil);
        hasil = x > z;
        System.out.println("Hasil = " + hasil);
        hasil = x <= 5;
        System.out.println("Hasil = " + hasil);
        hasil = z >= 11;
        System.out.println("Hasil = " + hasil);
        hasil = x == z;
        System.out.println("Hasil = " + hasil);
        hasil = x != z;
        System.out.println("Hasil = " + hasil);
        hasil = x > z || x < z;
        System.out.println("Hasil = " + hasil);
        hasil = 3 < x && x < 6;
        System.out.println("Hasil = " + hasil);
        hasil = !hasil;
        System.out.println("Hasil = " + hasil);

        // If Else
        if (x == z) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
