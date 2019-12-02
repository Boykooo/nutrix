import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.sass']
})
export class WelcomeComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

  auth() {
    let url = "https://accounts.google.com/o/oauth2/v2/auth?" +
      "client_id=1070270542749-5230c4odd2duh8rdlkh3ds6oudt3obk2.apps.googleusercontent.com" +
      "&access_type=offline&response_type=code" +
      "&redirect_uri=http%3A%2F%2Flocalhost%3A4200" +
      "&scope=openid%20email";
    // location.href = url;
    var newWindow = window.open(url, 'name', 'height=600,width=450');
    if (window.focus) {
      newWindow.focus();
    }
    // this.http.get(url)
    //   .subscribe(res => console.log(res), error => console.log(error));
  }

}
