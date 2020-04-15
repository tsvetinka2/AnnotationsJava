package com.company;

import Assert.myClassAssert;

import java.util.ArrayList;
import java.util.List;

public class TestNumbers {
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

    List<String> actions = new ArrayList<>();

    public List<String> getActions(){
        actions.add("TestIsZero");
        actions.add("TestIsNotZero");
        return actions;
    }
}
