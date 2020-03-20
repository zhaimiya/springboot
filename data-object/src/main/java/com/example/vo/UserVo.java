package com.example.vo;

public class UserVo  {
    private Integer id;
    private String name;
    private Boolean gender;
    private String phone;

    public Integer getId() {
        return id;
    }

    public UserVo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserVo setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getGender() {
        return gender;
    }

    public UserVo setGender(Boolean gender) {
        this.gender = gender;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserVo setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
