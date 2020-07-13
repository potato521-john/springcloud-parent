package com.yht.cloud;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

public class MyTest {

    @Test
    public void testTime(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
