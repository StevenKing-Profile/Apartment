import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";
import {Apartment} from "../../data/apartment";

@Injectable({
  providedIn: 'root'
})
export class ApartmentService {

  constructor(private httpClient: HttpClient) { }

  getApartment(id: string) : Observable<Apartment> {
    return this.httpClient.get<Apartment>('http://localhost:8080/apartment/' + id);
  }
}
