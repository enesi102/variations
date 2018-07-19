package com.jetbrains;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringManagementTest {

    @DataProvider
    public Object[][] data(){
        return  new String[][]{
                new String[]{""},
                new String[]{""},
                new String[]{""},
                new String[]{""},
        };
    }

    @Test
    public void testReplaceAllByCasePattern() {
    }

    @Test
    public void testReplaceAllByCasePattern1() {
    }
}