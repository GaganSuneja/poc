import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-Home',
  templateUrl: './Home.component.html',
  styleUrls: ['./Home.component.css']
})
export class HomeComponent implements OnInit {
loadedfeature:string;
navigate(feature:string)
{
  this.loadedfeature=feature;
}
  constructor() { }

  ngOnInit() {
    console.log("admin called");
  }

}
