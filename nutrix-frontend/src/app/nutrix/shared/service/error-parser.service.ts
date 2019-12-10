import { Injectable }        from "@angular/core";
import { TranslateService }  from "@ngx-translate/core";
import { HttpErrorResponse } from "@angular/common/http";
import { ErrorInfo }         from "../entity/system/error-info";
import { Observable }        from "rxjs";

@Injectable({ providedIn: 'root' })
export class ErrorParserService {

  private readonly TRANSLATE_PREFIX = "error-";

  constructor(private translateService: TranslateService) {
  }

  parse(errorResponse: HttpErrorResponse): Observable<string> {
    let error = errorResponse.error as ErrorInfo;
    let translateKey = error.code < 200 ? this.TRANSLATE_PREFIX + error.code : error.message;
    return new Observable<string>(observe => {
      this.translateService.get(translateKey).subscribe(
        tranlsate => {
          let translatedError: string = tranlsate ? tranlsate : error.message;
          console.log(translatedError);
          observe.next(translatedError);
        }
      )
    });
  }

}
