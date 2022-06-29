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


            
