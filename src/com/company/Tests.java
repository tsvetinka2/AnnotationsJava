package com.company;


import Assert.myClassAssert;

import java.util.ArrayList;
import java.util.List;

@MyAnnotation(firstName = "Tsvetinka", lastName = "Marinova", age = 24)
public class Tests {
    @MyAnnotation
    public void checkFirstName() throws Exception{
        String actual = Main.getFirstName();
        myClassAssert.stringAssert("Tsvetinka", actual);
    }

    @MyAnnotation
    public void checkLastName() throws Exception{
        String actual = Main.getLastName();
        myClassAssert.stringAssert("Pavlova", actual);
    }

    @MyAnnotation
    public void checkAge() throws Exception{
        int actual = Main.getAge();
        myClassAssert.numbersAssert(24, actual);
    }

    List<String> actions = new ArrayList<>();

    public List<String> getActions(){
        actions.add("CheckFirstName");
        actions.add("CheckLastName");
        actions.add("CheckAge");
        return actions;
    }

}