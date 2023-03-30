import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {Router, RouterModule, Routes} from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { FormsModule} from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { WelcomeComponent } from './welcome/welcome.component';
import { LibraryComponent } from './library/library.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { SuccessComponent } from './success/success.component';
import { AuthorWelcomeComponent } from './author-welcome/author-welcome.component';
import { AuthorLibraryComponent } from './author-library/author-library.component';
import { AddItemComponent } from './add-item/add-item.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { VideoComponent } from './video/home.component';
// // @ts-ignore
import { HomebgComponent } from './home-bg/home.component';
import { HomefrComponent } from './home-fr/home.component';

const appRoutes: Routes = [
  {path: 'login',
  component: LoginComponent},
  {path: 'register',
  component: RegisterComponent},
  {path: 'welcome',
  component: WelcomeComponent},
  {path: 'library',
  component: LibraryComponent},
  {path: 'home',
  component: HomeComponent},
  {path: 'checkout',
  component: CheckoutComponent},
  {path: 'success',
  component: SuccessComponent},
  {path: 'authorWelcome',
  component: AuthorWelcomeComponent},
  {path: 'authorLibrary',
  component: AuthorLibraryComponent},
  {path: '',
  component: HomeComponent},
  {path: 'addItem',
  component: AddItemComponent},
  {path: 'contactUs',
  component: ContactUsComponent},
  {path: 'video',
  component: VideoComponent},
  {path: 'home-bg',
    component: HomebgComponent},
  {path: 'home-fr',
    component: HomefrComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    WelcomeComponent,
    LibraryComponent,
    CheckoutComponent,
    SuccessComponent,
    AuthorWelcomeComponent,
    AuthorLibraryComponent,
    AddItemComponent,
    ContactUsComponent,
    VideoComponent,
    HomebgComponent,
    HomefrComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes, {useHash: true}),
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
