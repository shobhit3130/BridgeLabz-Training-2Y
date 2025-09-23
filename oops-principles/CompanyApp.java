import java.util.*;

public class CompanyApp {

    // Employee class (exists only within a Department)
    static class Employee {
        private String name;
        private String role;

        public Employee(String name, String role) {
            this.name = name;
            this.role = role;
        }

        public void display() {
            System.out.println("    Employee: " + name + " | Role: " + role);
        }
    }

    // Department class (exists only within a Company)
    static class Department {
        private String name;
        private List<Employee> employees;

        public Department(String name) {
            this.name = name;
            this.employees = new ArrayList<>();
        }

        public void addEmployee(String name, String role) {
            employees.add(new Employee(name, role));
        }

        public void display() {
            System.out.println("  Department: " + name);
            for (Employee emp : employees) {
                emp.display();
            }
        }
    }

    // Company class (composes Departments and Employees)
    static class Company {
        private String name;
        private List<Department> departments;

        public Company(String name) {
            this.name = name;
            this.departments = new ArrayList<>();
        }

        public void addDepartment(Department dept) {
            departments.add(dept);
        }

        public void displayStructure() {
            System.out.println("Company: " + name);
            for (Department dept : departments) {
                dept.display();
            }
        }

        public void dissolve() {
            System.out.println("Dissolving company: " + name);
            departments.clear(); // removes all departments and their employees
        }
    }

    // Main method to demonstrate composition
    public static void main(String[] args) {
        Company techCorp = new Company("TechCorp");

        Department devDept = new Department("Development");
        devDept.addEmployee("Alice", "Developer");
        devDept.addEmployee("Bob", "Tester");

        Department hrDept = new Department("Human Resources");
        hrDept.addEmployee("Carol", "HR Manager");

        techCorp.addDepartment(devDept);
        techCorp.addDepartment(hrDept);

        techCorp.displayStructure();

        // Simulate deletion of company
        techCorp.dissolve();
        System.out.println("\nAfter dissolution:");
        techCorp.displayStructure(); // should show nothing
    }
}