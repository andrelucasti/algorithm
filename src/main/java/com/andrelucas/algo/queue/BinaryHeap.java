package com.andrelucas.algo.queue;


import java.util.stream.Stream;

// Max Heap
// Priority Queue
// childNode L = 2i + 1
// childNode R = 2i + 2
// parentNode  = (i - 1)/2
// i = index
public class BinaryHeap<T> {

    private final Object[] array;
    private int index = -1;

    public BinaryHeap(){
        array = new Object[4];
    }

    public void add(T data){

        

        index ++;
        array[index] = data;


    }

    private void addLeft(T data) {
        var leftIndex = ((2 * index) + 1);
        array[leftIndex] = data;
    }


    private void addRight(T data) {
        var rightIndex = ((2 * index) + 2);
        array[rightIndex] = data;
    }

    public void addAll(T[] datas){
        Stream.of(datas).forEach(this::add);
    }

    private T getParent(int parentIndex){
        var index = (parentIndex - 1) / 2;

        if(parentIndex <= 0){
            return (T) array[0];
        }

        return (T) array[index];
    }


    public Object[] getAll() {
        return array;
    }
}