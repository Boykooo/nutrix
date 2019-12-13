import { Injectable }             from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { environment }            from "../../../../environments/environment";
import { Observable }             from "rxjs";

@Injectable({ providedIn: 'root' })
export class AccountService {

  private readonly url = `${environment.api.url}/account`;

  constructor(private http: HttpClient) {
  }

  updateName(name: string): Observable<void> {
    return this.http.put<void>(`${this.url}`, null, {
      params: new HttpParams()
        .set('name', name)
    });
  }

}
