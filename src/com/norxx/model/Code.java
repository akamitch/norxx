package com.norxx.model;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Code {
    private String codeString;
    private float amount;
    public static final int codeLenght = 5;
    enum status {
            valid, invalid
    }


    public Code(float amount){
        this.amount = amount;
        this.codeString = generateSecureStringCode(codeLenght);
        //добавить проверку, вдруг есть уже такой активный код
    }

    private Code(String codeString, float amount){
        this.amount = amount;
        this.codeString = codeString;
    }

    private static Code getFromBase(String codeString){
        return new Code(codeString, 999.12f);
        //Todo сделать выгрузку кода из базы и ексепшен если нету такого кода
    }

    public static String generateSecureStringCode(int codeLenght){
        String allowedSymbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder result = new StringBuilder(allowedSymbols.length());
        SecureRandom secureRandom = new SecureRandom();
        for (int i=0; i < codeLenght; i++) {
            int randomSymbolNum = Math.abs(secureRandom.nextInt()) % allowedSymbols.length();
            char randomChar = allowedSymbols.charAt(randomSymbolNum);
            result.append(randomChar);
        }
        return result.toString();
    }


    public float getAmount(){
        return this.amount;
    }

    public String getCode() {
        return codeString;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return codeString;
    }

}
