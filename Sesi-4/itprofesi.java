import java.util.Scanner;

public class itprofesi {
    public static void main(String[] args) {
        String[] itprofesi = new String[5];

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < itprofesi.length; i++) {
            System.out.print("Buah ke-" + i + ": ");
            itprofesi[i] = scan.nextLine();
        }
        System.out.println("==============================");

        for (String b : itprofesi) {
            System.out.println(b);
        }
    }
}
