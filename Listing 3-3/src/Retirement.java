import java.util.Scanner;

//demonstracja użycia pętli while
public class Retirement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Ile pieniędzy potrzebujesz, aby przejść na emeryturę? ");
        double goal = in.nextDouble();

        System.out.print("Ile pieniędzy rocznie będziesz wpłacać? ");
        double payment = in.nextDouble();

        System.out.print("Stopa procentowa w %: ");
        double rate = in.nextDouble();

        double balance = 0;
        int years = 0;

        while (balance < goal) {
            balance += payment;
            double interest = balance * rate / 100;
            balance += interest;
            years++;
        }

        System.out.println("Możesz przejść na emeryturę za "+years+" lat.");
    }
}
