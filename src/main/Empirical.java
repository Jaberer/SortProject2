package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Joseph Zhong
 * Assignment 13
 * Empirical Testing of the different sort algorithms
 * Empirical.java
 * v3.5
 * 30 April 2014
 */

public class Empirical
{
    /**
     * Enumerated integer values that correspond to integer array index sizes
     * The SIZE names correspond to their values
     */
    private enum SIZE
    {
        ONE_THOUSAND(1000, 0), FIVE_THOUSAND(5000, 1), TEN_THOUSAND(10000, 2), TWENTY_THOUSAND(20000, 3),
            FIFTY_THOUSAND(50000, 4), HUNDRED_THOUSAND(100000, 5), FIVE_HUNDRED_THOUSAND(500000, 6),
            ONE_MILLION(1000000, 7),  FIVE_MILLION(5000000, 8), TEN_MILLION(10000000, 9),
            HUNDRED_MILLION(100000000, 10),
            SIZES(11, 11), ALGORITHMS(4, 4);
        private int value;
        private int sizeNumber;
        private SIZE(int _value, int _sizeNumber)
        {
            value = _value;
            sizeNumber = _sizeNumber;
        }
    };

    /**
     * Array of Strings to correspond indices to different names of sort algorithms.
     */
    private static final String[] ALGORITHMS = {"selectionSort", "insertionSort", "mergeSort", "Arrays.sort"};

    /**
     * Two dimensional array to record times for each algorithm for each array size
     * There are five integer array sizes with four different algorithms to test them with
     */
    private static long[][] times = new long[SIZE.SIZES.value][SIZE.ALGORITHMS.value];

    /**
     * Main method to begin conducting tests
     * @param args I never knew what this was...some arguments lol
     */
    public static void main(String[] args)
    {
        printData("Increasing");
        System.out.println();
        printData("Decreasing");
        System.out.println();
        printData("Random");
    }

    /**
     * Helper method that determines how to build the arrays.
     * The int[] are all stored in an ArrayList<int[]> that is
     *  modified by the preceeding methods.
     * @param order is a String called by the main method that
     *  determines which method is used to order the arrays
     * @return an ArrayList that is modified to contain integer
     *  arrays that are ordered based on the String called.
     */
    private static ArrayList<int[]> buildArrays(String order)
    {
        if(order.equals("Increasing"))
        {
            return makeIncreasing();
        }
        else if(order.equals("Decreasing"))
        {
            return makeDecreasing();
        }
        else
        {
            return makeRandom();
        }
    }

    /**
     * Helper Method.
     * This method produces an ArrayList of int[] arrays ordered in
     *  decreasing order starting from zero to its length.
     * @return an ArrayList of int[], each int[] ordered from its length - 1
     *  to zero
     */
    private static ArrayList<int[]> makeDecreasing()
    {
        ArrayList<int[]> intArrays = new ArrayList<int[]>();
        intArrays.add(new int[SIZE.ONE_THOUSAND.value]);
        intArrays.add(new int[SIZE.FIVE_THOUSAND.value]);
        intArrays.add(new int[SIZE.TEN_THOUSAND.value]);
        intArrays.add(new int[SIZE.TWENTY_THOUSAND.value]);
        intArrays.add(new int[SIZE.FIFTY_THOUSAND.value]);
        intArrays.add(new int[SIZE.HUNDRED_THOUSAND.value]);
        intArrays.add(new int[SIZE.FIVE_HUNDRED_THOUSAND.value]);
        intArrays.add(new int[SIZE.ONE_MILLION.value]);
        intArrays.add(new int[SIZE.TEN_MILLION.value]);
        intArrays.add(new int[SIZE.HUNDRED_MILLION.value]);

        for(int[] array : intArrays)
        {
            for(int i = 0; i < array.length; i++)
            {
                array[i] = array.length - i - 1;
            }
        }
        return intArrays;
    }

    /**
     * Helper Method.
     * This method produces an ArrayList of int[] arrays ordered in
     *  increasing order starting from zero.
     * @return an ArrayList of int[], each int[] ordered from zero to
     *  its maximum value.
     */
    private static ArrayList<int[]> makeIncreasing()
    {
        ArrayList<int[]> intArrays = new ArrayList<int[]>();
        intArrays.add(new int[SIZE.ONE_THOUSAND.value]);
        intArrays.add(new int[SIZE.FIVE_THOUSAND.value]);
        intArrays.add(new int[SIZE.TEN_THOUSAND.value]);
        intArrays.add(new int[SIZE.TWENTY_THOUSAND.value]);
        intArrays.add(new int[SIZE.FIFTY_THOUSAND.value]);
        intArrays.add(new int[SIZE.HUNDRED_THOUSAND.value]);
        intArrays.add(new int[SIZE.FIVE_HUNDRED_THOUSAND.value]);
        intArrays.add(new int[SIZE.ONE_MILLION.value]);
        intArrays.add(new int[SIZE.TEN_MILLION.value]);
        intArrays.add(new int[SIZE.HUNDRED_MILLION.value]);

        for(int[] array : intArrays)
        {
            for(int i = 0; i < array.length; i++)
            {
                array[i] = i;
            }
        }
        return intArrays;
    }

    /**
     * Helper Method.
     * This method produces an ArrayList of int[] arrays ordered in
     *  random order.
     * @return an ArrayList of int[], each int[] ordered randomly
     */
    private static ArrayList<int[]> makeRandom()
    {
        Random gen = new Random();

        ArrayList<int[]> intArrays = new ArrayList<int[]>();
        intArrays.add(new int[SIZE.ONE_THOUSAND.value]);
        intArrays.add(new int[SIZE.FIVE_THOUSAND.value]);
        intArrays.add(new int[SIZE.TEN_THOUSAND.value]);
        intArrays.add(new int[SIZE.TWENTY_THOUSAND.value]);
        intArrays.add(new int[SIZE.FIFTY_THOUSAND.value]);
        intArrays.add(new int[SIZE.HUNDRED_THOUSAND.value]);
        intArrays.add(new int[SIZE.FIVE_HUNDRED_THOUSAND.value]);
        intArrays.add(new int[SIZE.ONE_MILLION.value]);
        intArrays.add(new int[SIZE.TEN_MILLION.value]);
        intArrays.add(new int[SIZE.HUNDRED_MILLION.value]);

        for(int[] array : intArrays)
        {
            for(int i = 0; i < array.length; i++)
            {
                array[i] = gen.nextInt(array.length);
            }
        }
        return intArrays;
    }

    /**
     * Helper Method.
     * This method calls the method that sorts the integer
     *  arrays and records the time each sort took into the
     *  2D array times
     * @param order is the is a String called by the main
     *  method that  determines which method is used to order
     *  the arrays
     */
    private static void printData(String order)
    {
        doSorts(buildArrays(order));

        for(int i = -1; i < ALGORITHMS.length; i++)
        {
            if(i == -1)
            {
                System.out.printf("%15s\t%5d\t%5d\t%5d\t%5d\t%5d\t%5d\t%5d\t%5d\t%5d\t%5d\t%5d", order, SIZE.ONE_THOUSAND.value,
                        SIZE.FIVE_THOUSAND.value, SIZE.TEN_THOUSAND.value, SIZE.TWENTY_THOUSAND.value,
                        SIZE.FIFTY_THOUSAND.value, SIZE.HUNDRED_THOUSAND.value, SIZE.FIFTY_THOUSAND.value,
                        SIZE.HUNDRED_THOUSAND.value, SIZE.ONE_MILLION.value, SIZE.TEN_MILLION.value, SIZE.HUNDRED_MILLION.value);
                System.out.println();
            }
            else
            {
                System.out.printf("%15s\t%5d\t%5d\t%5d\t%5d\t%5d\t%5d\t%5d\t%5d\t%5d\t%5d\t%5d", ALGORITHMS[i], times[SIZE.ONE_THOUSAND.sizeNumber][i],
                        times[SIZE.FIVE_THOUSAND.sizeNumber][i], times[SIZE.TEN_THOUSAND.sizeNumber][i],
                        times[SIZE.TWENTY_THOUSAND.sizeNumber][i], times[SIZE.FIFTY_THOUSAND.sizeNumber][i],
                        times[SIZE.HUNDRED_THOUSAND.sizeNumber][i], times[SIZE.FIVE_HUNDRED_THOUSAND.sizeNumber][i],
                        times[SIZE.ONE_MILLION.sizeNumber][i], times[SIZE.TEN_MILLION.sizeNumber][i], times[SIZE.HUNDRED_MILLION.sizeNumber][i]);
                System.out.println();
            }
        }
    }

    /**
     * Sorting Method.
     * This method copies the int[] arrays (to preserve the original for future sorts)
     *  runs the available sort methods on the previously built
     *  int[] arrays, and records the time spent on each into times[][]
     * @param arrays is the ArrayList of int[] that was built to be sorted and tested
     */
    private static void doSorts(ArrayList<int[]> arrays)
    {
        int counter = 0;
        int sortMethod;
        for(sortMethod = 0; sortMethod < 4; sortMethod++)
        {
            for (int[] array : arrays)
            {
                int[] temp = new int[array.length];
                for(int i = 0; i < array.length; i++)
                {
                    temp[i] = array[i];
                }
                System.gc();
                long beginTime = 0;
                long endTime = 0;
                switch (sortMethod)
                {
                    case 0:
                        beginTime = System.currentTimeMillis();
                        Sorters.selectionSort(temp);
                        endTime = System.currentTimeMillis();
                        //System.out.println(Arrays.toString(temp));
                        break;
                    case 1:
                        beginTime = System.currentTimeMillis();
                        Sorters.insertionSort(temp);
                        endTime = System.currentTimeMillis();
                        //System.out.println(Arrays.toString(temp));
                        break;
                    case 2:
                        beginTime = System.currentTimeMillis();
                        Sorters.mergeSort(temp);
                        endTime = System.currentTimeMillis();
                        //System.out.println(Arrays.toString(temp));
                        break;
                    case 3:
                        beginTime = System.currentTimeMillis();
                        Arrays.sort(temp);
                        endTime = System.currentTimeMillis();
                        break;
                }

                long time = endTime - beginTime;
                times[counter][sortMethod] = time;
                counter++;
            }
            counter = 0;
        }
    }
}
