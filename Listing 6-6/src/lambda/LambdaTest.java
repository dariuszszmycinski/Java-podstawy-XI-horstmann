package lambda;

import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

//demonstracja użycia wyrażeń lambda
public class LambdaTest {
    public static void main(String[] args) {
        var planets = new String[] {"Merkury", "Wenus", "Ziemia", "Mars", "Jowisz", "Saturn", "Uran", "Neptun", "Pluton"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sortowanie alfabetyczne:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sortowanie według długości:");
        Arrays.sort(planets, (first, second)->first.length()-second.length());
        System.out.println(Arrays.toString(planets));

        var timer = new Timer(1000, event -> System.out.println("Jest godzina "+new Date()));
        timer.start();

        JOptionPane.showMessageDialog(null,"Zamknąć program?");
        System.exit(0);
    }
}
