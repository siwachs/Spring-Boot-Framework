/*
 * This source file was generated by the Gradle 'init' task
 */
package com.company;

import java.lang.reflect.Proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.company.classes.Man;
import com.company.classes.Person;
import com.company.classes.PersonInvocationHandler;

@SpringBootApplication
@EnableAspectJAutoProxy
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        Man man = new Man("Mohan", 30, "Delhi", "India");

        ClassLoader manClassLoader = man.getClass().getClassLoader();
        Class<?>[] interfaces = man.getClass().getInterfaces();

        Person proxyMan = (Person) Proxy.newProxyInstance(manClassLoader, interfaces, new PersonInvocationHandler(man));
        proxyMan.introduce(null);
    }
}
