package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;

/**
 * Joseph Zhong
 * Assignment 13
 * Empirical Testing of the different sort algorithms
 * Empirical.java
 * v1.1
 * 30 April 2014
 */

public class Empiricalv1
{
    /**
     * Final integer value that corresponds to an array size
     * @ONE_THOUSAND is one thousand indices large
     */
    private static final int ONE_THOUSAND = 1000;

    /**
     * Final integer value that corresponds to an array size
     * @FIVE_THOUSAND is five thousand indices large
     */
    private static final int FIVE_THOUSAND = 5000;

    /**
     * Final integer value that corresponds to an array size
     * @TEN_THOUSAND is ten thousand indices large
     */
    private static final int TEN_THOUSAND = 10000;

    /**
     * Final integer value that corresponds to an array size
     * @TWENTY_THOUSAND is twenty thousand indices large
     */
    private static final int TWENTY_THOUSAND = 20000;

    /**
     * Final integer value that corresponds to an array size
     * @FIFTY_THOUSAND is fifty thousand indices large
     */
    private static final int FIFTY_THOUSAND = 50000;

    /**
     * Enumerated objects containing the integer arrays to be sorted.
     * @array is an integer array that becomes filled and sorted later.
     * @arrayNumber is an integer resembling an index that can be used to call the enumerated objects.
     */
    private static enum IntArrays
    {
        ONEK(ONE_THOUSAND), FIVEK(FIVE_THOUSAND), TENK(TEN_THOUSAND), TWENTYK(TWENTY_THOUSAND),
            FIFTYK(FIFTY_THOUSAND);
        private int[] array;
        private int arrayNumber;

        private IntArrays(int a)
        {
            switch(a)
            {
                case ONE_THOUSAND:
                    arrayNumber = 0;
                    break;
                case FIVE_THOUSAND:
                    arrayNumber = 1;
                    break;
                case TEN_THOUSAND:
                    arrayNumber = 2;
                    break;
                case TWENTY_THOUSAND:
                    arrayNumber = 3;
                    break;
                case FIFTY_THOUSAND:
                    arrayNumber = 4;
                    break;
            }
            array = new int[a];
        }
    };

    //private static ArrayList<int[]> test;

/*
    private static int[] oneK = new int[1000];
    private static int[] fiveK = new int[5000];
    private static int[] tenK = new int[10000];
    private static int[] twentyK = new int[20000];
    private static int[] fiftyK = new int[50000];
*/
    /**
     * Two dimensional array to record times for each algorithm for each array size
     */
    private static long[][] times = new long[5][4];

    private static void makeIncreasing()
    {
        for(int i = 0; i < ONE_THOUSAND; i++)
        {
            IntArrays.ONEK.array[i] = i;
        }

        for(int i = 0; i < FIVE_THOUSAND; i++)
        {
            IntArrays.FIVEK.array[i] = i;
        }

        for(int i = 0; i < TEN_THOUSAND; i++)
        {
            IntArrays.TENK.array[i] = i;
        }

        for(int i = 0; i < TWENTY_THOUSAND; i++)
        {
            IntArrays.TWENTYK.array[i] = i;
        }

        for(int i = 0; i < FIFTY_THOUSAND; i++)
        {
            IntArrays.FIFTYK.array[i] = i;
        }
    }

    private static void makeDecreasing()
    {
        for(int i = ONE_THOUSAND - 1; i >= 0; i--)
        {
            IntArrays.ONEK.array[ONE_THOUSAND - (i + 1)] = i;
        }

        for(int i = FIVE_THOUSAND - 1; i >= 0; i--)
        {
            IntArrays.FIVEK.array[FIVE_THOUSAND - (i + 1)] = i;
        }

        for(int i = TEN_THOUSAND - 1; i >= 0; i--)
        {
            IntArrays.TENK.array[TEN_THOUSAND - (i + 1)] = i;
        }

        for(int i = TWENTY_THOUSAND - 1; i >= 0; i--)
        {
            IntArrays.TWENTYK.array[TWENTY_THOUSAND - (i + 1)] = i;
        }

        for(int i = FIFTY_THOUSAND - 1; i >= 0; i--)
        {
            IntArrays.FIFTYK.array[FIFTY_THOUSAND - (i + 1)] = i;
        }
    }

    private static void makeRandom()
    {
        Random gen = new Random();
        for(int i = 0; i < IntArrays.ONEK.array.length; i++)
        {
            int setInt = gen.nextInt(ONE_THOUSAND);
            IntArrays.ONEK.array[i] = setInt;
        }

        for(int i = 0; i < IntArrays.FIVEK.array.length; i++)
        {
            int setInt = gen.nextInt(FIVE_THOUSAND);
            IntArrays.FIVEK.array[i] = setInt;
        }

        for(int i = 0; i < IntArrays.TENK.array.length; i++)
        {
            int setInt = gen.nextInt(TEN_THOUSAND);
            IntArrays.TENK.array[i] = setInt;
        }

        for(int i = 0; i < IntArrays.TWENTYK.array.length; i++)
        {
            int set = gen.nextInt(TWENTY_THOUSAND);
            IntArrays.TWENTYK.array[i] = set;
        }

        for(int i = 0; i < IntArrays.FIFTYK.array.length; i++)
        {
            int set = gen.nextInt(FIFTY_THOUSAND);
            IntArrays.FIFTYK.array[i] = set;
        }
    }

    public static void main(String[] args)
    {
        printData("Increasing");
        printData("Decreasing");
        printData("Random");
    }

    private static void buildArrays(String order)
    {
        if(order.equals("Increasing"))
        {
            makeIncreasing();
        }
        else if(order.equals("Decreasing"))
        {
            makeDecreasing();
        }
        else
        {
            makeRandom();
        }
    }

    private static void printData(String order)
    {
        buildArrays(order);

        System.out.printf("%15s\t%5s\t%5s\t%5s\t%5s\t%5s", order, "1000", "5000", "10000", "20000", "50000");
        System.out.println();
        doSorts();
        System.out.printf("%15s\t%5d\t%5d\t%5d\t%5d\t%5d", "selectionSort", times[0][0], times[1][0], times[2][0], times[3][0], times[4][0]);
        System.out.println();
        System.out.printf("%15s\t%5d\t%5d\t%5d\t%5d\t%5d", "insertionSort", times[0][1], times[1][1], times[2][1], times[3][1], times[4][1]);
        System.out.println();
        System.out.printf("%15s\t%5d\t%5d\t%5d\t%5d\t%5d", "mergeSort", times[0][2], times[1][2], times[2][2], times[3][2], times[4][2]);
        System.out.println();
        System.out.printf("%15s\t%5d\t%5d\t%5d\t%5d\t%5d", "Arrays.sort", times[0][3], times[1][3], times[2][3], times[3][3], times[4][3]);
        System.out.println("\n");
    }

    private static void doSorts()
    {

        ArrayList<int[]> arrays = new ArrayList<int[]>();
        arrays.add(IntArrays.ONEK.array);
        arrays.add(IntArrays.FIVEK.array);
        arrays.add(IntArrays.TENK.array);
        arrays.add(IntArrays.TWENTYK.array);
        arrays.add(IntArrays.FIFTYK.array);

        int counter = 0;
        int sortMethod;
        for(sortMethod = 0; sortMethod < 4; sortMethod++)
        {
            for (int[] array : arrays)
            {
                int[] temp = array;
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
