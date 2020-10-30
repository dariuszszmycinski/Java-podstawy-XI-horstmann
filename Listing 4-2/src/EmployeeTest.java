import java.time.LocalDate;

//sprawdzenie działania klasy Employee
public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Robert Siwiak", 75000, 1987, 12, 15);
        staff[1] = new Employee("Jacek Cydejko", 50000, 1989, 10, 1);
        staff[2] = new Employee("Mariusz Romańczuk", 40000, 1990, 3, 15);

        for (Employee e : staff) {
            e.raiseSalary(5);
        }
        for (Employee e : staff) {
            System.out.println("Pracownik: " + e.getName() + " zarabia " + e.getSalary() + " i pracuje od " + e.getHireDay());
        }
    }
}

class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
