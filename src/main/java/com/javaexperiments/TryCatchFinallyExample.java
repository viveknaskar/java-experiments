import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception handling is the process of responding to the occurrence, during computation, of exceptions
 * anomalous or exceptional conditions requiring special processing often changing the normal flow of program execution.
 * */
public class TryCatchFinallyExample {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(x/y);
        }
        catch (ArithmeticException ae) {
            System.out.println(ae);
        }
        catch (InputMismatchException e) {
            System.out.println(e);
        }
        finally {
            System.out.println("Exception Handling is the best mechanism of handling errors.");
        }
    }
}
