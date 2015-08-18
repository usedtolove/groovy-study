package com.tz.ssh.entity

import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

/**
 * Created by hjl on 2015/8/14.
 */
@Entity
@Table(name = "tbl_clazz")
@ToString
class Clazz {

    @Id
    @GeneratedValue
    int id;

    @Column(name = "c_name", nullable = false, unique = true, length = 20)
    String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "c_open_date", nullable = false)
    Date openDate;

    @Column(name = "c_room", nullable = false, length = 10)
    String room;

}
