package com.tz.ssh.entity

import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

/**
 * Created by hjl on 2015/8/15.
 */
@Entity
@Table(name = "tbl_student")
@ToString(excludes = "clazz")
class Student {

    @Id
    @GeneratedValue
    int id;

    @Column(name = "s_name", nullable = false, length = 10)
    String name;

    @Column(name = "s_gender", nullable = false, length = 1)
    String gender;

    @Column(name = "s_degree", nullable = false, length = 10)
    String degree;

    @ManyToOne
    @JoinColumn(name = "clazz_id", nullable = false)
    Clazz clazz;

}
