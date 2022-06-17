import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan jumlah data : ");
        int jlh_data = scan.nextInt();

        int[] data = new int[jlh_data];
        System.out.println();
        for (int x = 0; x < jlh_data; x++) {
            System.out.print("Input nilai data ke-" + (x+1) + " : ");
            data[x] = scan.nextInt();
        }

        System.out.println();
        System.out.print("Data sebelum di sorting : ");
        for (int x = 0; x < jlh_data; x++) {
            System.out.print(data[x] + " ");
        }

        System.out.println("\n\nProses Selection Sort");
        for (int x = 0; x < jlh_data-1; x++) {
            System.out.println("Iterasi ke-" + (x+1) + " : ");
            for (int y = 0; y < jlh_data; y++) {
                System.out.print(data[y] + " ");
            }

            System.out.println("    Apakah data " + data[x] + " sudah benar pada urutannya?");

            boolean tukar = false;
            int index = 0;
            int min = data[x];
            String pesan = "    Tidak ada pertukaran";
            for (int y = x+1; y < jlh_data; y++) {
                if (min > data[y]) {
                    tukar = true;
                    index = y;
                    min = data[y];
                }
            }
            if (tukar == true) {
                pesan = "   Data " + data[x] + " ditukar dengan data " + data[index];
                int temp = data[x];
                data[x] = data[index];
                data[index] = temp;
            }

            for (int y = 0; y < jlh_data; y++) {
                System.out.print(data[y] + " ");
            }
            System.out.println(pesan + "\n");
        }
        System.out.println("Data setelah di sorting : ");
        for (int x = 0; x < jlh_data; x++) {
            System.out.println(data[x] + " ");
        }
    }
}
