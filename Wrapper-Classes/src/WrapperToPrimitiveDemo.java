public class WrapperToPrimitiveDemo {
    public static void main(String[] args) {
        // Wrapper object
        Double wrapperValue = Double.valueOf(45.67);

        // Convert to primitive types
        double primitiveDouble = wrapperValue.doubleValue(); // unboxing
        int primitiveInt = (int) primitiveDouble;            // casting

        // Display all values
        System.out.println("📦 Wrapper Double object: " + wrapperValue);
        System.out.println("🔢 Primitive double: " + primitiveDouble);
        System.out.println("🔢 Primitive int (casted): " + primitiveInt);
    }
}