package br.com.findTheRunningMedian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FindTheRunningMedianTest {

    @Test
    public void test() {
        double[] medianArr = {12.0, 8.0, 5.0, 4.5, 5.0, 6.0};
        double[] doubles = FindTheRunningMedian.runningMedian(12, 4, 5, 3, 8, 7);
        for (int i = 0; i < 6; i++) {
            assertEquals(String.valueOf(medianArr[i]), String.valueOf(doubles[i]));
        }
    }

}
