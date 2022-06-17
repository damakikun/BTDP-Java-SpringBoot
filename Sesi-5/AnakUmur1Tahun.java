public class AnakUmur1Tahun extends induk implements AktivitasPagi {
    @Override
    public void anakSiapa() {
        System.out.println("Nama anaknya adalah "+namaAnak);
    }

    @Override
    public void hobiAnak() {
        System.out.println("Hobi anaknya adalah "+hobiAnak);
    }
}