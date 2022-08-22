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
                            
                            [attribute]="angular-expression"

                        style binding

                            [style.cssProperty]="angular-expression"

                        css class binding

                            [class.className]="boolean-angular-expression"
                    
                    event binding

                        (event-directive)="method()"
                    
                        html-events         onClick onBlur  onFocus onMouseOver onChange...etc
                        event directives    click   blur    focus   mouseover   change ...etc.,

                    Two-way data binding

                        works only with form controls

                        [(ngModel)]="field"

                        ngModel is a directive defined in a module called FormsModule.

                        FormsModule comes from @angular/forms file.
                    

            Directives
                is a angular defiend html attribute

                Attribute Directives

                    ngModel,routerLink,click,dblclick,change,blur,readonly,...........etc

                Structural Directives

                    *ngIf
                    *ngFor
                    ngSwitch
                        *ngCase
                        *ngDefault

                Custome Directives
                    @Directive({
                        selector:''
                    })
                    class FastMovingStockDirective{}

            Pipes
                to transform data before it gets rendered.

                lowercase
                uppercase
                titlecase
                number
                currency
                date

                
                @Pipe({
                    name:''
                })
                class DigitsToWordsPipe implments PipeTransform {
                    transfrom(value:any) : any {
                        //.............
                    }
                }

                {{data|pipeName}}

            Services
                @Injectable({
                    providedIn:'root'
                })
                class OrdersService{}

        Angular Routing

            RouterModule        from @angular/routing

                Route           {
                                    path:'',
                                    component:ComponentName,
                                    redirectTo:'',
                                    pathMatch:'full|startsWith'
                                    children:[]
                                }

                Routes          Route[]

                forRoot(Routes)

                router-outlet   a inbuilt component that will be replaced with the matchign component.

                routerLink          is a directive to hold a path on 'a' element

                routerLinkActive    is a directive that hold teh css-class to be applied when a link is active.

        RxJS
            Reactive Javascript

            it IS NOT 'ReactJS'

            Reactive Javascript offers communication reactivly over asynchronous
            operations.

            let asynchronousJob = (observer) => {
                //asynchronosu code 
                //observer.next(val) is used to emit intermediate results
                //observer.error(err) is sued to emit error in the mdi of job if any
                //observer.complete() is sued to indicate the compeltion of the job.

            }; 
            
            let  obr = new Observable(asynchronousJob);

            obr.subscribe({
                val => {//do soemthing with the emtied value},
                err => {//error handling method},
                () => {//what to do once the job is done}
            });

        HttpClient

            from HttpClientModule   '@angular/commons/http'

            get(url) : Observable
            put(url,reqBody) : Observable
            post(url,reqBody) : Observable
            delete(url) : Observable