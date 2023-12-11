package kz.zhelezyaka.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassByReferenceTest {

    @Test
    void shouldChangeValue() {
        ClassByReference classByReference = new ClassByReference(3);
        System.out.println("Before method: " + classByReference.getValue());
        PassByReference passByReference = new PassByReference();
        passByReference.modifyObject(classByReference);
        System.out.println("After method: " + classByReference.getValue());
        System.out.println("Here we see that the object passed by reference has changed.");

        assertEquals(9, classByReference.getValue());
        assertNotEquals(24, classByReference.getValue());
    }

    @Test
    void shouldNoChangeValueByReference() {
        ImmutableObject original = new ImmutableObject(12);
        ImmutableObject modified = original.withValue(28);

        assertEquals(12, original.getI());
        assertEquals(28, modified.getI());
    }
}