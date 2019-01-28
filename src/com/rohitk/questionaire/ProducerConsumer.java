package com.rohitk.questionaire;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {

    private Queue<Integer> buffer;

    Producer(Queue<Integer> pBuffer) {
        this.buffer = pBuffer;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (buffer) {
                while (!buffer.isEmpty()) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                    }
                }
                Integer value = new Integer(new Random().nextInt(17));
                buffer.offer(value);
                System.out.println("Produced Value : " + value);
                buffer.notifyAll();
            }
        }
    }
}

class Consumer implements  Runnable {

    private Queue<Integer> buffer;

    Consumer(Queue<Integer> pBuffer) {
        this.buffer = pBuffer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                    }
                }
                Integer value = buffer.poll();
                System.out.println("Consumed Value : " + value);
                buffer.notifyAll();
            }
        }
    }
}