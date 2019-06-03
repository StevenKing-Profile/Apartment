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
    company: new FormControl(),
    name: new FormControl(),
    sqft: new FormControl(),
    price: new FormGroup({
      price: new FormControl(),
    }),
  });

  ngOnInit() {
    this.createForm();
  }

  createForm() {
    this.apartmentForm = this.formBuilder.group({
      company: '',
      name: '',
      sqft: '',
      price: this.formBuilder.group({
        price: '',
      }),
    });
  }

  onSubmit() {
    this.service.createApartment(this.apartmentForm.value).subscribe(res => console.log(res));
  }
}
