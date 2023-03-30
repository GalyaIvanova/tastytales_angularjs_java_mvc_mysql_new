import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './video.component.html',
  styleUrls: ['./home.component.css']
})
export class VideoComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

}

