package com.tz.dao;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created by hjl on 2015/9/22.
 */
public class TestUtils {

    @Test
    public void test1(){
        assert StringUtils.isNumeric("123") == true;
        assert StringUtils.isNumeric("asd") == false;
        assert StringUtils.isNumeric("123asd") == false;
        assert StringUtils.isNumeric("123.456") == false;
        assert StringUtils.isNumeric("2511133444") == true;
    }

}
