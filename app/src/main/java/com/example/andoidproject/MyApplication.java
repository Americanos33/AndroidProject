package com.example.andoidproject;

import android.app.Application;

import com.example.andoidproject.db.User;

public class MyApplication extends Application {

    private User user;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
