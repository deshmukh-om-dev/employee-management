package com.employee.employee_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "gender_master")
public class GenderMaster {

    @Id
    private Long genderId;

    private String genderName;

    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }
}