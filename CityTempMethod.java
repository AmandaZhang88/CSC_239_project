package CityAverageTemp;

import java.util.Scanner;
import java.text.DecimalFormat;

public class CityTempMethod {

    Scanner input = new Scanner(System.in);// Global scanner

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2); // for format the decimal place

        int[][] cityTemp = getArray(); // fill up the array
        printArray(cityTemp); // print out array

        // take out and reset each col and save it to array data
        for (int col = 0; col < cityTemp[0].length; col++) {
            int[] data = new int[cityTemp.length]; // Size of data[] = 3.
            for (int row = 0; row < cityTemp.length; row++) {
                data[row] = cityTemp[row][col];
            }
            int max_temp = max_arr(data); // get the max of each clo with max_arr() method
            int min_temp = min_arr(data); // get the min of each clo with min arr() function
            double avg_temp = avg_arr(data); // get the average of each clo with avg_arr() function

            int max_id = max_id(data); // get the id of the city which has the max temp
            int min_id = min_id(data); // get the id of the city which has the min temp

            // format print max,min,avg of 31 days.
            System.out.print("Day  " + (col + 1) + ": ");
            System.out.print("Max temp " + max_temp + " degrees (city" + (max_id + 1) + "), ");
            System.out.print("Min temp " + min_temp + " degrees (city" + (min_id + 1) + "), ");
            System.out.println("average temp " + df.format(avg_temp) + " degrees");
        }
        // find max, min avg for each city
        int bos_max = max_arr(cityTemp[0]);
        int bos_min = min_arr(cityTemp[0]);
        double bos_avg = avg_arr(cityTemp[0]);

        int orly_max = max_arr(cityTemp[1]);
        int orly_min = min_arr(cityTemp[1]);
        double orly_avg = avg_arr(cityTemp[1]);

        int paris_max = max_arr(cityTemp[2]);
        int paris_min = min_arr(cityTemp[2]);
        double paris_avg = avg_arr(cityTemp[2]);

        // find which day of max, min temp for each city
        int bos_max_id = max_id(cityTemp[0]); // get the day of  max temp' city
        int bos_min_id = min_id(cityTemp[0]); //get the day for min temp' city

        int orly_max_id = max_id(cityTemp[1]); // get address for max temp' city
        int orly_min_id = min_id(cityTemp[1]);

        int paris_max_id = max_id(cityTemp[2]); // get address for max temp' city
        int paris_min_id = min_id(cityTemp[2]);

        // find how many days had temps above and below the average temp for paris
        int aboveb = 0;  // initial conut for how many days above the avg temp
        int belowb = 0;  // initial conut for how many days below the avg temp
        for (int i = 0; i < cityTemp[0].length; i++) {
            if (cityTemp[0][i] > bos_avg) {
                aboveb++;
            }
            if (cityTemp[0][i] < bos_avg) {
                belowb++;
            }
        }

        // find how many days had temps above and below the average temp for orly
        int aboveo = 0;
        int belowo = 0;
        for (int i = 0; i < cityTemp[0].length; i++) {
            if (cityTemp[1][i] > orly_avg) {
                aboveo++;
            }
            if (cityTemp[1][i] < orly_avg) {
                belowo++;
            }
        }

        // find how many days had temps above and below the average temp for paris
        int abovep = 0;
        int belowp = 0;
        for (int i = 0; i < cityTemp[0].length; i++) {
            if (cityTemp[2][i] > paris_avg) {
                abovep++;
            }
            if (cityTemp[2][i] < paris_avg) {
                belowp++;
            }
        }

        // print result of max, min and avg, also math the days of 3 cities.
        System.out.println("-----------------------------------------------");
        System.out.println("Max temp of Boston = " + bos_max + ", Which was in day " + (bos_max_id + 1));
        System.out.println("Min temp of Boston = " + bos_min + ", Which was in day " + (bos_min_id + 1));
        System.out.println("Avg temp of Boston = " + df.format(bos_avg) + ". ");
        System.out.println("There were " + aboveb + " days had temp above average tmep and "
                + belowb + " days had temp below average temp in Boston.");

        System.out.println("-----------------------------------------------");
        System.out.println("Max temp of Orly = " + orly_max + ", Which was in day " + (orly_max_id + 1));
        System.out.println("Min temp of Orly = " + orly_min + ", Which was in day " + (orly_min_id + 1));
        System.out.println("Avg temp of Orly = " + df.format(orly_avg) + ", ");
        System.out.println("There were " + aboveo + " days had temp above average tmep and "
                + belowo + " days had temp below average temp in Orly.");

        System.out.println("-----------------------------------------------");
        System.out.println("Max temp of Paris = " + paris_max + ", Which was in day " + (paris_max_id + 1));
        System.out.println("Min temp of Paris = " + paris_min + ", which was in day " + (paris_min_id + 1));
        System.out.println("Avg temp of Paris = " + df.format(paris_avg) + ", ");
        System.out.println("There were " + abovep + " days had temp above average tmep and "
                + belowp + " days had temp below average temp in Paris.");
    }

    // initiate the array for 3 cities has 31 day's temp data
    public static int[][] getArray() {    // fillCityTemp
        System.out.println("Please enter your three city's tempreture:");
        int[][] cityTemp = new int[3][31];
        Scanner input = new Scanner(System.in);
        for (int row = 0; row < cityTemp.length; row++) {
            for (int cloumn = 0; cloumn < cityTemp[0].length; cloumn++) {
                cityTemp[row][cloumn] = input.nextInt();
            }
        }
        return cityTemp;
    }

    // print the raw data of each city's temp
    public static void printArray(int[][] cityTemp) {   //printCityTemp
        System.out.println("Print the array.");
        for (int row = 0; row < cityTemp.length; row++) {
            System.out.print("City " + (row + 1) + ": ");
            for (int cloumn = 0; cloumn < cityTemp[0].length; cloumn++) {
                System.out.print(cityTemp[row][cloumn] + " ");
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

    // find the max value in an 1D array
    public static int max_arr(int[] a) {
        int res = a[0];
        for (int i = 1; i < a.length; i++) {
            if (res < a[i]) {
                res = a[i];
            }
        }
        return res;
    }

    // find the min value in an 1D array
    public static int min_arr(int[] a) {
        int res = a[0];
        for (int i = 1; i < a.length; i++) {
            if (res > a[i]) {
                res = a[i];
            }
        }
        return res;
    }

    // find the average value in an 1D array
    public static double avg_arr(int[] a) {
        double total = 0;
        double res = 0;
        for (int i = 0; i < a.length; i++) {
            total += a[i];
        }
        res = total / a.length;
        return res;
    }

    // return the position of the maximum value
    public static int max_id(int[] a) {
        double res = a[0];
        int id = 0;
        for (int i = 1; i < a.length; i++) {
            if (res < a[i]) {
                res = a[i];
                id = i;
            }
        }
        return id;
    }

    // return the position of the minimum value
    public static int min_id(int[] a) {
        double res = a[0];
        int id = 0;
        for (int i = 1; i < a.length; i++) {
            if (res > a[i]) {
                res = a[i];
                id = i;
            }
        }
        return id;
    }
}
/* logical 
 * function fillCityTemp 
 * print array data    printArray( )
 * find max of each col (day)   //  max_arr(int[] a)
 * find min of each col (day)   //  min_arr(int[] a)
 * find average of each column (day)  // avg_arr(int[] a)
 * Find max address for every day    // ax_id(int[] a)
 * Find min address for every day    //  min_id(int[] a)
 * 
 * find max of each row (City)  // max_arr(int[] a)
 * find min of each row (City)  // min_arr(int[] a)
 * find average of each row (City)   //avg_arr(int[] a)
 * find how many days taht tmep above the avg and temp below avg for each city // for loop
 * Find max address of each city   // ax_id(int[] a)
 * Find min address of each city   //  min_id(int[] a)
 * print result
 */
