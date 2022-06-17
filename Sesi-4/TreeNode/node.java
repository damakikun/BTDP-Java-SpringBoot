// package TreeNode;

class node{
    node left, right;
    int value;
    public void input(int a){
        value = a;
    }
    public static void main(String[] args) {
        tree tr = new tree();
        node root = new node();
        int menu = 1;
        int r = 1;
        int a;
        while (menu != 3) {
            System.out.println("1. Input\n2. View\n3. Exit\n : ");
            menu = tr.in.nextInt();
            if (menu==1) {
                System.out.println("Masukkan Angka : ");
                a = tr.in.nextInt();
                if (r == 1) {
                    root.input(a);
                    r--;
                } else tr.insert(root, a);
            }
            else if(menu == 2) tr.view(root);
            else if(menu == 3)  System.out.println("Keluar");
            else System.out.println("Salah");
            System.out.println(" ");
        }
    }
}
