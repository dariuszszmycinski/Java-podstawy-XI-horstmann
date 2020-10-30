import java.util.Arrays;

//przechowywanie danych w tablicy dwuwymiarowej
public class CompoundInterest {
    public static void main(String[] args) {
        final double START_RATE = 10;
        final int N_RATES = 6;
        final int N_YEARS = 10;
        double[] interestRate = new double[N_RATES]; //oprocentowanie
        for (int i = 0; i < interestRate.length; i++) {
            interestRate[i] = (START_RATE + i) / 100.0;
        }
        double[][] balances = new double[N_YEARS][N_RATES];
        //saldo początkowe
        Arrays.fill(balances[0], 10000);
        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length; j++) {
                double oldBalance = balances[i - 1][j];
                double inerest = oldBalance * interestRate[j];
                balances[i][j] = oldBalance + inerest;
            }
        }
        for (double v : interestRate) {
            System.out.printf("%9.0f%%", 100 * v);
        }
        System.out.println();
        for (double[] row : balances) {
            for (double b : row) {
                System.out.printf("%10.2f", b);
            }
            System.out.println();
        }
    }
}
