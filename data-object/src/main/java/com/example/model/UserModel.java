package com.example.model;

/**
 * 真正的业务逻辑对象
 */
public class UserModel {
    private Integer id;
    private String name;
    private Boolean gender;
    private String phone;
    private String password;

    public Integer getId() {
        return id;
    }

    public UserModel setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserModel setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getGender() {
        return gender;
    }

    public UserModel setGender(Boolean gender) {
        this.gender = gender;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
