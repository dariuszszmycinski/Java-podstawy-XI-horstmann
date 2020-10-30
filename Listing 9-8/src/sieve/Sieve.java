package sieve;

import java.util.BitSet;

//program wykonujący test porównawczy na bazie algorytmu Eratostenesa, oblicza liczby pierwsze do 2000000
public class Sieve {
    public static void main(String[] s) {
        int n = 2000000;
        long start = System.currentTimeMillis();
        var bitSet = new BitSet(n + 1);
        int count = 0;
        int i;
        for (i = 2; i <= n; i++){
            bitSet.set(i);
        }
        i = 2;
        while (i * i <= n) {
            if (bitSet.get(i)) {
                count++;
                int k = 2 * i;
                while (k <= n) {
                    bitSet.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while (i <= n) {
            if (bitSet.get(i)) count++;
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(count + " liczb pierwszych");
        System.out.println((end - start) + " milisekund");
    }
}
