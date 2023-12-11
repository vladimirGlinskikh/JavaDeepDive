package kz.zhelezyaka.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PassByValueTest {

    @Test
    void shouldDoModifyValues() {
        Integer num = 2_000;
        System.out.println("Before method: " + num);
        ClassByValue classByValue = new ClassByValue(num);
        PassByValue passByValue = new PassByValue();
        passByValue.modifyObject(classByValue);
        System.out.println("After method: " + num);
        System.out.println("Here we see that the object passed by value has no changed.");

        assertEquals(4_000_000, classByValue.getValue());
        assertNotEquals(24, classByValue.getValue());
    }
}