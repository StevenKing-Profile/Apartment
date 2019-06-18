import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

import { ApartmentService } from '../../../core/services/apartment.service';

@Component({
  selector: 'app-create-apartment',
  templateUrl: './create-apartment.component.html',
  styleUrls: ['./create-apartment.component.scss'],
})
export class CreateApartmentComponent implements OnInit {
  constructor(private formBuilder: FormBuilder, private service: ApartmentService) {}

  private apartmentForm = new FormGroup({
    apartmentKey: new FormGroup({
      company: new FormControl(),
      name: new FormControl(),
    }),
    sqFt: new FormControl(),
    price: new FormControl(),
  });

  private addressForm = new FormGroup({
    street: new FormControl(),
    city: new FormControl(),
    state: new FormControl(),
    zipCode: new FormControl(),
  });

  ngOnInit() {
    this.createApartmentForm();
    this.createAddressForm();
  }

  createApartmentForm() {
    this.apartmentForm = this.formBuilder.group({
      apartmentKey: this.formBuilder.group({
        company: '',
        name: '',
      }),
      sqFt: '',
      price: '',
    });
  }

  createAddressForm() {
    this.addressForm = this.formBuilder.group({
      street: '',
      city: '',
      state: '',
      zipCode: '',
    });
  }

  onSubmit() {
    this.service.createApartment(this.apartmentForm.value).subscribe(res => console.log(res));
  }
}
