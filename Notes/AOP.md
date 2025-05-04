# AOP (Aspect-Oriented Programming) in Spring

AOP (Aspect-Oriented Programming) is a programming paradigm that allows you to separate cross-cutting concerns from your core business logic.
It lets you inject behavior before, after, or around method executions — without changing the actual method code.

# ✅ Why Use AOP?

Certain concerns cut across multiple modules, such as:

Logging

Security

Transaction management

Caching

Performance monitoring

Exception handling

Instead of duplicating that logic everywhere, AOP modularizes it into reusable components called aspects.

# 🧠 Core Concepts of AOP

| Concept        | Description                                                                       |
| -------------- | --------------------------------------------------------------------------------- |
| **Aspect**     | A module (class) containing cross-cutting logic (e.g., logging, transactions)     |
| **Join Point** | A point in execution (like method call or exception throw) where AOP code can run |
| **Advice**     | The code that runs at a join point (e.g., before/after a method)                  |
| **Pointcut**   | A predicate that matches join points (e.g., all methods in a package)             |
| **Weaving**    | Process of linking aspects with code (done at runtime in Spring using proxies)    |

# 🛠 Types of Advice

| Type              | Runs when?                      | Example                            |
| ----------------- | ------------------------------- | ---------------------------------- |
| `@Before`         | Before method execution         | Logging entry                      |
| `@After`          | After method completes (always) | Logging exit                       |
| `@AfterReturning` | After successful return         | Audit logging                      |
| `@AfterThrowing`  | If exception is thrown          | Error handling                     |
| `@Around`         | Surrounds method (controls it)  | Performance timing, modifying args |

```
implementation 'org.springframework.boot:spring-boot-starter-aop'
```

# What is the difference between AOP and OOP?

OOP organizes code by data & behavior, AOP organizes code by concerns, especially cross-cutting ones.

# How does Spring implement AOP?

Using dynamic proxies (JDK or CGLIB). It creates proxy objects that weave advice at runtime.

# Can AOP change method arguments or return values?

Only @Around advice can manipulate inputs/outputs.
