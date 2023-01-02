package com.andrelucas.algo;

import com.andrelucas.algo.binaryheap.IntBinaryHeap;
import com.andrelucas.algo.queue.BinaryHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BinaryHeapTest {

    @Test
    void shouldAddFirstElementInFirstLevel(){
        var names = new String[]{"Andre"};
        var binaryHeap = new BinaryHeap<String>();

        binaryHeap.addAll(names);

        var firstElement = binaryHeap.getAll()[0];
        Assertions.assertEquals("Andre", firstElement);

    }

    @Test
    void shouldReturnTheMaxValue(){
        var numbers = new Integer[]{4, 2, 8, 7};

        var binaryHeap = new IntBinaryHeap();
        binaryHeap.addAll(numbers);

        var result = binaryHeap.getAll()[0];

        Assertions.assertEquals(8, result);
    }

    @Test
    void shouldReturnTheSecondElementInSecondLevel(){
        var numbers = new Integer[]{4, 2, 8, 7};

        var binaryHeap = new IntBinaryHeap();
        binaryHeap.addAll(numbers);

        var result = binaryHeap.getAll()[1];

        Assertions.assertEquals(7, result);
    }

    @Test
    void shouldReturnTheLastElementInLastLevel(){
        var numbers = new Integer[]{4, 2, 8, 7, 3};

        var binaryHeap = new IntBinaryHeap(5);
        binaryHeap.addAll(numbers);

        var result = binaryHeap.getAll()[4];

        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldReturnListInMaxHeapShape(){
        var numbers = new Integer[]{4, 2, 8, 7, 1, 5, 3, 6, 10};
        var expected = new Integer[]{10, 8, 5, 7, 1, 4, 3, 2, 6};

        var binaryHeap = new IntBinaryHeap(numbers.length);
        binaryHeap.addAll(numbers);

        var result = binaryHeap.getAll();
        System.out.println(Arrays.stream(result).toList());

        Assertions.assertArrayEquals(expected, result);
    }
}