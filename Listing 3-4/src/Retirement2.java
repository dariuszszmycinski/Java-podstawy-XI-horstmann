import java.util.Scanner;

//demonstracja użycia pętli do/while
public class Retirement2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Ile pieniędzy rocznie będziesz wpłacać? ");
        double payment = in.nextDouble();
        System.out.print("Stop procentowa w %: ");
        double rate = in.nextDouble();
        double balance = 0;
        int year = 0;

        String input;
        do {
            balance += payment;
            double interest = balance * rate / 100;
            balance += interest;
            year++;
            System.out.printf("Po upływie %d lat stan twojego konta wyniesie %,.2f%n", year, balance);
            System.out.print("Chcesz przejść na emeryturę? (T/N) ");
            input = in.next();
        }while (input.equals("N"));
    }
}
