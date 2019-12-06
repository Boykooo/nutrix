import { Injectable }  from "@angular/core";
import { TokenHolder } from "./entity/token-holder";

@Injectable({ providedIn: 'root' })
export class TokenService {

  hasValidToken(): boolean {
    return false;
  }

  save(th: TokenHolder) {
    console.log(th);
  }

}
