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

        Angular CLI

            ng new proj-name

            proj-name> npm start
            proj-name> npm build
            proj-name> npm test

            proj-name> ng serve 
            proj-name> ng build
            proj-name> ng test

            proj-name> ng g module name
            proj-name> ng g component name --skip-tests
            proj-name> ng g directive name --skip-tests
            proj-name> ng g pipe name --skip-tests
            proj-name> ng g service name --skip-tests
            proj-name> ng g class name --skip-tests
            proj-name> ng g interface name --skip-tests

        Angular Archetecture

            any angular resource is a typescript class.
            each of these classes are marked with decorators related to whta resource it is.
            the decoraters carry configurational info as a json object and is called meta data.

            Modules
                an angular module is class that represents a group of
                components, pipes, services and directives.

                each angular project must be housed inside a top-level module and that module is refered
                to as ROOT-MODULE

                A ROOT-MODULE furthur can have sub-modules refreed to as FEATURE-MODULES

                @NgModule({
                    declarations:[ //a list of components,directives and pipes that belong to this module],
                    imports:[ //a list of sub-modules we have to access in this module],
                    exports:[ //a list of components,directives and pipes that belong to this module and are allowed to accessed outside this module],
                    providers:[ //a list of services that belong to this module],
                    bootstrap:[ //a list of components that have to be initated immediatly after this module is loaded]
                })
                class OrdersModule {}

            Components
                angular offers html extendability. a component is a new html element that we create.

                Component = component.ts + template.html

                @Component({
                    selector:'tag-name',
                    templateUrl:'url of the template file'
                })
                class ShoppingCartComponent{}

                Data Binding:

                    is about using the field of a component in its template.

                    Interpolation
                        render the value of a angular expression into the tmeplate.
                        
                        {{angular-expression}}

                    One-way data binding
                        attribute binding
                        style binding
                        css class binding
                    Two-way data binding
                    event binding

            Directives
                @Directive({
                    selector:''
                })
                class FastMovingStockDirective{}

            Pipes
                @Pipe({
                    name:''
                })
                class DigitsToWordsPipe{}

            Services
                @Injectable({
                    providedIn:'root'
                })
                class OrdersService{}
