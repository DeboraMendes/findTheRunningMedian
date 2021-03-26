package br.com.findTheRunningMedian;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://www.hackerrank.com/challenges/find-the-running-median/problem
 *
 * Find the Running Median
 *
 * The median of a set of integers is the midpoint value of the data set for which an equal number of integers are less than and greater than the value. To find the median, you must first sort your set of integers in non-decreasing order, then:
 *
 * If your set contains an odd number of elements, the median is the middle element of the sorted sample. In the sorted set {1, 2, 3}, 2 is the median.
 * If your set contains an even number of elements, the median is the average of the two middle elements of the sorted sample. In the sorted set {1, 2, 3}, (2 + 3) / 2 is 2.5 the median.
 * Given an input stream of n integers, perform the following task for i^th each  integer:
 *
 * Add the i^th integer to a running list of integers.
 * Find the median of the updated list (i.e., for the first element through the i^th element).
 * Print the updated median on a new line. The printed value must be a double-precision number scaled to 1 decimal place (i.e., 12.3 format).
 * Example
 * a = [7, 3, 5, 2]
 * Sorted          Median
 * [7]             7.0
 * [3, 7]          5.0
 * [3, 5, 7]       5.0
 * [2, 3, 5, 7]    4.0
 * Each of the median values is stored in an array and the array is returned for the main function to print.
 *
 * Note: Add formatting to the print statement.
 *
 * Function Description
 * Complete the runningMedian function in the editor below.
 *
 * runningMedian has the following parameters:
 * - int a[n]: an array of integers
 *
 * Returns
 * - float[n]: the median of the array after each insertion, modify the print statement in main to get proper formatting.
 *
 * Input Format
 *
 * The first line contains a single integer, n, the number of integers in the data stream.
 * Each line i of the n subsequent lines contains an integer, a[1], to be inserted into the list.
 *
 * Constraints
 *
 * image
 *
 * Sample Input
 *
 * STDIN   Function
 * -----   --------
 * 6       a[] size n = 6
 * 12      a = [12, 4, 5, 3, 8, 7]
 * 4
 * 5
 * 3
 * 8
 * 7
 * Sample Output
 *
 * 12.0
 * 8.0
 * 5.0
 * 4.5
 * 5.0
 * 6.0
 * Explanation
 *
 * There are n = 6 integers, so we must print the new median on a new line as each integer is added to the list:
 *
 * image
 */
public interface FindTheRunningMedian {

    static double[] runningMedian(int... a) {
        int n = a.length;

        double[] medianArr = new double[n];
        int i = 0;

        // max-heap
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());

        // min-heap
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();

        double median = 0.0;

        for (int j = 0; j < n; j++) {
            int x = a[j];
            if (min.size() == max.size()) {
                if (x < median) {
                    max.add(x);
                    median = (double) max.peek();
                    medianArr[i] = median;
                    i += 1;
                } else {
                    min.add(x);
                    median = (double) min.peek();
                    medianArr[i] = median;
                    i += 1;
                }
            } else if (max.size() > min.size()) {
                if (x < median) {
                    min.add(max.remove());
                    max.add(x);
                } else {
                    min.add(x);
                }
                median = (double) (max.peek() + min.peek()) / 2;
                medianArr[i] = median;
                i += 1;
            } else {
                if (x > median) {
                    max.add(min.remove());
                    min.add(x);
                } else {
                    max.add(x);
                }
                median = (double) (max.peek() + min.peek()) / 2;
                medianArr[i] = median;
                i += 1;
            }
        }

        return medianArr;
    }

}
