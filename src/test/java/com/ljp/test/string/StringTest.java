package com.ljp.test.string;

public class StringTest {

    public static void main(String[] args) {
        String testStr = "物理＋化学＋生物";
        String[] testStrArray = testStr.split("＋");
        for (String s : testStrArray) {
            System.out.println(s);
        }
    }

}
