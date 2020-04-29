import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] array = new int[t];
        for(int i = 0; i < t; i ++) {
            array[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        boolean contains = false;
        for(int val : array) {
            if (n == val)  {
                contains = true;
                break;
            }
        }
        System.out.println(contains);
    }
}