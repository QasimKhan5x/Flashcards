import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        boolean sorted = true;
        String n = scanner.next();
        while (scanner.hasNext()) {
            String m = scanner.next();
            if (n.compareTo(m) > 0) {
                sorted = false;
                break;
            }
            n = new String(m);
        }
        System.out.println(sorted);
    }
}