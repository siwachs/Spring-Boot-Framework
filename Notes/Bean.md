# Bean

A Bean is simply an object that is managed by the Spring IoC container. Think of a Bean as a regular Java object (POJO) that Spring creates, configures, and manages for you.

# 📦 How Spring Manages Beans

Spring has an IoC (Inversion of Control) container that:

Creates objects (Beans)

Injects dependencies

Handles lifecycle

Manages scope (singleton, prototype, etc.)

This is all part of Dependency Injection (DI).

# ✅ Declaring Beans — 3 Main Ways

1. Using @Component (and its specializations)

```
@Component
public class MyService {
    public void doSomething() {
        System.out.println("Doing something...");
    }
}

Spring auto-detects it via component scanning if the package is scanned.

@Service → for service layer

@Repository → for DAO layer

@Controller → for web layer
```

2. Using @Bean in @Configuration Class

```
@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyService();
    }
}

Here you're manually telling Spring: “Create a bean of this type.”
```

# 🔁 Bean Lifecycle

| Phase                                                        | What Happens                      |
| ------------------------------------------------------------ | --------------------------------- |
| **Instantiation**                                            | Spring creates the bean object    |
| **Populate Properties**                                      | Dependencies are injected         |
| **BeanNameAware, ApplicationContextAware**                   | Optional hooks                    |
| **@PostConstruct** / `InitializingBean.afterPropertiesSet()` | Initialization callbacks          |
| **Bean is Ready**                                            | Available for use                 |
| **@PreDestroy** / `DisposableBean.destroy()`                 | Cleanup phase when context closes |

# 🎯 Bean Scope

By default, Spring beans are singleton — only one instance is created and reused.

Other scopes:
prototype: New bean each time requested
request, session, application (for web apps)

# 🔍 Bean Injection Examples

1. Constructor Injection (Preferred)

```
@Component
public class MyController {

    private final MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }
}
```
