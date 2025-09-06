import java.util.Scanner;

public class CalendarDisplay {

    // 🔹 Month names
    static String[] monthNames = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    // 🔹 Days in each month
    static int[] monthDays = {
        31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };

    // 🔹 Check for leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // 🔹 Get number of days in a month
    public static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return monthDays[month - 1];
    }

    // 🔹 Get first day of the month using Gregorian calendar algorithm
    public static int getFirstDay(int month, int year) {
        int d = 1; // First day of the month
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0; // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
    }

    // 🔹 Display calendar
    public static void displayCalendar(int month, int year) {
        String monthName = monthNames[month - 1];
        int days = getDaysInMonth(month, year);
        int startDay = getFirstDay(month, year);

        // Header
        System.out.printf("\n     %s %d\n", monthName, year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // First loop: spacing before first day
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Second loop: print days
        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);
            if ((day + startDay) % 7 == 0) {
                System.out.println(); // New line after Saturday
            }
        }

        System.out.println(); // Final line break
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Take input
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        // 🔹 Display calendar
        displayCalendar(month, year);

        scanner.close();
    }
}