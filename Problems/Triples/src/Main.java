import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        if (t < 3) {
            System.out.println(0);
            return;
        }
        int count = 0;
        int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
        if (a == b - 1 && b == c - 1) ++count;
        for(int i = 0; i < t - 3; i++) {
            a = b;
            b = c;
            c = scanner.nextInt();
            if (a == b - 1 && b == c - 1) ++count;
        }
        System.out.println(count);
    }
}