# Proxies

In Spring Boot (and Spring in general), proxies play a crucial role in enabling features like:

Dependency Injection (DI)

AOP (Aspect-Oriented Programming)

Transactional behavior (@Transactional)

Lazy initialization

Method security

# ✅ What is a Proxy?

A proxy is an object that wraps your actual bean and adds extra behavior before or after method calls — without modifying your original class.

Spring creates a proxy object and injects it instead of the real bean.

# 🔧 Types of Proxies in Spring

| Type                  | Description                                                                   |
| --------------------- | ----------------------------------------------------------------------------- |
| **JDK Dynamic Proxy** | Uses Java's built-in proxy, works if the bean implements at least 1 interface |
|                       | And can intercept any class only if it implements with interface              |
| **CGLIB Proxy**       | Uses bytecode generation, works for concrete classes ie work on class level   |

# 📦 When Does Spring Use Proxies?

```
@Transactional
public void doWork() {
    // Spring creates a proxy to manage DB transactions
}

The proxy opens and commits/rolls back the transaction around this method.
```

```
@Async
public void sendEmail() {
    // Runs in a separate thread — thanks to proxy
}

@Cacheable, @Scheduled, @Retryable
```

# ⚠️ Important Proxy Limitations

```
❌ Self-invocation doesn't work

public class MyService {
    @Transactional
    public void methodA() {
        methodB(); // NO transaction here!
    }

    @Transactional
    public void methodB() {
        // Only works if called externally, not internally
    }
}

Why? Because the proxy isn't used on internal calls — it's just this.methodB().
```

# Why use proxies instead of modifying code directly?

Proxies follow the Open-Closed Principle — you extend behavior without changing the actual class.

# When will Spring use JDK proxy vs CGLIB?

If the bean implements an interface → JDK proxy.
If not → CGLIB.

# Usecase of Proxies

Proxies are core enablers of dynamic behavior in modern backend frameworks like Spring Boot. They allow frameworks to wrap extra logic (cross-cutting concerns) around method calls — without changing your code.

✅ Real-World Use Cases of Proxies in Spring Boot

```
1. Transaction Management (@Transactional)
Use Case: Automatically begin and commit/rollback database transactions.

@Transactional
public void saveUser(User user) {
    userRepository.save(user);
}

```

```
2. Method-Level Security (@PreAuthorize)
Use Case: Control access to specific methods based on user roles.

@PreAuthorize("hasRole('ADMIN')")
public void deleteAccount(String id) {
    // only admins can call this
}
```

```
3. Lazy Initialization (@Lazy)
Use Case: Delay bean creation until it's actually needed.

@Autowired
@Lazy
private HeavyService heavyService;
```

```
4. Asynchronous Execution (@Async)
Use Case: Run a method in a separate thread.

@Async
public void sendEmail() {
    // doesn't block main thread
}
```

```
5. AOP (Aspect-Oriented Programming)
Use Case: Add logic like logging, metrics, or auditing to multiple methods.

@Before("execution(* com.example.*.*(..))")
public void logMethod() {
    System.out.println("Method called");
}

🔍 Proxy intercepts every method call in matching package and logs it.
```

```
@Cacheable, @Retryable
```

| Feature                    | Enabled By Proxy? | Description                             |
| -------------------------- | ----------------- | --------------------------------------- |
| `@Transactional`           | ✅                | Wraps DB logic with transaction control |
| `@Async`                   | ✅                | Spawns background thread for method     |
| AOP (`@Before`, etc.)      | ✅                | Injects behavior at method boundaries   |
| `@Cacheable`, `@Retryable` | ✅                | Handles caching/retry dynamically       |

# ⚠️ Caution: Proxies Can't Intercept Internal Calls

```
public class Service {
    @Transactional
    public void save() {
        this.update(); // ❌ update() call bypasses proxy
    }

    @Transactional
    public void update() {}
}

Only external calls go through the proxy.
```
