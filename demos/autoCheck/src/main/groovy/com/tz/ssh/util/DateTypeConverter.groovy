package com.tz.ssh.util

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter

import java.text.DateFormat
import java.text.SimpleDateFormat

/**
 * Created by hjl on 15-8-17.
 */
class DateTypeConverter extends DefaultTypeConverter{

    static final DateFormat[] ACCEPT_DATE_FORMATS = [new SimpleDateFormat("yyyy-MM-dd")]

    @Override
    convertValue(Map<String, Object> context, Object value, Class toType) {
        if (toType == Date.class) { // The browser is submitted to the server, String to Date conversion
            Date date = null;
            String dateString = null;
            String[] params = (String[]) value;
            dateString = params[0];// Gets a string date
            for (DateFormat format : ACCEPT_DATE_FORMATS) {
                try {
                    return format.parse(dateString);// Ergodic date support format, conversion
                } catch (Exception e) {
                    continue;
                }
            }
            return null;
        }else if (toType == String.class) { // The server to the browser output, Date to String type conversion
            Date date = (Date) value;
            return new SimpleDateFormat("yyyy-MM-dd").format(date);// The output format is yyyy-MM-dd
        }
    }
}
