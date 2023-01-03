package com.andrelucas.algo.binaryTree;
// Max Heap
// Priority Queue
// childNode L = 2i + 1
// childNode R = 2i + 2
// parentNode  = (i - 1)/2
// i = index
public interface IBinaryTree<T> {
    int DEFAULT_VALUE = 4;
    void add(T data);
    void addAll(T[] datas);
    T[] getAll();

    default int getParentIndex(int index){
        return (index - 1) / 2;
    }

}