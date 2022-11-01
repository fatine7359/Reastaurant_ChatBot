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
  

  // options: {
  //   headers?: HttpHeaders | {[header: string]: string | string[]},
  //   observe?: 'body' | 'events' | 'response',
  //   params?: HttpParams|{[param: string]: string | number | boolean | ReadonlyArray<string | number | boolean>},
  //   reportProgress?: boolean,
  //   responseType?: 'arraybuffer'|'blob'|'json'|'text',
  //   withCredentials?: boolean,
  // }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
 }

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
