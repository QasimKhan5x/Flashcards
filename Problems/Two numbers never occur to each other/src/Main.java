import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] arr = new int[t];
        for(int i = 0; i < t; i++) {
            arr[i] = scanner.nextInt();
        }
        int n = scanner.nextInt(), m = scanner.nextInt();
        boolean condition = true;
        for(int i = 1; i < t && condition; i++) {
            if (arr[i - 1] == n && arr[i] == m || arr[i - 1] == m && arr[i] == n) condition = false;
        }
        System.out.println(condition);
    }
}