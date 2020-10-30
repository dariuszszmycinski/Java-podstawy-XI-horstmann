package inheritance;

//demonstracja dziedziczenia
public class ManagerTest {
    public static void main(String[] args) {
        var boss = new Manager("Karol Parol", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        var staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("Henryk Kwiatek", 50000, 1989, 10, 1);
        staff[2] = new Employee("Artut Kwiatkowski", 40000, 1990, 3, 15);

        for (Employee e : staff) {
            System.out.println(e.getName() + " zarabia " + e.getSalary());
        }
    }
}
