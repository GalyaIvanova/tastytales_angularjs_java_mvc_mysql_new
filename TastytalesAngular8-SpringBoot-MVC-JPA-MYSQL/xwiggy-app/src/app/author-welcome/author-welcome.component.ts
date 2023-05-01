import { Component, OnInit } from '@angular/core';
import {User} from "../app.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-author-welcome',
  templateUrl: './author-welcome.component.html',
  styleUrls: ['./author-welcome.component.css']
})
export class AuthorWelcomeComponent implements OnInit {

  modelAuthor: User = {
    username:'',
    password:'',
    email:'',
    phone:0,
    firstname:'',
    lastname:'',
    address:'',
    author:null
  };

  constructor(private router:Router) { }

  ngOnInit() {
    if (sessionStorage.getItem("userData")==null) {
      this.router.navigate(['login']);
    }

    let userData = JSON.parse(sessionStorage.getItem('userData'));
    console.log(userData);
    Object.assign(this.modelAuthor,userData);
  }


  clearLocal(){
    sessionStorage.clear();
  }

}
