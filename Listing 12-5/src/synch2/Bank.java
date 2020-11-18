package synch2;

import java.util.Arrays;

//klasa z kilkoma kontami wykorzystująca synchronizację
public class Bank {
    private final double[] accounts;

    //tworzy bank
    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    //przelewa pieniądze pomiędzy kontami
    public synchronized void transfer(int from, int to, double amount) throws InterruptedException{
        while (accounts[from] < amount)
            wait();
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f z %d na %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Saldo ogólne %10.2f%n", getTotalBalance());
        notifyAll();
    }

    //zwraca sumę sald wszystkich kont
    public synchronized double getTotalBalance(){
        double sum = 0;
        for (double a:accounts)
            sum += a;
        return sum;
    }

    //zwraca liczbę kont w banku
    public int size(){
        return accounts.length;
    }
}
