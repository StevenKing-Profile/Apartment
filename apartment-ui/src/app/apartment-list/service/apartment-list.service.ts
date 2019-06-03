import {Injectable} from '@angular/core';
import {Apartment} from "../../data/apartment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ApartmentListService {

  constructor(private http: HttpClient) {}

  getApartmentList() : Observable<Apartment[]> {
    return this.http.get<Apartment[]>('http://localhost:8080/apartment/list');
  }
}
