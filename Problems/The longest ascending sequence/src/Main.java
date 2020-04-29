import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n = scanner.nextInt();
        boolean ascending = true;
        int maxLength = 1;
        int currLength = 1;
        for (int i = 0; i < t - 1; i++) {
            int m = scanner.nextInt();
            if (n < m) ++currLength;
            else currLength = 1;
            if (currLength > maxLength) maxLength = currLength;
            n = m;
        }
        System.out.println(maxLength);
    }
}