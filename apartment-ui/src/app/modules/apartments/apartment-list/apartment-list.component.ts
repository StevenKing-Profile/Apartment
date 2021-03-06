import { Component, OnInit } from '@angular/core';
import { ApartmentService } from '../../../core/services/apartment.service';
import { Apartment } from '../../../core/data/apartment';

@Component({
  selector: 'app-apartment-list',
  templateUrl: './apartment-list.component.html',
  styleUrls: ['./apartment-list.component.scss'],
})
export class ApartmentListComponent implements OnInit {
  uniqueApartmentCompanyList: String[];

  apartment: Apartment;

  constructor(private service: ApartmentService) {}

  ngOnInit() {
    this.service.getUniqueApartmentCompanies().subscribe(apartmentList => {
      this.uniqueApartmentCompanyList = apartmentList;
    });
  }
}
