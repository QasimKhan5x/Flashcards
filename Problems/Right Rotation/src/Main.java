import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split("\\s+");

        int shift = scanner.nextInt();

        if (shift > array.length) {
            shift %= array.length;
        }

        /* Left rotation
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s ", array[(i + shift) % array.length]);
        }
        System.out.println();
        */

        // Right rotation
        for (int i = shift; i > shift - array.length; i--) {
            System.out.printf("%s ", array[i > 0 ? array.length - i : 0 - i]);
        }
    }
}