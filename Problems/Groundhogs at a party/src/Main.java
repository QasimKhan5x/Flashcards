import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int candy = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();
        if ((!isWeekend && candy >= 10 && candy <= 20) ||
                (isWeekend && candy >= 15 && candy <= 25)) System.out.println(true);
        else System.out.println(false);
    }
}