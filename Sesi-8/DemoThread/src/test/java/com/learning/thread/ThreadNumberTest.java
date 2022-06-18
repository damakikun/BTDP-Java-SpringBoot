package com.learning.thread;

import org.junit.Test;

import com.learning.thread.util.NumberGenerator;


public class ThreadNumberTest {
    @Test
    public void testRun() {
        NumberGenerator generator = new NumberGenerator(1000, 2000);
        for (int i = 0; i < 3; i++) {
            new ThreadNumber(generator).start();
        }
    }
}
