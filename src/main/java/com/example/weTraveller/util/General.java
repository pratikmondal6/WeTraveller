package com.example.weTraveller.util;

import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.util.UUID;

public class General {
    public static String getUniqueId(){
        try {
            MessageDigest salt = MessageDigest.getInstance("SHA-256");
            salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
            return bytesToHex(salt.digest());
        }catch (Exception e){
        }
        return "";
    }

    public static String bytesToHex(byte[] byteArray) {
        StringBuffer hexStringBuffer = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            hexStringBuffer.append(byteToHex(byteArray[i]));
        }
        return hexStringBuffer.toString();
    }

    public static String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

    public static String getURL(String url) {
        if(!StringUtils.isEmpty(url) && url.contains(".")) {
            if(!url.matches("(http|https)://.*")) {
                return "http://" + url;
            }
            return url;
        }
        return "";
    }

    public static String makePlural(int time, String timeUnit) {
        return time == 0 || time > 1 ? timeUnit + "s" : timeUnit;
    }
}
