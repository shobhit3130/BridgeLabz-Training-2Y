public class WrapperComparisonDemo {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;

        System.out.println("a == b: " + (a == b));         // true
        System.out.println("c == d: " + (c == d));         // false
        System.out.println("a.equals(b): " + a.equals(b)); // true
    }
}