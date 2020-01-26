import { Injectable }                  from "@angular/core";
import { HttpClient }                  from "@angular/common/http";
import { environment }                 from "../../../../environments/environment";
import { BehaviorSubject, Observable } from "rxjs";
import { AccountShort }                from "../model/entity/account-short";

@Injectable({ providedIn: 'root' })
export class AccountService {

  private readonly url = `${environment.api.url}/account`;
  private currentAccount: BehaviorSubject<AccountShort>;

  constructor(private http: HttpClient) {
  }

  getCurrentShort(): Observable<AccountShort> {
    if (!this.currentAccount) {
      this.loadCurrentShort().subscribe(shortAccount => {
        this.currentAccount = new BehaviorSubject<AccountShort>(shortAccount);
      });
    }
    return this.currentAccount.asObservable();
  }

  loadCurrentShort(): Observable<AccountShort> {
    return this.http.get<AccountShort>(`${this.url}/current/short`);
  }

}
