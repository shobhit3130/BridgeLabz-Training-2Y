public class LoginValidator {
    // Method to validate age input
    public static boolean isValidAge(String ageInput) {
        try {
            int age = Integer.parseInt(ageInput);
            return age >= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testInputs = { "21", "abc", "17", "18", "45.5", "0" };

        System.out.println("🔍 Age Validation Results:");
        for (String input : testInputs) {
            boolean result = isValidAge(input);
            System.out.println("Input: \"" + input + "\" → Valid: " + result);
        }
    }
}
