// Interface: Department
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Abstract class: BaseEmployee (renamed to avoid duplicate "Employee")
abstract class BaseEmployee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public BaseEmployee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Encapsulation: Getters and Setters
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Department: " + department);
        System.out.println("Final Salary: " + calculateSalary());
    }

    // Interface methods
    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }
}

// Subclass: FullTimeEmployee
class FullTimeEmployee extends BaseEmployee {
    private double bonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

// Subclass: PartTimeEmployee
class PartTimeEmployee extends BaseEmployee {
    private int hoursWorked;
    private double ratePerHour;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double ratePerHour) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * ratePerHour);
    }
}

// ✅ Public class for main method
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        BaseEmployee e1 = new FullTimeEmployee(101, "Shobhit", 50000, 10000);
        BaseEmployee e2 = new PartTimeEmployee(102, "Harshit", 20000, 100, 100);

        e1.assignDepartment("Full-Time");
        e2.assignDepartment("Part-Time");

        System.out.println("Full-Time Employee:");
        e1.displayDetails();

        System.out.println("\nPart-Time Employee:");
        e2.displayDetails();
    }
}