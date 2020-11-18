package unsynch;

import java.util.Arrays;

//bank z pewną ilością kont
public class Bank {
    private final double[] accounts;

    //tworzy bank z n liczbą kont z początkowym saldem każdego
    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    //przelewa pieniądze z jednego konta na drugie
    public void transfer(int from, int to, double amount){
        if (accounts[from]<amount)return;
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f z %d na %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Saldo całkowite: %10.2f%n", getTotalBalance());
    }

    //oblicza sumę wszystkich sald kont
    public double getTotalBalance(){
        double sum = 0;
        for (double a: accounts){
            sum += a;
        }
        return sum;
    }

    //sprawdza liczbę kont w banku
    public int size(){
        return accounts.length;
    }
}
