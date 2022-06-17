public class OperatorPembanding {
    public static void main(String[] args) {
        int a = 2;
        int b = 2;

        boolean c = a == b;
        boolean d = a != b;
        boolean e = a > b;
        boolean f = a < b;
        boolean g = a >= b;
        boolean h = a <= b;

        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);

        // Bagian 2
        int nilaiA = 12;
        int nilaiB = 4;
        boolean hasil;

        System.out.println("Ini bagian 2 : ");
        
        hasil = nilaiA > nilaiB;
        System.out.println(hasil);

        hasil = nilaiA < nilaiB;
        System.out.println(hasil);

        hasil = nilaiA >= nilaiB;
        System.out.println(hasil);

        hasil = nilaiA <= nilaiB;
        System.out.println(hasil);

        hasil = nilaiA == nilaiB;
        System.out.println(hasil);

        hasil = nilaiA != nilaiB;
        System.out.println(hasil);
    }
}
