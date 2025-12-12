import java.util.ArrayList;

public class StudentMarksReport {
    public static void main(String[] args) {
        // Mixed-format inputs
        Object[] rawInputs = { "85", 95, Integer.valueOf(88), "null", "abc", null };

        ArrayList<Integer> validMarks = new ArrayList<>();

        for (Object input : rawInputs) {
            if (input == null) continue;

            try {
                if (input instanceof String) {
                    String str = (String) input;
                    if (str.equalsIgnoreCase("null")) continue;
                    validMarks.add(Integer.parseInt(str));
                } else if (input instanceof Integer) {
                    validMarks.add((Integer) input);
                }
            } catch (NumberFormatException e) {
                // Skip invalid string like "abc"
            }
        }

        // Calculate average
        int total = 0;
        for (int mark : validMarks) {
            total += mark;
        }

        double average = validMarks.isEmpty() ? 0.0 : (double) total / validMarks.size();

        // Display results
        System.out.println("✅ Valid Marks: " + validMarks);
        System.out.println("📊 Average Mark: " + average);
    }
}
