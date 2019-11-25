import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assignment5 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner ( new File ( "Assignment5.rtf" ) );
        PrintWriter pw = new PrintWriter ( "Assignment5.rtf" );
        int n, lo, count1 = 0, count2 = 0, count3 = 0;
        int[] score1 = new int[5];
        int[] score2 = new int[5];
        int[] sumarr = new int[5];
        n = sc.nextInt ();
        pw.println ( "There are   " + n + " Values in each array." );
        readData ( n, score1, score2, sc );
        pw.print ( "The score1 array: " );
        printArray ( score1, n, pw);
        pw.print ( "The score2 array:  " );
        printArray ( score2, n, pw);
        lo = smallest(score1,n);
        pw.println ( "The smallest value in score1 is  " + lo );
        lo = smallest ( score2, n );
        pw.println ( "The smallest value in score2 is " + lo );
        construct ( score1, score2, sumarr, n );
        pw.print ( "The sumarr Arrey: " );
        printArray ( sumarr, n, pw );
        lo = smallest ( sumarr, n );
        pw.println ( "The smallest value in sumarr is  " + lo );
        whatsHigher ( score1, score2, n, count1, count2, count3, pw );
        pw.close ();
        sc.close ();
    }

    public static void readData(int n, int[] score1, int[] score2, Scanner sc) throws IOException {
        for (int i = 0; i < n; i++)
            score1[i] = sc.nextInt ();
        for (int i = 0; i < n; i++)
            score2[i] = sc.nextInt ();
        return;
    }

    private static void printArray(int[] lim, int vals, PrintWriter pw) {
        pw.print ( "[" );
        for (int i = 0; i < vals; i++) {
            pw.print ( lim[i] + " " );
        }
        pw.println ( "]" );
        return;
    }

    public static int smallest(int[] arr, int num) {
        int lo = arr[0];
        for (int i = 1; i < num; i++)
            if (arr[i] < lo)
                lo = arr[i];
        return lo;
    }


    public static int[] construct(int[] old1, int[] old2, int[] sumarr, int k) {
        for (int i = 0; i < k; i++) {
            sumarr[i] = old1[i] + old2[i];
        }
        return sumarr;
    }

    public static void whatsHigher(int[] score1, int[] score2, int n, int count1, int count2, int count3, PrintWriter pw) {
        for (int i = 0; i < n; i++) {
            if (score1[i] > score2[i]) {
                pw.println ( "in position " + i + "the higher value is in array score1: " + score1[i] + "is higher than" + score2[i] );
                count1++;
            }
            if (score1[i] < score2[i]) {
                pw.println ( "in position " + i + " the higher value is in array score2: " + score2[i] + "is higher the " + score1[i] );
                count2++;
            }
            if (score1[i] == score2[i]) {
                pw.println ( "In position " + i + ", the value is the same in both array:" + score1[i] );
                count3++;
            }
        }

        pw.println ( "Arrey Score1 was longer " + count1 + " time(s)." );
        pw.println ( "Array score2 was larger " + count2 + " time(s)." );
        pw.println ( "Array score1 was equal to array score2" + count3 + " time(s)." );
    }
}

