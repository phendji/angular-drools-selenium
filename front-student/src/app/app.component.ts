import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  public formGroupStudent;

  constructor(
    private http: HttpClient
  ) {
    this.formGroupStudent = new FormGroup({
      firstname: new FormControl(),
      age: new FormControl()
    });
  }

  doAction() {
    const httpOptions = new HttpHeaders({'Access-Control-Allow-Origin': '*'});
    const options = {
      headers: httpOptions
    };

    console.log(this.formGroupStudent.value);
    //  return this.HttpService.post(this.servers.BOA.url + `${USERS_MEMO_URL}`, body);
    // const endPoint = 'http://localhost:8580/api-moteur-regles/v1/executerRegles';
    const endPoint = 'http://localhost:8680/api-backend/v1/user';
    this.http.post(endPoint, this.formGroupStudent.value, options)
                  .subscribe(res => {
                    console.log('res : ', res);
                  });
  }
}
