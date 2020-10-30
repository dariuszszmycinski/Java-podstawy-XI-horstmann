package map;

import java.util.HashMap;

//program demonstrujący użycie słownika z kluczami typu String i wartościami typu Employee
public class MapTest {
    public static void main(String[] args) {
        var staff = new HashMap<String, Employee>();
        staff.put("144-25-5464", new Employee("Anna Kowalska"));
        staff.put("567-24-2546", new Employee("Henryk Kwiatek"));
        staff.put("157-62-7935", new Employee("Marcin Nowak"));
        staff.put("456-62-5527", new Employee("Franciszek Frankowski"));

        System.out.println(staff);

        staff.remove("567-24-2546");

        staff.put("456-62-5527", new Employee("Weronika Kowalska"));
        System.out.println(staff.get("157-62-7935"));
        staff.forEach((v, k) -> System.out.println("klucz= " + k + " wartość = " + v));
    }
}
