import { Component, OnInit } from '@angular/core';

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
  messages = [{text: "Got any questions? I am happy to help.", owner: false, date: "17/10/2022"}, {text: "What do you want to know about the restaurant?", owner: false, date: "17/10/2022"}, {text: "What's on the menu?", owner: true, date: "17/10/2022"}, {text: "As appetizers: ", owner: false, date: "17/10/2022"}];

  constructor() { }

  ngOnInit(): void {
  }

}
