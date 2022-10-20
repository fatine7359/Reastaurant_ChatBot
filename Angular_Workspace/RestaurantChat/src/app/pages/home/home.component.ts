import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ChatComponent } from 'src/app/chat-bot/chat/chat.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  // @Output() btnClicked = new EventEmitter<boolean>();
  toggle = false;

  clickedBtn(){

    this.toggle = true;

  }


  constructor() { }

  ngOnInit(): void {
  }

}
