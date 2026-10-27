package com.example.arrays.factory;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.arrays.entity.CustomArray;
import com.example.arrays.exception.CustomArrayException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class CustomArrayFactoryImplTest {

    private final CustomArrayFactory factory = new CustomArrayFactoryImpl();
    private final int[] elements = {5, 6, 7};

    @Test
    void createShouldWrapGivenElements() throws CustomArrayException {
        // when
        CustomArray actual = factory.create(elements);
        // then
        assertArrayEquals(elements, actual.getElements());
    }

    @Test
    void createShouldThrowExceptionWhenElementsAreNull() {
        // given
        int[] nothing = null;
        // when
        Executable action = () -> factory.create(nothing);
        // then
        assertThrows(CustomArrayException.class, action);
    }
}
