package pair1;

public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"Ala","ma","kota","i","psa"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = "+ mm.getFirst());
        System.out.println("max = "+ mm.getSecond());
    }
}

class ArrayAlg{
    public static Pair<String> minmax(String[] a){
        if (a == null || a.length==0)return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i <a.length ; i++) {
            if (min.length()>a[i].length()) min = a[i];
            if (max.length()<a[i].length()) max = a[i];
        }
        return new Pair<>(min,max);
    }
}