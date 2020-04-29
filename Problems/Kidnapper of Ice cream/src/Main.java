import java.util.*;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        String[] sentence = scanner.nextLine().split(" ");
        for(String word : sentence) {
            if (map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }
        String[] note = scanner.nextLine().split(" ");
        for(String word : note) {
            if (map.containsKey(word) && map.get(word) > 0) {
                map.put(word, map.get(word) - 1);
            }
            else {
                System.out.println("You are busted");
                return;
            }
        }
        System.out.println("You get money");
    }
}