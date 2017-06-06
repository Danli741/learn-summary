package com.diyill.json;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * @version 2017/6/2 下午4:26
 * @description 功能描述
 * @see
 * @since 1.0
 */

public class Student {
    private String name;
    private String address;
    @SerializedName(value ="dateOfBirth",alternate = {"birth","date_of_birth"})
    private Date dateOfBirth;

    public Student() {
    }

    public Student(String name, String address, Date dateOfBirth) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
