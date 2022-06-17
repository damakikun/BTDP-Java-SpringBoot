// package Menu;
public class makanan {
    public static void main(String[] args) {
        restoran data = new restoran();

        data.setMenu("Ayam Goreng");
        data.setHarga(17.000);
        data.setSpesial(true);

        System.out.println("Menu Makanan : " + data.getMenu());
        System.out.println("Harga Makanan : " + data.getHarga());
        System.out.println("Menu Spesial : " + data.getSpesial());
    }
}
