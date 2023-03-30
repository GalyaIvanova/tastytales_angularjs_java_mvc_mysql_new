import { Component, OnInit } from '@angular/core';
import {favorites, library, Quantity} from "../library/library.component";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {LibraryServiceService} from "../library-service.service";
import { DomSanitizer } from '@angular/platform-browser';


@Component({
  selector: 'app-author-library',
  templateUrl: './author-library.component.html',
  styleUrls: ['./author-library.component.css']
})
export class AuthorLibraryComponent implements OnInit {

  model:library[];

  modalFavorites:favorites={
    quantity1:0,
    quantity2:0,
    quantity3:0
  };

  values:Quantity[] = [];

  constructor(private http:HttpClient, private router:Router,private libraryService:LibraryServiceService,
              public _DomSanitizationService: DomSanitizer ) { }

  ngOnInit() {
    if (sessionStorage.getItem("userData") == null) {
      this.router.navigate(['login']);
    }
    this.getItems();
  }

  clearLocal(){
    sessionStorage.clear();
  }

  getItems():void{
    this.libraryService.getItems().subscribe((men: any[]) => {
      this.model = men;
      for (let i=0;i<this.model.length;i++){
        this.values.push(new Quantity());
        this.values[i].quantity=0;
      }
    });
  }

  getTotal():void{
    let url = "http://localhost:8080/addToFavorites";
    this.modalFavorites.quantity1=this.values[0].quantity;
    this.modalFavorites.quantity2=this.values[1].quantity;
    this.modalFavorites.quantity3=this.values[2].quantity;
    this.http.post<number>(url,this.values).subscribe(
      res=>{
        this.ngOnInit();
      },
      err=>{
        alert("Error adding items to favorites");
      }
    )

  }
}

