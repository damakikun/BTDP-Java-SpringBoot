import java.util.Scanner;

class BinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int c, first, last, middle, n, search, array[];

        System.out.println("Enter number of elements");

        n = scan.nextInt();
        array = new int[n];

        System.out.println("Enter " + n + " integers");
        for (c = 0; c < n; c++) {
            array[c] = scan.nextInt();
        }
        System.out.println("Enter value to find");
        search = scan.nextInt();
        first = 0;
        last = n - 1;
        middle = (first + last) / 2;
        while (first <= last) {
            if (array[middle] < search) {
                first = middle + 1;
            } else if(array[middle] == search) {
                System.out.println(search + " found a location " + (middle + 1) + ".");
                break;
            } else {
                last = middle - 1;
                middle = (first + last) / 2;
            }
        }
        if (first > last) {
            System.out.println(search + " is not present in the list.\n");
        }
    }
}
