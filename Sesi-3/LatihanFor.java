public class LatihanFor {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        
        // Menampilkan angka 0-10
        for (int i = 0; i < 11; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");

        // Menampilkan bilangan ganjil 1-20
        System.out.println("Hasil output:");
        for (int i = 1; i <= 20; i++) {
            if (i%2 != 0) {
                System.out.print(" " + i);
            }
        }
    }
}
