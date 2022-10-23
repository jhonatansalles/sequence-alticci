import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class SequenceAlticciService {

  constructor(private http: HttpClient) {
  }

  public getAlticciSequence(indice: number): Observable<number> {
    return this.http.get<number>(environment.apiURL + indice);
  }
}
