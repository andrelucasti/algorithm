package com.andrelucas.algo;

public class BubbleSort<T> {
    public T[] sort(T[] data) {

        if (data[0] instanceof Integer){
            return (T[]) sortNumbers((Integer[]) data);
        }


        return data;
    }

    private Integer[] sortNumbers(Integer[] numbers){

        for(int j = 0; j < numbers.length; j++) {
            var changeCount = 0;

            for(int i = 0; i+1 < numbers.length; i++) {
                var current = numbers[i];
                var next = numbers[i + 1];

                if (current > next){
                    numbers[i] = next;
                    numbers[i + 1] = current;

                    changeCount ++;
                }

            }
      
            if (changeCount <= 0){
                break;
            }
        }

        return numbers;
    }
}