import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApartmentService } from '../../../core/services/apartment.service';
import { Apartment } from '../../../core/data/apartment';

@Component({
  selector: 'app-apartment',
  templateUrl: './apartment.component.html',
  styleUrls: ['./apartment.component.scss'],
})
export class ApartmentComponent implements OnInit {
  public id: string;

  private apartment: Apartment;

  constructor(private service: ApartmentService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.service.getApartment(this.id).subscribe(apartment => {
      this.apartment = apartment;
    });
  }
}
