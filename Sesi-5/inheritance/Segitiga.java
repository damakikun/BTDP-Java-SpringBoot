// package inheritance;

public class Segitiga extends BangunDatar {

    float alas;
    float tinggi;

    @Override
    float luas() {
        float luas = (alas * tinggi) / 2;
        System.out.println("Luas Segitiga: " + luas);
        return luas;
    }

    @Override
    float keliling() {
        float keliling = 3 * alas;
        System.out.println("Keliling Segitiga: " + keliling);
        return keliling;
    }
}