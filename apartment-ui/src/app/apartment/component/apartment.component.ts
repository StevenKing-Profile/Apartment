import { Component, OnInit } from '@angular/core'
import { ActivatedRoute } from '@angular/router'
import { ApartmentService } from '../service/apartment.service'
import { Apartment } from '../../data/apartment'

@Component({
  selector: 'app-apartment',
  templateUrl: './apartment.component.html',
  styleUrls: ['./apartment.component.css'],
})
export class ApartmentComponent implements OnInit {
  public id: string

  private apartment: Apartment

  private service: ApartmentService

  private route: ActivatedRoute

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id')
    ApartmentService.getApartment(this.id).subscribe(apartment => {
      this.apartment = apartment
    })
  }
}
