package com.cn.lx.utils;


import com.cn.lx.exception.AdException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @author StevenLu
 * @date 2019-08-19 22:41
 */

public class CommonUtils {

    public static String[] parsePatterns = {
            "yyyy-MM-dd","yyyy/MM/dd","yyyy.MM.dd"
    };

    public static String getToken(String value){
        return DigestUtils.md5Hex(value).toUpperCase();
    }

    /**
     * string2date
     * @param dateString
     * @return
     * @throws AdException
     */
    public static Date String2Date(String dateString) throws AdException {
        try {
            return DateUtils.parseDate(dateString,parsePatterns);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new AdException(e.getMessage());
        }
    }
}
