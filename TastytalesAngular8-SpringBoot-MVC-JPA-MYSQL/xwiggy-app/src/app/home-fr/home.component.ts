import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home-fr.component.html',
  styleUrls: ['./home-fr.component.css']
})
export class HomefrComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

}

