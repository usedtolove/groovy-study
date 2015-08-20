package com.tz.ssh.entity

import groovy.transform.ToString

import javax.persistence.*

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

    @Column(name = "c_creation", nullable = false)
    Date creationTime;

    @PrePersist
    void prePersist() {
        creationTime = new Date()
    }

    /*@Column(name = "c_mdf_time", nullable = false)
    Date modificationTime

    @PreUpdate
    void preUpdate() {
        modificationTime = new Date()
    }*/



}
