import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home-bg.component.html',
  styleUrls: ['./home-bg.component.css']
})
export class HomebgComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

}

