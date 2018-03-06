package com.test.demo;

import java.util.Calendar;

import org.junit.Test;

public class reverseTest {
    @Test
    public void test(){
        String string = "123456";
        string = reverse(string);
        System.out.println(string);
    }
    
    public static String reverse(String originStr) {

        if(originStr == null || originStr.length() <= 1)

         return originStr;

        return reverse(originStr.substring(1)) + originStr.charAt(0); 

        }
    
    @Test
    public void timeOfYesterday(){
        Calendar cal = Calendar.getInstance(); 
        cal.add(Calendar.DATE, -1);
        System.out.println(cal.getTime());
    }
}
