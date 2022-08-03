Java Standard Edition
-------------------------------------------------------------------------

    Lab Setup
        1. JDK 8
        2. STS latest
        3. RDBMS - MySQL latest

    Lang Fundas
    OOPs
    Java Standard Library
        java.lang
            basic classes, exception, threads
        java.time
            date time api
        java.util
            generics, collections, lamdba expressions, stream api
        java.io, java.nio
            input output streams
        
    OOPs
        public interface Shape {
            public static final double PI=3.14;
            
            double area();
            double perimeter();

            default double estiamtePaintingCost(double parinRatePerUnitArea){
                return area()*parinRatePerUnitArea;
            }

            static double totalArea(Shape ...shapes){
                double total=0;
                for(Shape s : shapes)
                    total+=s.area();
                return total;
            }
        }
    

        'this','super','static','abstract','final'


        public class Rectangle implements Shape{
            private double length;
            private double breadth;

            //constructors, setters, getters

            public double area(){
                return length*breadth;
            }

            public double perimeter(){
                return 2*(length+breadth);
            }
        }

        public class App{
            public static void main(String ...a){
                Shape s1 = new Rectangle();

                Shape s2 = new Shape(){
                    private double radius
                    //setter and getters
                    
                    public double area(){
                        return PI*radius*radius;
                    }

                    public double perimeter(){
                        return 2*PI*radius;
                    }
                };
            }
        }

    java.lang

        Object          int hashcode(),boolean equals(Object),String toString()
        System
        Math
        
        String
        StringBuffer
        StringBuilder

        Wrapper Classes

        Exception Handling
            Throwable
                |- Error
                |- Exception                ----------> Checked Exception
                    |- RuntimeException     ----------> UnChecked Exception

            Checked Excepotions are detected by the compiler and are expcted to be handled via
            try..catch statement or 'throws' keyword.

            Unchecked Exceptions are ignored by the compiler and are not expected to be handled.

            public class EmployeeService {
                public void incrementSalary(Employee emp,double increment){
                    if(emp!=null) {
                        emp.setSalary(emp.getSalary()+increment);
                    ] //we are avoiding the NullPointerException
                }
            }

            Unchecked exceptions are not handled but avoided through defensive programming.

        Multi-Threading

            Runnable                void run()
                |- Thread
                                    Thread()
                                    Thread(String name)
                                    Thread(Runnable runnable)
                                    Thread(String name,Runnable runnable)

                                    void start();
                                    void setName(String);
                                    String getName();
                                    int getPriority();
                                    void setPriority(int p);

                                    static void sleep(long);
                                    static Thread currentThread();

            Object                  wait(),notify(),notifyAll(),yeild()

            Synchronization,Concurrency API

            ProblemStatmeent
                model Bus having a fixed nubmer of seats.(say 25)

                ReservationRunnable that will accept number of seats to be reserved and should 
                reserve one seat at a time.

                three instances of the ReservationRunnable each needing say 10 seats
                and achive the reseravation without any conflict.

    java.time
    
        LocalDate               .now(),.of(year,Month,day)
        LocalDateTime           .now(),.of(year,Month,day,hour,minute,second)
        ZonedDateTime           .now(Zones.of("GMT+3"))
        Period                  .between(startLocalDate,endLocalDate)
        Duration                .between(startLocalDateTime,endLocalDateTime)
        DateTimeFormatter       .ofPattern("dd-MM-yyyy hh:mm:ss")
    
                localDateObj.format(dtfObj)
                LocalDate.parse(dtStr,dtfObj)

    java.util
        generics, collections, lamdba expressions, stream api

        class Swapper<T>{
            public void doSwap(T a,T b){
                T t=a;
                a=b;
                b=t;
            }
        }

        Swapper<Integer> intSwap = new Swapper<>();
        Swapper<Double> dblSwap = new Swapper<>();
        Swapper<String> strSwap = new Swapper<>();
        Swapper<Employee> empSwap = new Swapper<>();

        Collections API

            Collectiom              add(element),remove(element),boolean isEmpty(),int size()
                |-List              element get(index),add(index,eleemnt),replace(index,element) ..
                |               linear data structure where index based operations are possible
                |               any number of null and duplicates can be added
                |-Set           non-linear data strucutre where index based operations are not possible
                                only one null can be added, no duplicates are allowed


                List implementation
                        Vector      growable array and is thread safe
                        ArrayList   growable array but is not thread safe
                        LinkedList  doubly linked list data structure

                Set Implementation
                        HashSet             does not follow any retrival oreder
                        LinkedHashSet       follow the entry order for retrival
                        TreeSet             follow the sorted order for retrival


                Object that implement Comaprable are only allowed into a TreeSet
                Or otherwise we have pass an object of Comparator into the treeset
            
            Map                 put(key,value),replace(key,value),value get(key),
               |                boolean containsKey(key),keySet()
               |-SortedMap 

                Map implementations
                    HashMap             does not follow any retrival oreder
                    LinkedHashMap       follow the entry order for retrival
                    TreeMap             follow the sorted order for retrival

    java.io, java.nio
        input output streams

    Streams API

        Functional Interface
            is an interface having only one abstract method.

            @FunctionalInterface
            interface MyInterface{
                int operate(int x);
            }

            class MyInterfaceImpl impleemnts MyInterface{
                public int operate(int x){
                    return x*x;
                }
            }

            MyInterface myObj = new MyInterfaceImpl();
            System.out.println(myObj.operate(5));
            
            MyInterface myObj2 = new MyInterface(){
                public int operate(int x){
                    return x/2;
                }
            };
            System.out.println(myObj2.operate(5));

        Lambda Expressions

            MyInterface myObj3 = n -> Math.pow(n,n); 
            System.out.println(myObj3.operate(5));

        Functional Interfaces are called
                Suppliers   when the underlying abstract method returns value but has no args        
                Consumers   when the underlying abstract method does not return value but has args
                Predicates  when the underlying abstract method returns boolean always
                Operators

                java.util.function

        Stream API provide functional programming.

            Stream means flow of data.

            Stream needs a source to flow and any list/set/map/array can be such source.

            java.util.stream.Stream

            Stream s1 = Stream.of(val1,val2,val3,.......)
            Stream s2 = Arrays.stream(new Employee[] {emp1,emp2,emp3...})
            Stream s3 = listObj.stream();
            Stream s4 = setObj.stream();


                forEach     accepts a consumer and executes the cosnuer on each ele of the stream
                reduce      accepts a BianryOperator and reduces the whole stream into a single value
                collect     accepts a Collector and is used to collect all the 
                                ele in the stream into a collection

                map         accepts an operator and executes that on each value of the stream
                            and returns a new stream containing the results.
                filter      accepts a predicate and executes the predicate on each valeu of the stream
                            and returns a new stream of values that pass the givne predicate
                
    Assignment

        List<Txn> txns = new ArrayList<>();

        //Each txn has txId,description,amount,txnDate,txnType (CREDIT/DEBIT)

        totalCredit,totalDebit, and balance

JPA and Hibernate
===================================================================================================

    Java Persistence API
    Java Transaction API

                            Object Relational Mapping

                        OOPs                            RDBMS
                        -------------------------------------------------------------------------
    EntityDef           Class                           Table
    Entity              object                          Record/Row/Tuple
    Property            fields                          Column
    Behaviour           methods                         --------

    Is A                inheretence                     Single Table
                                                        Join Table
                                                        Table Per Class
    Has A
     OnetoOne           reference objects               joins
     OneToMany
     ManyToOne
     ManytoMany

    JPA Configuaration

        where abouts of the database is configuared in a file called 
        'META-INF/persistence.xml'

    JPA
        @Entity
        @Table(name="")

        @Id
        @Column
        @Transiant


    JPA API
            Persistence
            EntityManagerFactory
            EntityManager
                .persist
                .merge
                .remove
                .find
                .query("JPQL qry")
                

        Movie  <--ManyToMany--> Artists

        Movie  
                <--OneToMany-->     
                                Roles       
                <--OneToMany-->     
        Artists

Spring Framework
==================================================================================================

    is a not shell of a varity of modules. It is a perfect development platform for java EE application.

    -> Light weight and highly modular

            Spring Core             Dependency Injection
            Spring SpEL             Spring Expression Language
            Spring Context          Autowiring and externalized configs
            Spring AOP              Aspect Oriented Programming
            Spring Data JDBC        Spring uspport for JDBC through JdbcTemplate
            Spring Data JPA         Spring support for JPA
            Spring Boot             Rapid Application Development through auto-configuaration
            Spring Web              Web MVC and Rest api
            Spring Security         Autherization and Authentication
            Sprint Test             Testing unit and integration
            Spring Cloud            Cloud based tools for Microservices
            Spring Batch            Batch Processing ....
            .....etc

    -> Interoperable Puggable

    Spring Core, SpEL and Context
    --------------------------------------------------------------------------------------

        support for all other spring module 
        offers Dependency Injection.

        interface EmployeeDAO{

        }

        class EmployeeDAOJdbcImpl implements EmployeeDAO {

        }

        class EmployeeDAOJpaImpl implements EmployeeDAO {

        }

        interface EmployeeService {

        }

        class EmployeeServiceImpl implements EmployeeService {
            private EmployeeDAO empDao;

            public EmployeeServiceImpl(EmployeeDAO empDao){
                //this.empDao = new EmployeeDAOJdbcImpl();
                this.empDao = empDao;
            }

            public void setEmpDao(EmployeeDAO empDao){
                this.empDao = empDao;
            }
        }

        EmpployeeService empService1 = new EmployeeServiveImpl(new EmployooDAOJdbcImpl());  //constructor injection
        empService1.setEmpDao(new EmployeeDAOJpaImpl()); //setter injection

        
        Dependency Injection is a concrete method of the idea Inversion of Control

            Component       is any class in an application that offers a fe functions needed by the application.
                            all services, daos, controllers, utility classes .....etc

            Bean            is an object of a component whose life cycle is managed by a container, but by the application.

            Container       is the one that creates, supply , destroys the beans of the components.

        Spring Containers
            BeanFactory             Spring Core
            ApplictionContext       Spring Context      

                ApplicationContext is more advanced than beanfactory. ApplicationContext offers AutoWiring whihc is
                not possible through BeanFactory.

        Bean Configuaration
            is to inform the container - how many componetns we ahve and which bean is dependent of which other bean.

            Xml Based Configuaration

            Java Based Configuaration

                the mehtod name is used as bean id.

                @Configuration
                public class BeanConfig {

                    @Bean
                    public Scanner scanner(){
                        return new Scanner(System.in);
                    }

                    @Bean
                    public LocalDate today(){
                        return LocalDate.now();
                    }                    

                }

            Annotation Based Configuaration

                @Component("beanId")
                    @Service
                    @Repository
                    ...etc
                @ComponentScan("base-package")

                @Autowired
                    applied on the field                            field injection
                    applied on a constructor having an argument     constructor injection  byConstructor
                    applied on a setter method                      setter injection

                    byType  map the beans with a field if they both are of the same type.

                @Qualifier
                    byName  map the beans with a field through the bean name.
                
                @Value and Spring Expression Language      
                    used to inject a key from a .properties file into our primitive or String field

                @PropertySource

                @Scope("singleton|prototype|request|session|global-session")

                @PostConstruct      is applied a init-method that has to execute after mapping of all fields
                @PreDestroy         is applied on a destroy-method to be invoked jsut before destroying our bean.

    Spring Boot
    --------------------------------------------------------------------------------------

        offers auto configuration, that results in Rapid Application Development.

        Spring Starter Project
            1. using http://start.spring.io
            2. using STS spring starter project wizard
            3. using STS CLI


        @SpringBootApplication  =   @Configuration
                                    @ComponentScan("thePackageInWhichTheSringBootApplciationClassExists")
                                    @PorpertySource("classpath:application.properties")

        SpringApplication.run(...)
            Going To Create an ApplicationContext
            Executing all the Runners
            Start the Embeded Servers if any...

            Shutdown the Servers and Closes the ApplicationContext

        Spring Runners
            CommandLineRunner       public abstract void run(String ...arg);
            ApplicationRunner       public abstract void run(SpringApplciationArguments args);

    Spring Data JPA
    --------------------------------------------------------------------------------------------------------

        is a Spring Framework module that provides automatic dynamic implmeentation for jpa based repositories.

        CrudRepository
         | - JpaRepository

        @Transactional

        existsBy
        findBy
        findAllBy
    
        @Query

    Spring Web
    --------------------------------------------------------------------------------------------------------

        is another spring framework module that supports MVC web applications adn REST api applications.

        Spring Web on spring Boot is offered by org.springframework:spring-boot-web-starter package.

        Spring Web comes with a preconfigured WebApplicationContext and Web Application Runner which
        launches an embed tomcat server.

        Spring Web MVC

            single front controller MVC 

                Repo(s) <---> Service(s) <---> Controller(s) <---> FrontController <------- REQ ----- Client
                                                                        |
                                                                        |model
                                                                        |
                                                                        ↓
                                                                        View(s) --------------- RESP--->

                FrontController             DispatcherServlet
                                            With the help of UrlResolver it maps a req to a controller
                                            The controller after processing the req will share a model 
                                            and viewName with the FrontController
                                            With the help of ViewResolver it maps a viewName with a view.
                                            FrontController will share the model with the view and the response is sent

                UrlResolver                 SimpleUrlResolver                   by default on spring boot
                                                @RequestMapping                 is used here to map a controller
                                                                                and action with a url.
                                                    @GetMapping
                                                    @PostMApping
                                                    @PutMapping
                                                    @PatchMapping
                                                    @DeleteMapping ...etc
                                            ControllerBeanNameUrlResolver
                                            ...etc
                
                ViewResolver                XmlBeanResourceViewResolver
                                            MessageBeanResourceViewResolver
                                            InternalResourceViewResolver          by default on spring boot

                                                    prefix and suffix             config..d in application.properties

                                                    actualView = prefix + viewName + suffix

                Controller                  is any POJO annoted as @Controller
                                            a controller can have method called actions to process a request
                                            these action method must return 
                                                        either a viewName as String
                                                        or an object of ModelAndView class holding the models and a viewName
                                            these action method are injected with the data from the request using
                                            @RequestParam or @PathVariable or @ModelAttribute

        
        Rest Web Service

            a web service is a public hsoted buiness logic that can be invoked from a remote system.

                                                                                | <- Andriod APP
            DAO <-> SERVICE <-> WebServiceController    <--REQ -                | <- Angular APP
                                                        --DATA AS RESP -->      | <- Dynamic Web APP
                                                                                | <- React APP ...etc.,

                SOAP Web Service
                
                    1. xml is only means of exchanging data
                
                HTTP Web Service / REpresentational State Transfer API (REST api)

                    1. xml/json/binary/text..etc., to serve as a means of data exchange
                    2. have a designed HTTP STATUS system to signal success or failure of a request

                            100 to 199      a request is recived and is under process
                            300 to 399      a request is being redirected

                            200 to 299      a request is processed successfully
                                            200     OK          if a retirval is successful
                                            201     CREATED     if an insertion is successful
                                            203     ACCEPTED    if an updation is successful
                                            204     NO CONTENT  if a deletion is successful

                            400 to 499      a request failed due to a client side error
                                            400     BAD REQUEST if an insertion/updation fialed due to
                                                                validation issues etc.,

                                            404     NOT FOUND   if a deletion / retirval fails as the record is not found

                            500 to 599      q request failed due to a server side error
                                            500     INTERNAL SERVER ERROR       we ahve any unhandled exceptions

                    3. have a set of HTTP Methods each mapped to a CRUD operation reducing the need for multiple urls 
                       for CRUD Operations

                        /txns       GET         retrive
                                    POST        insert
                                    PUT         update
                                    DELETE      delete

        Spring Web REST

            @RestController =   @Controller + @ResponseBody

            @RestControllerAdvice
            @ExceptionHandler

            @PathVariable
            @RequestBody

            ResponseEntity  is an encapsualtion of responseBody and httpStatus

            REST Client to verify our rest api end points
                PostMan
                Insomnia   https://updates.insomnia.rest/downloads/windows/latest?app=com.insomnia.app&source=website

        IncomeStatement Case Study

            1. Various AccoutnHolders can register themselves
            2. Each AccountHolder can add/edit/delete the Txns made day to day
            3. Each AccountHolder must be able to generate a monthly or annual IncomeStatement
            4. That IncoemStatement must have the statement summary [totalCredit,totalDebit and statementBalance]

        Mono-Lithic Applications

            income-statment
                entity
                    AccountHolder
                        aid:long,fullName:string,mobile:string,currentBal:double,txns:Set<Txn>
                    Txn
                        tid:long,amount:double,desp:string,tdate:LocalDate,type:TxnType,owner:AccoutnHolder
                repo
                    AccountHolderRepo
                    TxnRepo
                service
                    AccoutnHolderService
                    TxnService
                controller
                    AccountHolderController
                    TxnController

                income-statement.jar

            - are huge and any alteration needs a lot care and attention, it needs that each and every stakeholder
                need to have the idea of the BigPicutre of the app.
            - lack the possibility of adopting to new technologies.
            - granular scalability is not possible.
        
        Microservices

            is a eco0system of inter-communicting isolated individual indepent applications.
                where each of such application is called a micro-service

            income-statement-account-service.jar        registrations of account holders
            incoem-statement-txns-service.jar           create/update/delete operation on Txn
            income-statement-statement-service.jar      generating monthly or annual statment

            + a microservice is comaprtivly a very small unit and can be mnaged with great ease of effort.
            + a microservice can be independnently scaled thus promoting granualar scalability
            + adopting to new technology is far more easy and effortless.
            + each mciroservice can be of a different platform of developemnt.

            Chanllenges
            ? On what basis and how doe we divide a product into micro-services (how many and why??)
            ? Observing and Monitoring acros multiple microservices
            ? Maintain Configuration across multiple microservices
            ? Database facilitation
            ? Transacton Management across multiple microservices
            
        Microservices Design Pattern

            Decompositon Desing Patterns
                Decomposition by Domain
                Decomposition by Sub-domain
            Database Design Pattern
                Single Database Design Pattern
                Database per service Design Pattern
                CQRS Design Pattern
                Saga Design Pattern
            Integration Design Pattern
                Aggregator Design Pattern
                Client Side Component Design Pattern
                API Gateway Design Pattern
            Performence Monitoring Design Patterns
                Log Aggregation Design Pattern
                Performence Aggregation Design Pattern
                Distributed Tracing Design Pattern
            Cros-Cutting Desing Pattern
                Discovery Service Design Pattern
                Load Balance Design Pattern
                Circuit Breaker Design Pattern
                External Cofniguration Design Pattern

            Decomposition by Domain
                a doamin is a unit of functionality or feautre of an application. Generally each module of
                a monolithic applciation can become a potential domain.

                income-statement
                    profiles
                    txns
                    statement

            Decomposition by Sub - Domain, Aggregator Design Pattern
                talks about god classes. GOD classes that those that are needed almost in every micro-service.
                These god classes are guided by the sub-domain or bounded-context.
                
                income-statement
                    profiles
                        AccountHolder
                            aid:long,fullName:string,mobile:string
                    
                    txns
                        AccountHolder
                            aid:long,currentBal:double,txns:Set<Txn>
                    
                        Txn
                            tid:long,amount:double,desp:string,tdate:LocalDate,type:TxnType,owner:AccoutnHolder
                    
                    statement (aggregator - collection data form other micro-services and composing it into one single resposne)
                        AccountHolder
                            aid:long,fullName:string,mobile:string,currentBal:double
                    
                        Txn
                            tid:long,amount:double,desp:string,tdate:LocalDate,type:TxnType
                    
                        Statement
                            startDate:LocalDate,endDate:LocalDate,totalCredit:double,totalDebit:double,statementBal:dobule,
                            txns:Set<Txn>,holder:AccountHolder

            Discovery Service Design Pattern, client side load balancer

                         (eureka service)   
                        discovery -------------|
                        ↑ ↑ ↑                  | 
             (register) | | |                  | 
                        | | |-profiles ←-------| (fetech the details of other services )
                        | |                    | (Spring Cloud Laod Balancer)
                        | |--txns ←------------|
                        |                      | 
                        |---statement ←--------|

            API Gateway Design Pattern

                            (eureka service)   
                |--------------- discovery
                |                ↑↓  ↑↓  ↑↓                
                |        --------||  ||  ||----------------
                |        ||          ||                  ||
                |        ↑↓          ↑↓                  ↑↓ 
                |    profiles ----  txns  ---------   statement
                |        ||          ||                  ||
                |        ↑↓          ↑↓                  ↑↓ 
                |        --------||  ||  ||----------------
                |                ↑↓  ↑↓  ↑↓                
                |-------------  api-gateway
                            (spring cloud gateway)
                                    ||
                                    ||
                                    ↑↓
                            Client Applciations
                        (AndroidApp,AngularAPP,REACT-APP)

            Distributed Tracing Design Pattern

                                                        Client Applciations
                                                (AndroidApp,AngularAPP,REACT-APP)
                                                                ↑↓
                                                                |
                                                                ↑↓    
                (eureka service)                        (spring cloud gateway)   
                discovery                                  api-gateway
                    ↑↓                                          ↑↓                
                    |<------------------------------------------>|
                            ||          ||                  ||
                            ↑↓          ↑↓                  ↑↓ 
                        profiles ----  txns  ---------   statement
                        (sleuth)      (sleuth)            (sleuth)
                            ||          ||                  ||
                            ↑↓          ↑↓                  ↑↓ 
                            --------||  ||  ||----------------
                                    ↑↓  ↑↓  ↑↓                
                                Disributed Tracing Service
                                    (zipkin)

            Circuit Breaker Design Pattern     

                    A completed req - resp cycle is called a Circuit

                    Circuit
                            OPEN         on detecting unavailability of any underlying service,
                            HALF-OPEN    after a thruhold of time /reuest, anattempt to
                                         close cirucit is made - if OK, circuit is CLOSED else OPENED
                            CLOSED       all the underlying services are working fine.

                    Hystrix          is a netflix provided circuit braker library
                    Reseliance4j     is the recent alternate for Hystrix   

            External Cofniguration Design Pattern

                                                        Client Applciations
                                                (AndroidApp,AngularAPP,REACT-APP)
                                                                ↑↓
                                                                |
                                                                ↑↓    
                (eureka service)                        (spring cloud gateway)   
                discovery                                  api-gateway
                    ↑↓                                          ↑↓                
                    |<------------------------------------------>|
                            ||          ||                  ||
                            ↑↓          ↑↓                  ↑↓ 
                        profiles ----  txns  ---------   statement
                        (sleuth)      (sleuth)            (sleuth)
                            ||          ||                  ||
                            ↑↓          ↑↓                  ↑↓              
                    |<------------------------------------------>|
                    ↑↓                                          ↑↓   
            Disributed Tracing Service                      Config Server
                (zipkin)                                         ↑↓   
                                                                  |
                                                                  |
                                                                  |
                                                                 ↑↓   
                                                                GIT REPO
                                                                    profile.properties
                                                                    txns.properties
                                                                    statement.properties  
