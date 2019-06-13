import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Apartment } from '../data/apartment';

@Injectable({
  providedIn: 'root',
})
export class ApartmentService {
  constructor(private http: HttpClient) {}

  getApartment(id: string): Observable<Apartment> {
    return this.http.get<Apartment>(`http://localhost:8080/apartment/${id}`);
  }

  getUniqueApartmentCompanies(): Observable<String[]> {
    return this.http.get<String[]>('http://localhost:8080/apartment/list');
  }

  createApartment(apartment: Apartment): Observable<Apartment> {
    return this.http.post<Apartment>('http://localhost:8080/apartment/create', apartment);
  }
}
