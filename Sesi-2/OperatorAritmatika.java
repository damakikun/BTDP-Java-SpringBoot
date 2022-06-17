import java.util.Scanner;

public class OperatorAritmatika {
    public static void main(String[] args) {
        int angka1;
        int angka2;
        int hasil;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Input angka-1: ");
        angka1 = keyboard.nextInt();
        System.out.print("Input angka-2: ");
        angka2 = keyboard.nextInt();

        // Penjumlahan
        hasil = angka1 + angka2;
        System.out.println("Hasil Penjumlahan = " + hasil);

            // System.out.print("Input angka-1: ");
            // angka1 = keyboard.nextInt();
            // System.out.print("Input angka-2: ");
            // angka2 = keyboard.nextInt();

        // Pengurangan
        hasil = angka1 - angka2;
        System.out.println("Hasil Pengurangan = " + hasil);

        // System.out.print("Input angka-1: ");
        // angka1 = keyboard.nextInt();
        // System.out.print("Input angka-2: ");
        // angka2 = keyboard.nextInt();

        // Perkalian
        hasil = angka1 * angka2;
        System.out.println("Hasil Perkalian = " + hasil);

        // System.out.print("Input angka-1: ");
        // angka1 = keyboard.nextInt();
        // System.out.print("Input angka-2: ");
        // angka2 = keyboard.nextInt();

        // Pembagian
        hasil = angka1 / angka2;
        System.out.println("Hasil Pembagian = " + hasil);

        // System.out.print("Input angka-1: ");
        // angka1 = keyboard.nextInt();
        // System.out.print("Input angka-2: ");
        // angka2 = keyboard.nextInt();

        // Sisa Bagi
        hasil = angka1 % angka2;
        System.out.println("Hasil Sisa Bagi (modulus) = " + hasil);
    }
}
