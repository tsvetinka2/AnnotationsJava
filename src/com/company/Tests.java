package com.company;


import Assert.myClassAssert;

@MyAnnotation(firstName = "Tsvetinka", lastName = "Marinova", age = 24)
public class Tests {
    @MyAnnotation
    public void checkName() throws Exception{
        String actual = Main.getName();
        myClassAssert.stringAssert("Tsvetinka", actual);
    }

    @MoreTest
    public void TestIsZero() throws  Exception{
        int actual = Main.sumNumber(0, 0);
        myClassAssert.numbersAssert(0, actual);
    }

    @MoreTest
    public void TestIsNotZero() throws Exception{
        int actual = Main.sumNumber(5, 0);
        myClassAssert.numbersAssert(0, actual);
    }
}