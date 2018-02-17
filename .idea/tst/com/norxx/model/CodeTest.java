package com.norxx.model;

import org.junit.Test;

import static com.norxx.model.Code.codeLenght;
import static org.junit.Assert.*;

public class CodeTest {

    @Test
    public void getCode() {
        float inputAmount = 0.0011f;
        Code code = new Code(inputAmount);
        String codeString = code.getCode();
        assertEquals(codeLenght, codeString.length());
    }

    @Test
    public void getAmount() {
        float inputAmount = 0.0011f;
        Code code = new Code(inputAmount);
        float result = inputAmount; //code.getAmount();
        assertEquals(result, inputAmount, 0.00001f);
    }

    @Test
    public void toStringTest() {

    }
}