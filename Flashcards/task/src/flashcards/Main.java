package flashcards;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, String> cards = new HashMap<>();
    static List<String> log = new ArrayList<>();
    static Map<String, Integer> mistakes = new HashMap<>();

    public static void main(String[] args) throws Exception {
        String exportFile = "";
        for(int i = 0; i < args.length; i += 2) {
            if (args[i].equals("-import")) {
                importCards(args[i + 1]);
            } else {
                exportFile = args[i + 1];
            }
        }
        boolean play = true;
        while (play) {
            outputln("Input the action (add, remove, import, export, ask, exit, log, hardest card" +
                    ", reset stats):");
            String action = inputString();
            switch (action) {
                case "add": {
                    add();
                    break;
                }
                case "remove": {
                    remove();
                    break;
                }
                case "import": {
                    outputln("File name:");
                    String filename = inputString();
                    importCards(filename);
                    break;
                }
                case "export": {
                    outputln("File name:");
                    String filename = inputString();
                    export(filename);
                    break;
                }
                case "ask": {
                    ask();
                    break;
                }
                case "exit": {
                    outputln("Bye bye!");
                    if (!exportFile.isEmpty())
                        export(exportFile);
                    play = false;
                    break;
                }
                case "log": {
                    saveLog();
                    break;
                }
                case "hardest card": {
                    tellHardest();
                    break;
                }
                case "reset stats": {
                    reset();
                    break;
                }
                default: {
                    outputln("Invalid action");
                }
            }
            System.out.println();
        }
    }

    public static void outputln(String str) {
        System.out.println(str);
        log.add(str);
    }
    
    public static void output(String str) {
        System.out.print(str);
        log.add(str);
    }

    public static String inputString() {
        String str = scanner.nextLine();
        log.add(str);
        return str;
    }

    public static void add() {
        outputln("The card:");
        String card = inputString();
        if (cards.containsKey(card)) {
            outputln("The card \"" + card + "\" already exists.");
            return;
        }
        outputln("The definition of the card:");
        String def = inputString();
        if (cards.containsValue(def)) {
            outputln("The definition \"" + def + "\" already exists.");
            return;
        }
        cards.put(card, def);
        outputln("The pair (\"" + card + "\":\"" + def + "\") has been added.");
    }

    public static void remove() {
        outputln("The card:");
        String card = inputString();
        if (cards.containsKey(card)) {
            cards.remove(card);
            mistakes.remove(card);
            outputln("The card has been removed.");
        }
        else
            outputln("Can't remove \"" + card + "\": there is no such card.");
    }

    public static void ask() {
        outputln("How many times to ask?");
        int t = Integer.parseInt(inputString());
        Random random = new Random();
        List<String> set = new ArrayList<String>(cards.keySet());
        for(int i = 0; i < t; i++) {
            String card = set.get(random.nextInt(set.size()));
            outputln("Print the definition of \"" + card + "\":");
            String def = inputString();
            if (cards.get(card).equals(def)) {
                outputln("Correct answer");
            } else {
                if (mistakes.containsKey(card)) {
                    mistakes.put(card, mistakes.get(card) + 1);
                } else {
                    mistakes.put(card, 1);
                }
                if (cards.containsValue(def)) {
                    System.out.print("Wrong answer. The correct one is \"" + cards.get(card) + "\", ");
                    System.out.print("you've just written the definition of \"");
                    for(String key : set) {
                        if(cards.get(key).equals(def)) {
                            outputln(key + "\".");
                            break;
                        }
                    }
                } else {
                    outputln("Wrong answer. The correct one is \"" + cards.get(card) + "\".");
                }
            }
        }
    }

    public static void tellHardest() {
        if (mistakes.isEmpty()) {
            outputln("There are no cards with errors.");
        } else {
            int max = 0;
            ArrayList<String> hardestCards = new ArrayList<>();
            for(Map.Entry<String, Integer> entry : mistakes.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    hardestCards.clear();
                    hardestCards.add(entry.getKey());
                } else if (entry.getValue() == max) {
                    hardestCards.add(entry.getKey());
                }
            }
            if (hardestCards.size() == 1) {
                outputln("The hardest card is \"" + hardestCards.get(0) + "\". " +
                        "You have " + max + " errors answering it.");
            } else {
                output("The hardest cards are ");
                for(int i = 0; i < hardestCards.size(); i++) {
                    if (i == hardestCards.size() - 1) {
                        output("\"" + hardestCards.get(i) + "\"");
                    } else {
                        output("\"" + hardestCards.get(i) + "\",");
                    }
                }
                outputln(". You have " + max + " errors answering them.");
            }
        }
    }

    public static void reset() {
        mistakes.clear();
        outputln("Card statistics has been reset.");
    }

    public static void saveLog() throws Exception{
        outputln("File name:");
        String path = inputString();
        File file = new File(path);
        try (PrintWriter writer = new PrintWriter(file)) {
            log.forEach(ele -> writer.println(ele));
        }
        outputln("The log has been saved.");
    }

    public static void importCards(String filename) throws Exception {
        File file = new File(filename);
        if (!file.exists()) {
            outputln("File not found.");
            return;
        }
        int count = 0;
        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNext()) {
                String card = fileReader.nextLine();
                String def = fileReader.nextLine();
                int mistake = Integer.parseInt(fileReader.nextLine());
                cards.put(card, def);
                if (mistake > 0) {
                    mistakes.put(card, mistake);
                }
                ++count;
            }
        } finally {
            outputln(count + " cards have been loaded.");
        }
    }

    public static void export(String fileName) throws Exception {
        File file = new File(fileName);
        try (PrintWriter writer = new PrintWriter(file)) {
            for(Map.Entry<String, String> entry : cards.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue();
                writer.println(k + "\n" + v);
                if (mistakes.containsKey(k)) {
                    writer.println(mistakes.get(k));
                } else {
                    writer.println(0);
                }
            }
        }
        outputln(cards.size() + " cards have been saved.");
    }
}