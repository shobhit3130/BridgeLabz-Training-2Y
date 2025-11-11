import java.util.ArrayList;
import java.util.Collections;

public class EmployeeAgeProcessor {
    public static void main(String[] args) {
        // Primitive array of employee ages
        int[] ageArray = {28, 45, 32, 22, 39};

        // Convert to ArrayList<Integer> using auto-boxing
        ArrayList<Integer> ageList = new ArrayList<>();
        for (int age : ageArray) {
            ageList.add(age); // auto-boxing
        }

        // Find youngest and oldest ages
        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);

        // Display results
        System.out.println("👶 Youngest Employee Age: " + youngest);
        System.out.println("🧓 Oldest Employee Age: " + oldest);
    }
}