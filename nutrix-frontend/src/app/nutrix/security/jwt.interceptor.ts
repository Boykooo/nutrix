import { Injectable }                                           from "@angular/core";
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Observable }                                           from "rxjs";
import { TokenService }                                         from "./token.service";

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  private readonly TOKEN_HEADER = "at";

  constructor(private tokenService: TokenService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let token = this.tokenService.getAccessToken();
    if (token) {
      req = req.clone({
        headers: req.headers
          .set(this.TOKEN_HEADER, token)
      });
    }
    return next.handle(req);
  }

}
