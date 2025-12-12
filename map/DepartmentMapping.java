package map;

import java.util.*;

public class DepartmentMapping {
    public static void main(String[] args) {
        // Step 1: Add employees with departments
        HashMap<Integer, String> empDept = new HashMap<>();
        empDept.put(101, "HR");
        empDept.put(102, "Finance");
        empDept.put(103, "IT");
        empDept.put(104, "Marketing");
        empDept.put(105, "IT");
        empDept.put(106, "Finance");
        empDept.put(107, "HR");

        // Step 2: Change department of an employee
        empDept.put(104, "Sales"); // Marketing → Sales

        // Step 3: Find all employees in a given department
        String targetDept = "IT";
        System.out.println("Employees in " + targetDept + " department:");
        for (Map.Entry<Integer, String> entry : empDept.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(targetDept)) {
                System.out.println("Employee ID: " + entry.getKey());
            }
        }

        // Step 4: Count employees per department
        HashMap<String, Integer> deptCount = new HashMap<>();
        for (String dept : empDept.values()) {
            deptCount.put(dept, deptCount.getOrDefault(dept, 0) + 1);
        }

        System.out.println("\nTotal employees per department:");
        for (Map.Entry<String, Integer> entry : deptCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
