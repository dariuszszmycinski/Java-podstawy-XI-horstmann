package set;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

//program drukujący wszystkie słowa ze strumienia wejściowego przy użyciu zbioru
public class SetTest {
    public static void main(String[] args) throws FileNotFoundException {
        var words = new HashSet<String>();
        long totalTime = 0;

        try (var in = new Scanner(new File("alice30.txt"))) {
            while (in.hasNext()) {
                String word = in.next();
                long calltime = System.currentTimeMillis();
                words.add(word);
                calltime = System.currentTimeMillis() - calltime;
                totalTime += calltime;
            }
        }

        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i++) {
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size() + " niepowtarzalnych słów. " + totalTime + " milisekund.");
    }
}
