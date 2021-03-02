package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class listClass {
    int x = 100;

    public void getNext() {
        x++;
        System.out.println(Thread.currentThread().getName() + " :" + x);
    }
}

public class DemoTest {

    @Test
    public void test02() throws InterruptedException {

        listClass l = new listClass();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                l.getNext();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                l.getNext();
            }
        });

        thread1.start();
        thread2.start();

        l.getNext();
//        System.out.println(Thread.currentThread().getName() + " :" + x);
    }

    @Test
    public void test03() {
        List list = new ArrayList<>();
        List sList = Collections.synchronizedList(list);
        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(() ->
                    sList.add(Thread.currentThread().getName())
            );
            thread.start();
        }

        System.out.println(sList.size());
    }
}
