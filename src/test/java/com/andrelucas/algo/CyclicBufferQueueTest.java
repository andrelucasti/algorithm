package com.andrelucas.algo;

import com.andrelucas.algo.queue.CyclicBufferQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CyclicBufferQueueTest {

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

        queue.enqueue("Andre");
        queue.enqueue("Lucas");
        queue.enqueue("Santos");
        queue.enqueue("Silva");
        queue.enqueue("Karol");

        Assertions.assertEquals("Andre", queue.dequeue());
        Assertions.assertEquals("Lucas", queue.dequeue());

        queue.enqueue("A");
        queue.enqueue("B");

        Assertions.assertEquals("Santos", queue.dequeue());

        queue.enqueue("C");

        Assertions.assertEquals("Silva",  queue.dequeue());
        Assertions.assertEquals("Karol",  queue.dequeue());
        Assertions.assertEquals("A",  queue.dequeue());


        Assertions.assertEquals("B", queue.dequeue());
        Assertions.assertEquals("C", queue.dequeue());
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