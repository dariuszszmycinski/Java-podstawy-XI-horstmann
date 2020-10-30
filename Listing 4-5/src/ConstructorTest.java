import java.util.Random;

//techniki konstrukcji obiektów
public class ConstructorTest {
    public static void main(String[] args) {
        var staff = new Employee[3];
        staff[0] = new Employee("Hubert", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        for (Employee e:staff){
            System.out.println("name= " +e.getName()+" id="+e.getId()+" salary = "+e.getSalary());
        }
    }
}

class Employee{
    private static int nextId;

    private int id;
    private String name = "";
    private double salary;

    //Statyczny blok inicjujący
    static{
        var generator = new Random();
        nextId = generator.nextInt(10000);
    }
    //blok inicjujący obiektów
    {
        id = nextId;
        nextId++;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}