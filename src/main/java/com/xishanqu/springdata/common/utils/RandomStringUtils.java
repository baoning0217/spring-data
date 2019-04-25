package com.xishanqu.springdata.common.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created By BaoNing On 2019/3/18
 */
public class RandomStringUtils {

    private static final char[] DEFAULT_CODEC = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public static final char[] NUMERIC = "1234567890".toCharArray();

    public static String random(int length){
        return random(length, DEFAULT_CODEC);
    }

    public static String randomNumberic(int length){
        return random(length,NUMERIC);
    }

    public static String random(int length, char[] CODEC){
        Random random = new SecureRandom();
        byte[] verifierBytes = new byte[length];
        random.nextBytes(verifierBytes);
        char[] chars = new char[verifierBytes.length];
        for (int i = 0; i < verifierBytes.length; i++){
            chars[i] = CODEC[((verifierBytes[i] & 0xFF) % CODEC.length)];
        }
        return new String(chars);
    }

}
