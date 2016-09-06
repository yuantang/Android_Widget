package com.coder.tom.androidtips;

import java.util.regex.Pattern;

/**
 * Created by tangyuan on 2016/6/17.
 */
public class ValidationUtils {

    public static boolean isPhoneNumber(String phone){
        String regex="1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8}";
        Pattern p = Pattern.compile(regex);
        return p.matcher(phone).find();
    }

}
