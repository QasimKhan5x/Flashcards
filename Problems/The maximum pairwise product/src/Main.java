import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n = scanner.nextInt(), m = scanner.nextInt();
        int max = n * m;
        for(int i = 0; i < t - 2; i ++) {
            n = scanner.nextInt();
            int product = n * m;
            if (product > max) {
                max = product;
            }
            m = n;
        }
        System.out.println(max);
    }
}