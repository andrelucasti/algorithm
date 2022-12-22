package com.andrelucas.algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    @Test
    void testSort(){
        var numbers = new Integer[]{7, 5, 10, 6, 8};
        var bubbleSort = new BubbleSort<Integer>();

        var numbersSorted = bubbleSort.sort(numbers);

        Assertions.assertEquals(5, numbersSorted[0].intValue());
        Assertions.assertEquals(6, numbersSorted[1].intValue());
        Assertions.assertEquals(7, numbersSorted[2].intValue());
        Assertions.assertEquals(8, numbersSorted[3].intValue());
        Assertions.assertEquals(10, numbersSorted[4].intValue());
    }
}