package com.company;

import org.junit.Assert;

@MyAnnotation(firstName = "Tsvetinka", lastName = "Marinova", age = 24)
public class Tests {
    @MyAnnotation
    public void checkName() {
        String actual = Main.getName();
        Assert.assertEquals("Tsvetinka", actual);
    }

    @MoreTest
    public void TestIsZero(){
        int actual = Main.sumNumber(0, 0);
        Assert.assertEquals(0, actual);
    }

    @MoreTest
    public void TestIsNotZero(){
        int actual = Main.sumNumber(5, 0);
        Assert.assertEquals(0, actual);
    }
}