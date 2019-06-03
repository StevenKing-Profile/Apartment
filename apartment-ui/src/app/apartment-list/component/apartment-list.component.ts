import {Component, OnInit} from '@angular/core';
import {ApartmentListService} from "../service/apartment-list.service";
import {Observable, Subscription} from "rxjs";
import {Apartment} from "../../data/apartment";

@Component({
  selector: 'apartment-list',
  templateUrl: './apartment-list.component.html',
  styleUrls: ['./apartment-list.component.css']
})
export class ApartmentListComponent implements OnInit {

  apartmentList: Apartment[];

  constructor(private service: ApartmentListService ) { }

  ngOnInit() {
    this.service.getApartmentList().subscribe(apartmentList => this.apartmentList = apartmentList);
  }

}
