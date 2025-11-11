public class WrapperUtilityDemo {
    public static void main(String[] args) {
        // 1. Integer.parseInt("123")
        int parsedInt = Integer.parseInt("123");
        System.out.println("Parsed int: " + parsedInt);

        // 2. Double.parseDouble("3.14")
        double parsedDouble = Double.parseDouble("3.14");
        System.out.println("Parsed double: " + parsedDouble);

        // 3. Boolean.parseBoolean("true")
        boolean parsedBoolean = Boolean.parseBoolean("true");
        System.out.println("Parsed boolean: " + parsedBoolean);

        // 4. Integer.toBinaryString(10)
        String binaryString = Integer.toBinaryString(10);
        System.out.println("Binary of 10: " + binaryString);

        // 5. Character.isDigit('5')
        boolean isDigit = Character.isDigit('5');
        System.out.println("Is '5' a digit? " + isDigit);

        // 6. Character.toUpperCase('a')
        char upperChar = Character.toUpperCase('a');
        System.out.println("Uppercase of 'a': " + upperChar);
    }
}