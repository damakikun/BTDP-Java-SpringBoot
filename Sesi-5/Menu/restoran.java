// package Menu;
public class restoran {
    private String menu;
    private double harga;
    private boolean spesial;

    public void setMenu(String menu){
        this.menu = menu;
    }
    public void setHarga(double harga){
        this.harga = harga;
    }
    public void setSpesial(boolean spesial){
        this.spesial = spesial;
    }

    public String getMenu(){
        return menu;
    }
    public double getHarga(){
        return harga;
    }
    public boolean getSpesial(){
        return spesial;
    }
}
