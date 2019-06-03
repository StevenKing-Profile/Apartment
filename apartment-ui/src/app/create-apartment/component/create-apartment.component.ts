import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, FormBuilder} from '@angular/forms';

import {CreateApartmentService} from "../service/create-apartment.service";
import {Apartment} from "../../data/apartment";
import {HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-create-apartment',
  templateUrl: './create-apartment.component.html',
  styleUrls: ['./create-apartment.component.css']
})
export class CreateApartmentComponent implements OnInit {

    private apartmentForm = new FormGroup({
      company: new FormControl(),
      name: new FormControl(),
      sqft: new FormControl(),
      price: new FormGroup({
        price: new FormControl()
      })
    });

  constructor(private formBuilder: FormBuilder, private service: CreateApartmentService) {
  }

  ngOnInit() {
    this.createForm();
  }

  onSubmit() {
    this.service.postForm(this.apartmentForm.value).subscribe(
      res => console.log(res)
    );
  }

  createForm() {
    this.apartmentForm = this.formBuilder.group({
      company: '',
      name: '',
      sqft: '',
      price: this.formBuilder.group({
        price: ''
      })
    })
  }
}
