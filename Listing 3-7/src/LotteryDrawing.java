import java.util.Arrays;
import java.util.Scanner;

//demonstracja zastosowań tablic
public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Ile liczb musisz wylosować? ");
        int k = in.nextInt();
        System.out.print("Jaka jest największa liczba? ");
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            int r = (int) (Math.random() * n);
            result[i] = numbers[r];
            numbers[r] = numbers[n - 1];
            n--;
        }
        Arrays.sort(result);
        System.out.println("Wylosowano liczby:");
        for (int r : result) {
            System.out.println(r);
        }
    }
}
