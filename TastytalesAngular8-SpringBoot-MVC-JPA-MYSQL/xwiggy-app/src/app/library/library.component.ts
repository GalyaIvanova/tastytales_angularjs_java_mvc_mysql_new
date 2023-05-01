import {ApplicationModule, Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {LibraryServiceService} from '../library-service.service';
import {AppComponent} from '../app.component';
import {count} from 'rxjs/operators';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {

  model: library[];
  values: Quantity[] = [];
  total: number;

  modalFavorites: favorites = {
    quantity1: 0,
    quantity2: 0,
    quantity3: 0
  };

  constructor(private http: HttpClient, private router: Router, private libraryService: LibraryServiceService) { }

  ngOnInit() {
    if (sessionStorage.getItem('userData') == null) {
      this.router.navigate(['login']);
    }
    this.getItems();
  }


  clearLocal() {
    sessionStorage.clear();
  }

  getItems(): void {
    this.libraryService.getItems().subscribe((men: any[]) => {
      this.model = men;
      for (let i = 0; i < this.model.length; i++) {
        this.values.push(new Quantity());
        this.values[i].quantity = 0;
      }
    });
  }


  getTotal(): void {
    console.log(this.values);
    const url = 'http://localhost:8080/favorites';
    this.modalFavorites.quantity1 = this.values[0].quantity;
    this.modalFavorites.quantity2 = this.values[1].quantity;
    this.modalFavorites.quantity3 = this.values[2].quantity;
    this.http.post<number>(url, this.values).subscribe(

      res => {
        // AppComponent.total=res;
        sessionStorage.setItem('total', res.toString());
        this.total = res;
      },
      err => {
        alert('Please select at least 1 item');
      }
    );

  }
}

export interface library {
  id: string;
  item: string;
  weight: number;
  quantity: number;
  url: string;
  formID: string;
  favoritesID: string;
}

export interface favorites {
  quantity1: number;
  quantity2: number;
  quantity3: number;
}

export class Quantity {
  quantity: number;
}
