Angular 11
-------------------------------------------------------------------------------------------------------

    is a typescript based ui/ux framework.

    + all feature supported in the framework, we use thrid party libraries very rarely.
    + it supports dependency injection.

    Web Application Evolution

        Static Websites
            WebServer       <--------REQ--------------  Client
                .html       ------RESP(html contnet)--->
                .css

        Dynamic Web Applications
            WebServer                                   Client
                
                Server side <--------REQ--------------
                programs
                            will generate html contnet
                            dynamically
                            
                            ------RESP(html contnet)--->    unload the previou content
                                                            and load the new content.
                



        Single Page Applications

             WebServer                                   Client
                
                spa-bundle <--------REQ--------------
                 index.html  +
                 a lot of javascript

                           ------RESP(spa-bundle)--->    the spa-bundle is received,
                                                         the index.html is parsed and loaded
                                                         and eventually all the javascript attached to it
                                                         is also loaded.

                                                         the behaviour is handled by javascript on the 
                                                         client. when ever needed, the javascript is going to generate new html contnet on the client and 
                                                         replaces the older contnet with tne contnet on
                                                         the same index.html page.

                web services    <------REQ -----------   when the javascript needs some data
              (SOAP / REST)     -RESP(data.xml/data.json)--> data is received via JS and used.
        
    Angular Essentials

        Typescript      =   javascript + datatypes

            javascript                              typescript
        
        class Employee {                            class Employee {
                                                        private empId:number;
                                                        private fullName:string;
                                                        private salary:number;

            constructor(){                              constructor(){
                this.empId=0;                               this.empId=0;
                this.fullName="";                           this.fullName="";
                this.salary=0;                              this.salary=0;
            }                                           }

            hra(percent){                               hra(percent:number) : number {
                return percent*this.salary;                    return percent*this.salary;
            }                                           }
        }                                           }

                                                    supports interfaces, and typescript 
                                                    interfaces can have fields and abstract functions.


        NodeJS
            is server side run time for javascript.

            composing the code              IDE             VSCode
            mange dependencies              build tool      npm (node package maange)
            compile (.ts to .js)            transpeller     babel
            test                            testing lib     jasmine
            package                         packageing tool webpack

            all these tools like npm,babel,jasmine,webpack are supposed to run on developer machine
            not on the client.

            thee tools are javascirpt based tools and hence we need NodeJS to facilate
            execution of these tools, but not to execute your project.


