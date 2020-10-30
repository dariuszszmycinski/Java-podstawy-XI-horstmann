import java.util.Scanner;

//demonstracja pobierania danych z konsoli
public class InputTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Jak się nazywasz? ");
        String name = in.nextLine();
        System.out.print("Ile masz lat ");
        int age = in.nextInt();
        System.out.println("Witaj użytkowniku " + name + ". W przyszłym roku będziesz mieć " + (age + 1) + " lat.");
    }
}
