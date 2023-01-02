package com.andrelucas.algo.binaryheap;

import java.util.stream.Stream;

public class IntBinaryHeap implements IBinaryHeap<Integer> {

    private final Integer[] array;
    private int index = -1;

    public IntBinaryHeap() {
        array = new Integer[DEFAULT_VALUE];
    }

    public IntBinaryHeap(int capacity) {
        array = new Integer[capacity];
    }

    @Override
    public void add(Integer element) {
        index++;
        array[index] = element;

        var parent = getParent(index);
        var currentIndex = index;
        while (element > parent){
            var parentIndex = getParentIndex(currentIndex);

            array[parentIndex] = element;
            array[currentIndex] = parent;

            parent = getParent(parentIndex);
            currentIndex = parentIndex;
        }
    }

    @Override
    public void addAll(Integer[] elements) {
        Stream.of(elements)
            .forEach(this::add);
    }

    @Override
    public Integer[] getAll() {
        return array;
    }

    private Integer getParent(int index){
        return array[getParentIndex(index)];
    }
}