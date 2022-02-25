package com.ljp.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5Utils {

    public static String md5(String input) {
        if (input == null) {
            input = "";
        }
        return md5(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String md5(byte[] input) {
        if (input == null) {
            input = new byte[]{};
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(input);
            byte[] digestBytes = messageDigest.digest();
            StringBuilder stringBuffer = new StringBuilder();
            for (byte digestByte : digestBytes) {
                stringBuffer.append(Integer.toHexString(0Xff & digestByte));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(MD5Utils.md5("hello world !!!"));
        System.out.println(MD5Utils.md5("hello china !!!"));
    }

}
