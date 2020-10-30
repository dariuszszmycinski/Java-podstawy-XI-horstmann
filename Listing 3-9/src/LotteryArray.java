//sposób tworzenia tablicy trójkątnej
public class LotteryArray {
    public static void main(String[] args) {
        final int N_MAX = 10;
        int[][] odds = new int[N_MAX][];
        for (int i = 0; i < N_MAX; i++) {
            odds[i] = new int[i + 1];
        }
        for (int i = 0; i < odds.length; i++) {
            for (int j = 0; j < odds[i].length; j++) {
                int lotteryOdds = 1;
                for (int k = 1; k <= j; k++) {
                    lotteryOdds = lotteryOdds * (i - k + 1) / k;
                    odds[i][j] = lotteryOdds;
                }
            }
        }
        for (int[] row : odds) {
            for (int odd : row) {
                System.out.printf("%4d", odd);
            }
            System.out.println();
        }
    }
}
