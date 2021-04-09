package com.example.andoidproject;

import android.app.Application;

import com.example.andoidproject.db.Question;
import com.example.andoidproject.db.User;

public class MyApplication extends Application {

    private User user;
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
