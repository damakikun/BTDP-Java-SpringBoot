public class Array {
    public static void main(String[] args) {
        int[] contoh;
        contoh = new int[4];
        System.out.println(contoh.length);

        contoh[0] = 5;
        contoh[1] = 10;
        contoh[2] = contoh[1] + 10;

        // Cara 1
        // String[] nama;

        // Cara 2
        // String nama[];

        // Cara 3
        String[] nama = new String[5];

        nama[0] = "Adam";
        nama[1] = "Ghufron";

        // Array Handling
        System.out.println(nama[0]);
    }
}
