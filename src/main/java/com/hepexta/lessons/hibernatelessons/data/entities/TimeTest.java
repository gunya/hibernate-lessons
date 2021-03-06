package com.hepexta.lessons.hibernatelessons.data.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "time_test")
public class TimeTest {

    @Id
    @GeneratedValue
    private Long timeTestId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date time;
    private java.sql.Timestamp sqlDatetime;
    private java.sql.Timestamp sqlTimestamp;
    private java.sql.Date sqlDate;
    private java.sql.Time sqlTime;

    public TimeTest(Date date){
        this.datetime = date;
        this.timestamp = date;
        this.time = date;
        this.date = date;

        this.sqlDatetime = new java.sql.Timestamp(date.getTime());
        this.sqlTimestamp = new java.sql.Timestamp(date.getTime());
        this.sqlDate = new java.sql.Date(date.getTime());
        this.sqlTime = new java.sql.Time(date.getTime());
    }
}
