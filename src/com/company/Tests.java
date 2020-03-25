package com.company;

import org.junit.Assert;
import org.junit.Test;

@MyAnnotation(firstName = "Tsvetinka", lastName = "Marinova", age = 24)
public class Tests {
    @MyAnnotation
    public void checkName() {
        String actual = Main.getName();
        Assert.assertEquals("Tsvetinka", actual);
    }

    @Test
    public void TestIsZero(){
        int actual = Main.sumNumber(0, 0);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void TestIsNotZero(){
        int actual = Main.sumNumber(5, 0);
        Assert.assertEquals(0, actual);
    }
}