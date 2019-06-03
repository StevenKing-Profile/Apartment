import { Injectable } from '@angular/core'
import { Observable } from 'rxjs'
import { HttpClient } from '@angular/common/http'
// eslint-disable-next-line import/no-unresolved
import { Apartment } from '../../data/apartment'

@Injectable({
  providedIn: 'root',
})
export class ApartmentService {
  private static httpClient: HttpClient

  static getApartment(id: string): Observable<Apartment> {
    return this.httpClient.get<Apartment>(`http://localhost:8080/apartment/${id}`)
  }
}
