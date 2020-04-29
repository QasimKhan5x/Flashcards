import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int t = scanner.nextInt();
        int[] arr = new int[t];
        for(int i = 0; i < t; i++) arr[i] = scanner.nextInt();
        System.out.print(arr[t - 1] );
        for(int i = 1; i < t; i++) {
            System.out.print(" " + arr[i - 1]);
        }
    }
}