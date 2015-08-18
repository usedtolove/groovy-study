package com.tz.ssh.dao

import com.tz.ssh.entity.Clazz
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository

/**
 * Created by hjl on 2015/8/15.
 */
interface ClazzDao extends CrudRepository<Clazz,Integer> {

    Clazz findByName(String name)

}