package com.tz.ssh.sit.cases

import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * Created by hjl on 2015/8/20.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses([
        SitClazzList.class,
        SitClazzAddFaild.class,
        SitClazzAddBatch.class
])
class SitAllSuite {
}
