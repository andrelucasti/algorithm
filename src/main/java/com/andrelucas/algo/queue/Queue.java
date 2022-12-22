package com.andrelucas.algo.queue;

public interface Queue<T> {
    void enqueue(T data);
    T dequeue();
}