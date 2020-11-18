package synch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//bank z kilkoma kontami kontrolujący dostęp za pomocą blokad
public class Bank {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    //tworzy bank
    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    //przelewa pieniądze pomiędzy kontami
    public void transfer(int from, int to, double amount) throws InterruptedException{
        bankLock.lock();
        try {
            while (accounts[from] < amount)
                sufficientFunds.await();
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f z %d na %d", amount, from, to);
            accounts[to] +=amount;
            System.out.printf(" Saldo ogólne: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        }finally {
            bankLock.unlock();
        }
    }

    //zwraca sumę sald wszystkich kont
    public  double getTotalBalance(){
        bankLock.lock();
        try {
            double sum = 0;
            for (double a:accounts)
                sum +=a;
            return sum;
        }finally {
            bankLock.unlock();
        }
    }

    //zwraca liczbę kont w banku
    public  int size(){
        return accounts.length;
    }
}
