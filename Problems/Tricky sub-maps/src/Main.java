import java.util.*;

class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        // Write your code here
        int firstKey = map.firstKey();
        int lastKey = map.lastKey();
        NavigableMap<Integer, String> newMap = new TreeMap<>();
        if (firstKey % 2 != 0) {
            for(int key : map.keySet()) {
                newMap.put(key, map.get(key));
                if (key == firstKey + 4)
                    break;
            }
        } else {
            for(int key : map.descendingMap().keySet()) {
                newMap.put(key, map.get(key));
                if (key == lastKey - 4)
                    break;
            }
        }
        return newMap.descendingMap();
    }
}

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]), pair[1]);
        });

        Map<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}