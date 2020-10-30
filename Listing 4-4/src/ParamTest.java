//przekaywanie parametrów
public class ParamTest {
    public static void main(String[] args) {
        //test1 metody nie mogą modyfikować parametrów liczbowych
        System.out.println("Testowanie tripleValue:");
        double percent = 10;
        System.out.println("Przed: percent= "+percent);
        tripleValue(percent);
        System.out.println("Po: percent= "+percent);

        //test2 metody mogą zmieniać stan parametrów będących obiektami
        System.out.println("\nTestowanie tripleSalary");
        var harry = new Employee("Grzegorz", 50000);
        System.out.println("Przed: salary =" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("Po: salary =" + harry.getSalary());

        //test3 metody nie mogą dodawać nowych obiektór do parametrów obiektowych
        System.out.println("\nTestowanie swap:");
        var a = new Employee("Alicja", 70000);
        var b = new Employee("Grzegorz", 60000);
        System.out.println("Przed: a="+a.getName());
        System.out.println("Przed: b="+b.getName());
        swap(a, b);
        System.out.println("Po: a="+a.getName());
        System.out.println("Po: b="+b.getName());
    }

    public static void tripleValue(double x){
        x = 3*x;
        System.out.println("Koniec metody: x="+x);
    }

    public static void tripleSalary(Employee x){
        x.raiseSalary(200);
        System.out.println("Koniec metody: salary="+x.getSalary());
    }

    public static void swap(Employee x, Employee y){
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("Koniec metody: x="+x.getName());
        System.out.println("Koniec metody: y="+y.getName());
    }
}

class Employee{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}