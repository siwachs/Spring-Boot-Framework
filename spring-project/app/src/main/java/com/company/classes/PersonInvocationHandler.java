package com.company.classes;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonInvocationHandler implements InvocationHandler {
    private Person person;

    public PersonInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("Proxy Trigger");
        return null;
    }
}
