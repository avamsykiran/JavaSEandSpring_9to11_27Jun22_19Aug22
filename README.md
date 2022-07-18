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
