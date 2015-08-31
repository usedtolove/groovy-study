package com.tz.ssh.sit

import com.tz.ssh.util.DataPool
import org.junit.Test

/**
 * Created by hjl on 2015/8/20.
 */
class TestDataPool {

    @Test
    void testDataPool(){
        DataPool.getDataPool().each {clazz ->
            println clazz
        }
    }

}
