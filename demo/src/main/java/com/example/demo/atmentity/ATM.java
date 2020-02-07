package com.example.demo.atmentity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ATM {
    @Id
    private Long user_id;
    private String user_name;
    private String user_pass;
    private String user_money;

    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }
    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_money() {
        return user_money;
    }
    public void setUser_money(String user_money) {
        this.user_money = user_money;
    }
}
