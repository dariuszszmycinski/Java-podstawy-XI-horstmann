package interfaces;

import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args) {
        var staff = new Employee[3];
        staff[0] = new Employee("Henryk Kwiatek",35000);
        staff[1] = new Employee("Karol Kowalski", 75000);
        staff[2] = new Employee("Tadeusz Nowak",38000);

        Arrays.sort(staff);

        for (Employee e:staff){
            e.raiseSalary(5);
            System.out.println(e);
        }
    }
}
