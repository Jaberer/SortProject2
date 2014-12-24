package main;

import java.util.ArrayList;

/**
 * Your Name
 * Homework number
 * Brief description of what assignment you’re doing
 * Classname (i.e. the name of the class in the file)
 * Version information
 * Date
 */

public class TestAll
{
    public static void main(String[] args)
    {
        ArrayList<int[]> asdf = null;
        System.out.print(test(asdf));
    }

    private static ArrayList<int[]> test(ArrayList<int[]> arrays)
    {
        int[] abc = {1, 2, 3};
        arrays.add(abc);
        return arrays;
    }
}
