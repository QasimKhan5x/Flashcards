import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] yearlyIncomes = new int[t];
        for(int i = 0; i < t; i++) {
            yearlyIncomes[i] = scanner.nextInt();
        }
        double max = yearlyIncomes[0] * scanner.nextInt() / 100.0;
        int index = 1;
        for(int i = 1; i < t; i++) {
            double tax = yearlyIncomes[i] * scanner.nextInt() / 100.0;
            if(tax > max) {
                max = tax;
                index = i + 1;
            }
        }
        System.out.println(index);
    }
}