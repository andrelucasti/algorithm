package com.andrelucas.algo;

import com.andrelucas.algo.queue.CyclicBufferQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClassicQueueTest {

    @Test
    void shouldRemoveTheFirstElementThatIsInQueue(){
        var queue = new CyclicBufferQueue<String>(4);
        var firstElement = "Andre";

        queue.enqueue(firstElement);
        queue.enqueue("Lucas");
        queue.enqueue("Santos");
        queue.enqueue("Silva");

        var data = queue.dequeue();
        Assertions.assertEquals(firstElement, data);
    }


    @Test
    void shouldRemoveTheFirstElementAddOneMoreElementAsLastAndRemoveTheSecondElementIsInQueue(){
        var queue = new CyclicBufferQueue<String>(4);
        var firstElement = "Andre";
        var secondElement = "Lucas";
        var lastElement = "Karol";

        queue.enqueue(firstElement);
        queue.enqueue(secondElement);
        queue.enqueue("Santos");
        queue.enqueue("Silva");

        var firstData = queue.dequeue();
        queue.enqueue(lastElement);

        Assertions.assertEquals(firstElement, firstData);

        var secondData = queue.dequeue();
        Assertions.assertEquals(secondElement, secondData);

        queue.dequeue();
        queue.dequeue();

        var lastData = queue.dequeue();
        Assertions.assertEquals(lastElement, lastData);
    }


    @Test
    void shouldKeepTheDataOrderWhenTheQueueCapacityIsFull(){
        var queue = new CyclicBufferQueue<String>(2);
        var firstElement = "Andre";
        var secondElement = "Lucas";
        var thirdElement = "Santos";
        var fourthElement = "Silva";

        queue.enqueue(firstElement);
        queue.enqueue(secondElement);
        queue.enqueue(thirdElement);
        queue.enqueue(fourthElement);

        var firstData = queue.dequeue();
        var secondData = queue.dequeue();
        var thirdData = queue.dequeue();
        var fourthData = queue.dequeue();

        Assertions.assertEquals(firstElement, firstData);
        Assertions.assertEquals(secondElement, secondData);
        Assertions.assertEquals(thirdElement, thirdData);
        Assertions.assertEquals(fourthElement, fourthData);
    }
}