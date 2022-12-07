import { HttpClient, HttpClientModule, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError, Observable } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Message } from 'src/models/Message';

@Injectable({
  providedIn: 'root'
})
export class MessagingService {

  constructor( private http :HttpClient) { }

  sendMsg(text : string){

    let message : Message = new Message(text, "10/26/2022", true);
    let res : Message = new Message("", "10/26/2022", false);

    this.http.post<Message>("http://localhost:8080/chatbot/receive", message).subscribe(response=>{
      console.log(response);
      res.text = response.text;
      res.date = response.date;
      res.owner = response.owner;
    },
    error=>{
      console.log(error);
    });

    return res;
  }
}
