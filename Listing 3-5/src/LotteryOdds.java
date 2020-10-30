import java.util.Scanner;

//demonstracja zastosowania pętli for
public class LotteryOdds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Ile liczb ma być wylosowanych? ");
        int k = in.nextInt();
        System.out.print("Jaka jest górna granica przedziału losowanych liczb? ");
        int n = in.nextInt();

        int lotteryOdds = 1;
        for (int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds * (n - i + 1) / i;
        }
        System.out.println("Twoje szanse to 1 do " + lotteryOdds + ". Powodzenia!");
    }
}
