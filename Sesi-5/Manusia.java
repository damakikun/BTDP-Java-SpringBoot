abstract class Manusia {
    protected abstract void nyanyiLagu();
}

class Cowok extends Manusia {
    @Override
    protected void nyanyiLagu(){
        System.out.println("da du du di dam");
    }
}

class Cewek extends Manusia {
    @Override
    protected void nyanyiLagu(){
        System.out.println("du ri dam dam");
    }
}

class Cetak {
    public static void main(String[] args) {
        Manusia cowok = new Cowok();
        cowok.nyanyiLagu();

        Manusia cewek = new Cewek();
        cewek.nyanyiLagu();
    }
}
