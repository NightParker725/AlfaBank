package com.example.alfabank.model;

import java.util.Date;

public class Record {
    private double value;
    private String type;
    private String desc;
    private Date date;

    public Record(double value, String type, String desc, Date date) {
        this.value = value;
        this.type = type;
        this.desc = desc;
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
