import java.util.*;

public class UniversityApp {

    // Faculty class (can exist independently of any department)
    static class Faculty {
        private String name;
        private String specialization;

        public Faculty(String name, String specialization) {
            this.name = name;
            this.specialization = specialization;
        }

        public void display() {
            System.out.println("Faculty: " + name + " | Specialization: " + specialization);
        }
    }

    // Department class (exists only within a University)
    static class Department {
        private String name;
        private List<Faculty> facultyMembers;

        public Department(String name) {
            this.name = name;
            this.facultyMembers = new ArrayList<>();
        }

        public void addFaculty(Faculty faculty) {
            facultyMembers.add(faculty); // Aggregation: faculty is shared, not owned
        }

        public void display() {
            System.out.println("  Department: " + name);
            for (Faculty f : facultyMembers) {
                System.out.print("    - ");
                f.display();
            }
        }
    }

    // University class (composes Departments)
    static class University {
        private String name;
        private List<Department> departments;

        public University(String name) {
            this.name = name;
            this.departments = new ArrayList<>();
        }

        public void addDepartment(Department dept) {
            departments.add(dept);
        }

        public void displayStructure() {
            System.out.println("University: " + name);
            for (Department dept : departments) {
                dept.display();
            }
        }

        public void dissolve() {
            System.out.println("Dissolving university: " + name);
            departments.clear(); // Composition: departments are removed with university
        }
    }

    // Main method to demonstrate composition and aggregation
    public static void main(String[] args) {
        // Independent faculty members
        Faculty profA = new Faculty("Dr. A", "Physics");
        Faculty profB = new Faculty("Dr. B", "Mathematics");
        Faculty profC = new Faculty("Dr. C", "Literature");

        // University and departments
        University uni = new University("Global University");

        Department scienceDept = new Department("Science");
        scienceDept.addFaculty(profA);
        scienceDept.addFaculty(profB);

        Department artsDept = new Department("Arts");
        artsDept.addFaculty(profC);

        uni.addDepartment(scienceDept);
        uni.addDepartment(artsDept);

        // Display full structure
        uni.displayStructure();

        // Show faculty existing independently
        System.out.println("\nIndependent Faculty:");
        profA.display();
        profB.display();
        profC.display();

        // Dissolve university
        System.out.println("\nAfter dissolving university:");
        uni.dissolve();
        uni.displayStructure(); // Should show nothing
    }
}