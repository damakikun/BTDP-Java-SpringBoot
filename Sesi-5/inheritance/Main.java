// package inheritance;

public class Main {
    public static void main(String[] args) {

        BangunDatar bangunDatar = new BangunDatar();

        Persegi persegi = new Persegi();
        persegi.sisi = 2;

        Lingkaran lingkaran = new Lingkaran();
        lingkaran.r = 22;

        PersegiPanjang persegiPanjang = new PersegiPanjang();
        persegiPanjang.panjang = 8;
        persegiPanjang.lebar = 4;

        Segitiga mSegitiga = new Segitiga();
        mSegitiga.alas = 12;
        mSegitiga.tinggi = 8;

        bangunDatar.luas();
        bangunDatar.keliling();

        persegi.luas();
        persegi.keliling();

        lingkaran.luas();
        lingkaran.keliling();

        persegiPanjang.luas();
        persegiPanjang.keliling();

        mSegitiga.luas();
        mSegitiga.keliling();

    }
}

class BangunDatar {
    float luas() {
        System.out.println("Menghitung luas bangun datar");
        return 0;
    }

    float keliling() {
        System.out.println("Menghitung keliling bangun datar");
        return 0;
    }
}
// class Persegi extends BangunDatar {
// float sisi;
// }

// class Lingkaran extends BangunDatar {
// float r;
// }

// class PersegiPanjang extends BangunDatar {
// float panjang, lebar;
// }

// class Segitiga extends BangunDatar {
// float alas, tinggi;
// }