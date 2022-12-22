package com.andrelucas.algo.queue;

public class CyclicBufferQueue<T> implements Queue<T>{
    private Object[] array;
    private int head = 0;
    private int tail = 0;
    private final int queueCapacity;

    public CyclicBufferQueue(int queueCapacity){
        this.queueCapacity = queueCapacity;

        array = new Object[queueCapacity];
    }


    @Override
    public void enqueue(T data) {
        if (queueFull() && this.array[this.head] == null){
            this.tail = 0;
        }

        if(queueFull() && this.array[this.head] != null){
            this.array = rebuildArray();
        }

        array[this.tail] = data;

        this.tail++;
    }

    @Override
    public T dequeue() {
        T data = null;
        while (data == null){
            if (array.length == head) {
                this.head = 0;
            }

            data = (T) array[this.head];
            array[this.head] = null;

            this.head ++;
        }

        return data;
    }

    private boolean queueFull(){
        return this.array.length == this.tail;
    }

    private Object[] rebuildArray(){
        //Rebuild array
        var newArray = new Object[queueCapacity + 2];

        System.arraycopy(this.array, 0, newArray, 0, this.array.length);

        return newArray;
    }
}