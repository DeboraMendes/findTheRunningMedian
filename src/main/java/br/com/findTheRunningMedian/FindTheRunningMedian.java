package br.com.findTheRunningMedian;

import java.util.Collections;
import java.util.PriorityQueue;

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
