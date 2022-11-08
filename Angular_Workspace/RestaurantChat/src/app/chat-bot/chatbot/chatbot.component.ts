import { MessagingService } from './../services/messaging.service';
import { Component, OnInit } from '@angular/core';
import { Message } from 'src/models/Message';

@Component({
  selector: 'app-chatbot',
  templateUrl: './chatbot.component.html',
  styleUrls: ['./chatbot.component.css']
})
export class ChatbotComponent implements OnInit {

  title = 'angularChatBot';
  colorBackRight: string = '#008B8B';
  colorFontRight: string = '#ffffff';
  colorBackLeft: string = '#eeeeee';
  colorFontLeft: string = '#343a40';
  messages = [{text: "Got any questions? I am happy to help.", owner: false, date: "17/10/2022"}, {text: "What do you want to know about the restaurant?", owner: false, date: "17/10/2022"}];

  constructor( private service : MessagingService ) { }

  ngOnInit(): void {
  }

  getResponse($event: string){

    console.log($event);
    this.messages.push(new Message($event, "10/26/2022", true))
    this.messages?.push(this.service.sendMsg($event));

  }

}
