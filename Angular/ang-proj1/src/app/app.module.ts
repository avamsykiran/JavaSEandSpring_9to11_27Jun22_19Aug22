import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule,Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ArthComponent } from './arth/arth.component';
import { PipesDemoComponent } from './pipes-demo/pipes-demo.component';
import { NumberSeriesComponent } from './number-series/number-series.component';
import { NumberSeriesGroupComponent } from './number-series-group/number-series-group.component';

const routes:Routes = [
  {path:'',pathMatch:'full',redirectTo:'/header'},
  {path:'header',component:HeaderComponent},
  {path:'arth',component:ArthComponent},
  {path:'pd',component:PipesDemoComponent},
  {path:'nss',component:NumberSeriesGroupComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ArthComponent,
    PipesDemoComponent,
    NumberSeriesComponent,
    NumberSeriesGroupComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
