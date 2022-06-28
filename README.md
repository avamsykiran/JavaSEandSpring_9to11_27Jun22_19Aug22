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
                                    Thread(String name,Runnable runnale)

                                    void start();
                                    void setName(String);
                                    String getName();
                                    int getPriority();
                                    void setPriority(int p);

                                    static void sleep(long);
                                    static Thread currentThread();

            Object                  wait(),notify(),notifyAll(),yeild()

            
