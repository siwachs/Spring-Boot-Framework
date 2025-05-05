# ✅ What is AOP?

AOP (Aspect-Oriented Programming) is a programming paradigm that helps you separate cross-cutting concerns (like logging, security, transaction management) from your main business logic.

Instead of spreading logging/transaction code throughout your app, AOP lets you define it once in an aspect and apply it where needed.

# 🧩 Key Terms in AOP (Spring-style)

| Term           | Meaning                                                                                          | Example                                          |
| -------------- | ------------------------------------------------------------------------------------------------ | ------------------------------------------------ |
| **Aspect**     | A class that defines **cross-cutting concerns** (e.g., Logging, Security)                        | `@Aspect` class with methods like `logRequest()` |
| **Advice**     | Code that runs **at a certain join point** (before/after/around)                                 | `@Before`, `@After`, `@Around` annotated methods |
| **Join Point** | A specific point in the program where advice can be applied (usually a method call)              | e.g., method `saveUser()`                        |
| **Pointcut**   | An expression that selects join points                                                           | `execution(* com.app.service.*.*(..))`           |
| **Weaving**    | The process of **connecting aspects to target classes** (at runtime, compile time, or load time) | Spring uses **runtime proxy-based weaving**      |

# 🔧 Real Example

```
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.app.service.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("Before: " + joinPoint.getSignature().getName());
    }
}
```

# 💡 What’s happening here?

| Component        | What it does                                                  |
| ---------------- | ------------------------------------------------------------- |
| `@Aspect`        | Declares this class is an aspect                              |
| `@Before(...)`   | Runs **before any method** in `com.app.service`               |
| `JoinPoint`      | Gives access to method name, arguments, etc.                  |
| `execution(...)` | **Pointcut** expression that matches all methods in a package |

# ⚙️ Types of Advice

| Type               | Annotation        | Runs...                                                    |
| ------------------ | ----------------- | ---------------------------------------------------------- |
| **Before**         | `@Before`         | Before the target method                                   |
| **After**          | `@After`          | After method execution (even if exception)                 |
| **AfterReturning** | `@AfterReturning` | Only if method completes normally                          |
| **AfterThrowing**  | `@AfterThrowing`  | Only if method throws exception                            |
| **Around**         | `@Around`         | Wraps the method: control before and after (most powerful) |

# 🔄 Weaving Types

| Weaving Type     | Description                                                 | Used in...                 |
| ---------------- | ----------------------------------------------------------- | -------------------------- |
| Compile-time     | Aspects applied during compilation (e.g., AspectJ compiler) | Static weaving             |
| Load-time        | Aspects woven as classes are loaded                         | Requires agent/classloader |
| Runtime (Spring) | **Proxies created at runtime**                              | ✅ Used by Spring AOP      |

# 🔁 AOP vs OOP — Side-by-Side Comparison

| Feature                    | **OOP (Object-Oriented Programming)**                                 | **AOP (Aspect-Oriented Programming)**                                       |
| -------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| **Focus**                  | Organizes code into objects/classes based on **business logic**       | Separates **cross-cutting concerns** (like logging, security, transactions) |
| **Separation of concerns** | Done through classes & interfaces (limited)                           | Achieves **better modularity** via aspects                                  |
| **Code location**          | Cross-cutting code is scattered or duplicated across multiple classes | Centralized in **aspects**                                                  |
| **Reuse**                  | Inheritance & composition                                             | Reusable aspects across unrelated objects                                   |
| **Main abstraction**       | **Class / Object**                                                    | **Aspect / Advice**                                                         |
| **Modularity**             | Modular for business logic only                                       | Modular for **system-wide concerns**                                        |
| **Example Concern**        | `UserService`, `OrderService`, etc.                                   | Logging, auditing, exception handling, authentication                       |
| **Tooling (Java)**         | Built-in Java OOP features                                            | Spring AOP, AspectJ (external tools/frameworks)                             |
