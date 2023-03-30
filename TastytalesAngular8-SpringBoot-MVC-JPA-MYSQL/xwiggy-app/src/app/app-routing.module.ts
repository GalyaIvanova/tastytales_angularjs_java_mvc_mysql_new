import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StarRatingComponent} from "./video/star-rating.component";

const routes: Routes = [];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    declarations: [
        StarRatingComponent
    ],
    exports: [RouterModule, StarRatingComponent]
})
export class AppRoutingModule { }
