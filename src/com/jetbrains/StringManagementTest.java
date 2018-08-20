package com.jetbrains;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringManagementTest {

    @Test
    void replaceAllByCasePatternTest() {
//        assertAll("Cabin",
//                () -> StringManagement.replaceAllByCasePattern("Arin","Ar", "Cab"),
//                () -> StringManagement.replaceAllByCasePattern("Arin","Ar", "cab"),
//                () -> StringManagement.replaceAllByCasePattern("Arin","ar", "cab")
//        );

        String a = StringManagement.replaceAllByCasePattern("Arin","ar", "cab");
    }
}