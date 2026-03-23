package com.sabbir.library.models;

public class Member {
    private int id;
    private String name;
    private String email;
    private String phone;

    public Member() {}

    public Member(int id, String phone, String email, String name) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-20s | %-25s | %-15s |",
                id, name, email, phone);
    }
}
