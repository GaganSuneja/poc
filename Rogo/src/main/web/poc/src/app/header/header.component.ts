import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
@Output() featureloaded=new EventEmitter<String>();
onSelect(feature:string)
{
  this.featureloaded.emit(feature);
}
  constructor() { }

  ngOnInit() {
  }

}
