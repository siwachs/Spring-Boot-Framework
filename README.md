# What is Spring Boot?

Spring Boot is a Java-based framework built on top of Spring to:

Simplify backend application development

Handle configuration automatically (auto-configuration)

Provide built-in web server (Tomcat/Jetty)

Let you build REST APIs and microservices quickly

🔧 Analogy:
If Spring is like Express.js + a full config manual, Spring Boot is like Express.js + default sensible configurations + live-reload.

# 🔄 2. What is IoC and DI?

IoC (Inversion of Control):
A design principle where control of object creation and lifecycle is inverted — the framework (Spring) handles it instead of you.

DI (Dependency Injection):
A way to achieve IoC — you inject dependencies (objects) into a class instead of creating them manually.

```
const db = new MongoClient(); // Manual creation

@Autowired
MongoClient db; // Framework injects it automatically
```

# 🌱 3. What is a Bean?

A Bean is just a Java object managed by the Spring container (IoC container). It can be:

A service

A repository

A controller

Any custom object

# 🧪 4. How to Create & Initialize a Bean

✅ Option 1: Annotate a class with @Component, @Service, or @Repository

```
@Component
public class MyService {
    public void doSomething() {
        System.out.println("Doing something...");
    }
}

@RestController
public class MyController {

    @Autowired
    MyService myService;

    @GetMapping("/")
    public String hello() {
        myService.doSomething();
        return "Hello";
    }
}


```

# ⚙️ 5. What is Gradle?

Gradle is a build automation tool, like:

npm or yarn in JS

Handles dependencies (build.gradle)

Compiles, tests, packages Java code

Faster than Maven (alternative build tool)

```
plugins {
    id 'org.springframework.boot' version '3.2.2'
    id 'java'
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

```

| Concept     | Purpose                                     |
| ----------- | ------------------------------------------- |
| Spring Boot | Fast app setup with Spring                  |
| IoC         | Framework controls object lifecycle         |
| DI          | Inject dependencies instead of creating     |
| Bean        | Object managed by Spring container          |
| Gradle      | Build tool for managing dependencies, build |

# Init a Project Manually

gradle init

```
plugins {
    id 'org.springframework.boot' version '3.2.2'
    id 'io.spring.dependency-management' version '1.1.4'
    id 'java'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '17'

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}


```

Run that project using:
./gradlew bootRun
