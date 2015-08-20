package com.tz.ssh.util

import com.tz.ssh.entity.Clazz
import org.apache.commons.lang3.time.DateUtils
import org.fluttercode.datafactory.impl.DataFactory

/**
 * Created by hjl on 2015/8/20.
 */
class DataPool {

    def static getDataPool(){
        def map = new HashMap<String,Clazz>()
        def df = new DataFactory();

        def max = 10
        def minDate = new Date(2013-1900,1,1)
        def maxDate = new Date(2015-1900,7,31)
        (1..max).each {i->
            //println i
            Calendar calendar = Calendar.getInstance()
            calendar.setTime(df.getDateBetween(minDate, maxDate))
            int year = calendar.get(Calendar.YEAR)
            int month = calendar.get(Calendar.MONTH) + 1
            Clazz clazz = new Clazz(name:'JSD-'+year+month, openDate:calendar.time, room:'room-'+df.getRandomChars(1,6))
            map.put(clazz.name, clazz)
        }

        return new ArrayList(map.values());
    }

}
