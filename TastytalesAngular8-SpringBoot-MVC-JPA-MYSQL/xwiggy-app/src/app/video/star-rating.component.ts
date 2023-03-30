import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.css']
})
export class StarRatingComponent {
  @Output() rated: EventEmitter<number> = new EventEmitter<number>();

  rate(value: number) {
    this.rated.emit(value);
  }

  onRated(value: number) {
    console.log(value); // replace with your own logic
  }
  onRatingChanged(rating: number) {
    // Do something with the rating (e.g. update a database, display a message)
    console.log('Selected rating: ' + rating);
  }
}
