package com.company.service;

import org.springframework.stereotype.Service;

import com.company.bean.UserConfig;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Service
public class UserService {
    UserConfig userConfig;

    @Getter
    @Setter
    @AllArgsConstructor
    public class User {
        private String name;
        private int age;
        private String address;
    }

    private User user;

    public UserService(UserConfig userConfig) {
        this.userConfig = userConfig;

        user = new User("Name", 30, "Address");
    }

    public void login() {
        System.out.println(user.name + " is Logged in");
    }

    public void logout() {
        System.out.println(user.name + " is Logged out");
    }
}
