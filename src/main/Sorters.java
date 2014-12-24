package main;

/**
 * Joseph Zhong
 *  Assignment 13
 *  Sorters file that holds the sorting methods available
 *  Sorters.java
 *  v1.5
 *  2 May 2014
 */

public class Sorters
{
    /**
     * Selection Sort method.
     * Sorts an array of integers using the selection sort algorithm (moving each element to its proper place).
     * @param  list an array of integers to sort. Pre: array out of order, Post: array in order
     */
    public static void selectionSort(int[] list)
    {
        for (int i = 0; i < list.length - 1; i++)
        {
            // find index of smallest element
            int smallest = i;
            for (int j = i + 1; j < list.length; j++)
            {
                if (list[j] < list[smallest])
                {
                    smallest = j;
                }
            }
            // swap smallest to front
            swap(list, i, smallest);
        }
    }

    /**
     * Helper Method. Swap method for the Selection Sorter method.
     * @param list List of values to be modified
     * @param i is the starting index
     * @param smallest is the smallest value index
     */
    private static void swap(int[] list, int i, int smallest)
    {
        int temp = list[i];
        list[i] = list[smallest];
        list[smallest] = temp;
    }

    /**
     * Sorts an array of integers using the insertion sort algorithm (moving each element to its proper place).
     *  More efficient than Bubble Sort.
     *  Modified from SPlutard, http://www.dreamincode.net/code/snippet516.htm
     * @param  list an array of integers to sort. Pre: array out of order, Post: array in order
     */
    public static void insertionSort(int[] list)
    {
        int firstOutOfOrder, location, temp;

        //Starts at second term, goes until the end of the array.
        for( firstOutOfOrder = 1; firstOutOfOrder < list.length;
             firstOutOfOrder++) {
            if ( list[firstOutOfOrder] < list[firstOutOfOrder - 1] ) {
                // If the two are out of order,
                // we move the element to its rightful place.
                temp = list[firstOutOfOrder];
                location = firstOutOfOrder;
                do {
                    // Keep moving down the array until we find exactly
                    // where it's supposed to go.
                    list[location] = list[location-1];
                    location--;
                } while (location > 0 && list[location-1] > temp);
                list[location] = temp;
            }
        }
    }

    /**
     * Helper method for the mergeSort algorithm.
     * Merges both halves into a sorted list
     * @param result a list to be merged into from list1 and list2
     * @param list1 is lower half of the overall list
     * @param list2 is higher half of the overall list
     */
    /*

     */
    public static void merge(int[] result, int[] list1, int[] list2)
    {
        int i1 = 0;
        int i2 = 0;
        for ( int i = 0; i < result.length; i++ )
        {
            if ( i2 >= list2.length || ( i1 < list1.length && list1[i1] <= list2[i2] ) )
            {
                result[i] = list1[i1];
                i1++;
            }
            else
            {
                result[i] = list2[i2];
                i2++;
            }
        }
    }

    /**
     * Merge Sort algorithm.
     * Copied from powerpoint.
     * @param list of values to pass through and sort.
     */
    public static void mergeSort(int[] list)
    {
        // base case list.length == 0 – just falls through.
        if ( list.length > 1 )
        {
            // Split the arrays
            int size1 = list.length / 2;
            int size2 = list.length - size1;
            int[] half1 = new int[size1];
            int[] half2 = new int[size2];
            for ( int i = 0; i < size1; i++ )
            {
                half1[i] = list[i];
            }
            for ( int i = 0; i < size2; i++ )
            {
                half2[i] = list[i + size1];
            }

            // recursively sort the two smaller arrays
            mergeSort(half1);
            mergeSort(half2);

            // merge the sorted halves into a sorted whole
            merge(list, half1, half2);
        }
    }
    /**
     * procedure heapsort(a, count) is
    input: an unordered array a of length count

    (Build the heap in array a so that largest value is at the root)
    heapify(a, count)

    (The following loop maintains the invariants that a[0:end] is a heap and every element
     beyond end is greater than everything before it (so a[end:count] is in sorted order))
    end ← count - 1
    while end > 0 do
        (a[0] is the root and largest value. The swap moves it in front of the sorted elements.)
        swap(a[end], a[0])
        (the heap size is reduced by one)
        end ← end - 1
        (the swap ruined the heap property, so restore it)
        siftDown(a, 0, end)
     */
    public static void heapSort(int[] list)
    {
        heapify(list);

        
    }

    /**
     *
     * @param list
     */
    public static void heapify(int[] list)
    {

    }
}