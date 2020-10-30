package linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

//demonstracja działania na listach powiązanych
public class LinkedListTest {
    public static void main(String[] args) {
        var a = new LinkedList<String>();
        a.add("Ania");
        a.add("Karol");
        a.add("Eryk");

        var b = new LinkedList<String>();
        b.add("Bartek");
        b.add("Daniel");
        b.add("Franek");
        b.add("Gosia");

        //Scalenie list a i b

        ListIterator<String> alter = a.listIterator();
        Iterator<String> blter = b.iterator();

        while (blter.hasNext()) {
            if (alter.hasNext()) alter.next();
            alter.add(blter.next());
        }

        System.out.println(a);

        //Usunięcie co drugiego słowa z listy b

        blter = b.iterator();
        while (blter.hasNext()) {
            blter.next();
            if (blter.hasNext()) {
                blter.next();
                blter.remove();
            }
        }

        System.out.println(b);

        //Usunięcie wszystkich słów znajdujących się w liście b z listy a
        a.removeAll(b);
        System.out.println(a);
    }
}
