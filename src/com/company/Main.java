package com.company;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static int sumNumber(int a, int b) {
        return a + b;
    }

    public static String getFirstName() {
        return "Tsvetinka";
    }

    public static String getLastName() {
        return "Marinova";
    }

    public static int getAge() {
        return 24;
    }

    public static void main(String[] args) {

        HashMap<String, Integer> choices = new HashMap<String, Integer>();
        choices.put("Tests.java", 0);
        choices.put("TestNumbers.java", 0);

        boolean playing = true;

        while (playing) {
            System.out.println("");
            System.out.println("1. Enter a full name in order to run a Test class. The possible onse are: Tests.java and TestNumbers.java");
            System.out.println("2. Show the history of the ran tests");
            System.out.println("3. Show the test method which wasn't ran the most");
            System.out.println("4. Show the test method which was ran the most");
            System.out.println("5. Press number 7 to stop the program.");
            System.out.println("");
            System.out.println("Choose an option: ");

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            if(choice != 7) {

                switch (choice) {
                    case 1:
                        System.out.println("Enter a full name of a Test class: ");
                        String testFileName = input.next();
                        if (testFileName.equals("Tests.java")) {
                            testsResult();
                            choices.put("Tests.java", choices.get("Tests.java") + 1);
                        } else if (testFileName.equals("TestNumbers.java")) {
                            testNumbersResult();
                            choices.put("TestNumbers.java", choices.get("TestNumbers.java") + 1);
                        } else {
                            System.out.println("There is not such a test class. Please try with another name.");
                        }
                        break;
                    case 2:
                        System.out.println("Show all the ran tests: ");

                        int countTests = choices.get("Tests.java");
                        int countTestNumbers = choices.get("TestNumbers.java");

                        for (int i = 0; i < countTests; i++) {
                            Tests objTests = new Tests();
                            System.out.println(objTests.getActions());
                        }

                        for (int i = 0; i < countTestNumbers; i++) {
                            TestNumbers objTestNumbers = new TestNumbers();
                            System.out.println(objTestNumbers.getActions());
                        }

                        if (countTests == 0 && countTestNumbers == 0) {
                            System.out.println("No tests were ran till this moment.");
                        }
                        break;
                    case 3:
                        System.out.println("The most rare ran methods are: ");

                        int countTestsRare = choices.get("Tests.java");
                        int countTestNumbersRare = choices.get("TestNumbers.java");

                        if (countTestsRare < countTestNumbersRare) {
                            Tests objTests = new Tests();
                            System.out.println(objTests.getActions());
                        } else if (countTestsRare > countTestNumbersRare) {
                            TestNumbers objTestNumbers = new TestNumbers();
                            System.out.println(objTestNumbers.getActions());
                        } else if (countTestsRare == countTestNumbersRare && countTestsRare != 0 && countTestNumbersRare != 0) {
                            System.out.println("All the methods were ran the same number of times.");

                        } else {
                            System.out.println("No tests were ran till this moment.");
                        }
                        break;
                    case 4:
                        System.out.println("The methods which were ran the most: ");

                        int countTestsMost = choices.get("Tests.java");
                        int countTestNumbersMost = choices.get("TestNumbers.java");

                        if (countTestsMost > countTestNumbersMost) {
                            Tests objTests = new Tests();
                            System.out.println(objTests.getActions());
                        } else if (countTestsMost < countTestNumbersMost) {
                            TestNumbers objTestNumbers = new TestNumbers();
                            System.out.println(objTestNumbers.getActions());
                        } else if (countTestsMost == countTestNumbersMost && countTestsMost != 0 && countTestNumbersMost != 0) {
                            System.out.println("All the methods were ran the same number of times.");
                        } else {
                            System.out.println("No tests were ran till this moment.");
                        }
                        break;
                }
            }else{
                playing = false;
                System.out.println("Bye!");
            }
        }
    }

    public static void testsResult() {
        Class classTests = Tests.class;
        Method[] testMethods = classTests.getDeclaredMethods();
        int count = 0;

        for (Method method : testMethods) {
            if (method.isAnnotationPresent(MoreTest.class)) {
                try {
                    method.invoke(classTests.newInstance());
                    System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
                } catch (Throwable ex) {
                    System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
                }
            } else if (method.isAnnotationPresent(MyAnnotation.class)) {
                try {
                    method.invoke(classTests.newInstance());
                    System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
                } catch (Throwable ex) {
                    System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
                }

            }
        }
    }
    public static void testNumbersResult(){
        Class classTests = TestNumbers.class;
        Method[] testMethods = classTests.getDeclaredMethods();
        int count = 0;

        for (Method method : testMethods) {
            if (method.isAnnotationPresent(MoreTest.class)) {
                try {
                    method.invoke(classTests.newInstance());
                    System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
                } catch (Throwable ex) {
                    System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
                }
            } else if (method.isAnnotationPresent(MyAnnotation.class)) {
                try {
                    method.invoke(classTests.newInstance());
                    System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
                } catch (Throwable ex) {
                    System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
                }

            }
        }
    }
}