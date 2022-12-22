package com.andrelucas.algo.queue;

public class CyclicBufferQueue<T> implements Queue<T>{
    private Object[] array;
    private int head = 0;
    private int tail = 0;
    private int queueCapacity;

    public CyclicBufferQueue(int queueCapacity){
        this.queueCapacity = queueCapacity;

        array = new Object[queueCapacity];
    }


    @Override
    public void enqueue(T data) {

        if (queueFull()){
            var hasSpace = false;
            for(int i = 0; i < this.head ; i++) {
                if (array[i] == null){
                    array[i] = data;
                    hasSpace = true;
                    break;
                }

            }

            if (!hasSpace){
                array = grow();
                array[this.tail] = data;
                this.tail++;

            }

        } else {
            array[this.tail] = data;
            this.tail++;
        }
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
        return this.tail >= this.array.length;
    }

    private Object[] grow(){
        //Rebuild array
        this.queueCapacity = queueCapacity + 2;
        var newArray = new Object[queueCapacity];

        System.arraycopy(this.array, 0, newArray, 0, this.array.length);

        return newArray;
    }
}