import java.util.LinkedList;

public class LinkedList1 {
    public static void main(String[] args) {
        LinkedList<String> buah = new LinkedList<>();

        buah.add("Jeruk");
        buah.add("Jambu");
        buah.add("Apel");
        buah.add("Melon");
        buah.add("Semangka");
        buah.add("Nanas");
        buah.add("Sirsak");

        System.out.println("Nama buah:" + buah);
        System.out.println("Jumlah buah:" + buah.size());

        // Menambah Element
        buah.addFirst("Paling Atas");
        buah.addLast("Paling Bawah");
        buah.set(2, "Diubah");
        buah.set(5, "Diubah");

        System.out.println("Nama buah:" + buah);

        // Mengambil Element
        System.out.println("Data Teratas: " + buah.getFirst());
        System.out.println("Data Terbawah: " + buah.getLast());
        System.out.println("Data NoIndex 1: " + buah.get(1));
        System.out.println("Data NoIndex 3: " + buah.get(3));

        // Menghapus Element
        buah.removeFirst();
        buah.removeLast();
        buah.remove(1);

        System.out.println(buah);
    }
}
