import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while (true) {
            try {
                str = scanner.nextLine();
                int num = Integer.parseInt(str);
                if (num == 0) {
                    break;
                }
                num *= 10;
                System.out.println(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + str);
            }
        }
    }
}