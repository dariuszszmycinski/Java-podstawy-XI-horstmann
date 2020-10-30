//demonstracja metod statycznych
public class StaticTest {
    public static void main(String[] args) {
        var staff = new Employee[3];
        staff[0] = new Employee("Tomasz", 40000);
        staff[1] = new Employee("Dariusz", 60000);
        staff[2] = new Employee("Grzegorz", 65000);

        for (Employee e:staff             ) {
            e.setId();
            System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary());
        }
        int n = Employee.getNextId();
        System.out.println("Następny dostępny identyfikator = "+n);
    }
}

class Employee{
    private static int nextId = 1;
    private String name;
    private double salary;
    private int id;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.id = 0;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = nextId;
        nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void main(String[] args) {
        var e = new Employee("Grzegorz", 50000);
        System.out.println(e.getName()+" "+e.getSalary());
    }
}
