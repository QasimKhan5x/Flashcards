import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // start coding here
            int count = 0;
            int ch = reader.read();
            boolean readingWord = true;
            while (ch != -1) {
                if ((char) ch != ' ' && readingWord) {
                    ++count;
                    readingWord = false;
                }
                if ((char) ch == ' ') {
                    readingWord = true;
                }
                ch = reader.read();
            }
            System.out.println(count);
        }
    }

}