import { Component, OnInit } from '@angular/core';
import {ApartmentService} from "../service/apartment.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Apartment} from "../../data/apartment";

@Component({
  selector: 'app-apartment',
  templateUrl: './apartment.component.html',
  styleUrls: ['./apartment.component.css']
})
export class ApartmentComponent implements OnInit {
  public id: string;
  apartment: Apartment;

  constructor(private service: ApartmentService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.service.getApartment(this.id).subscribe(
      (apartment) => this.apartment = apartment
    );
    (err: any) => console.error(err);
  }

}
