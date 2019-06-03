import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Apartment} from "../../data/apartment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CreateApartmentService {
  constructor(private http: HttpClient) { }

  postForm(apartment: Apartment): Observable<Apartment> {
    return this.http.post<Apartment>('http://localhost:8080/apartment/create', apartment);
  }
}
