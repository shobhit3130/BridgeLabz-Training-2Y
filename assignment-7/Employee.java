// Employee.java
public

class Employee {
    // Non-static variables
    String name = "Rohan";
    int id = 1;
    double salary = 500000;

    // Method to display employee details
    public void displayEmployee() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    // Main method
    public static void main(String[] args) {
        Employee emp = new Employee(); // Creating object with default constructor
        emp.displayEmployee();         // Calling the display method
    }
}