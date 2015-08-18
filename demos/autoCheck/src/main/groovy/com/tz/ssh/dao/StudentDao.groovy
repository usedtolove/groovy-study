package com.tz.ssh.dao

import com.tz.ssh.entity.Student
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

/**
 * Created by hjl on 2015/8/16.
 */
interface StudentDao extends CrudRepository<Student, Integer> {

    @Query("from Student s where s.clazz.id =:id")
    List<Student> findByClazzId(@Param("id") int id);

}
