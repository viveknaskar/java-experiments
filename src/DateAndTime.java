import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * A program to determine the day of the week for a given date.
 * The user inputs a date in the format of month, day, and year.
 * The program then calculates and displays the day of the week.
 */
class DateAndTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the month, day, and year (separated by spaces):");

        String month = in.next();
        String day = in.next();
        String year = in.next();

        /**
         * Parse the input strings into integers and create a LocalDate object.
         * LocalDate.of throws DateTimeException if the input date is invalid.
         */
        LocalDate localDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        System.out.println("The day of the week is: " + dayOfWeek);
    }
}