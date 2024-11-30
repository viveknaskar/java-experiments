import java.util.Arrays;

public class FindingMaxInJava8 {

    public static void main(String[] args) {

        int arr[] = {61,54,23,5,23};

        /*
         * Using Traditional approach
         */

        int maxim = arr[0];
        int minim = arr[0];

        for (int i=1; i < arr.length; i++) {
            if (arr[i] > maxim) {
                maxim = arr[i];
            } else if (arr[i] < minim) {
                minim = arr[i];
            }
        }

        System.out.println("Maximum number (Without Stream) is " + maxim);
        System.out.println("Minimum number (Without Stream) is " + minim);

        /*
           Using Java 8 stream
         */

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println("Maximum number is " + max);
        System.out.println("Minimum number is " + min);

    }

}
