import { MessagingService } from './../services/messaging.service';
import { Message } from './../../../models/Message';
import { Component, Input, OnInit, EventEmitter, Output } from '@angular/core';
import { faPaperPlane } from '@fortawesome/free-solid-svg-icons';
import {MatIconModule} from '@angular/material/icon';
import { text } from '@fortawesome/fontawesome-svg-core';


@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  @Input() messages?: Message[];
  @Input('colorBackRight') colorBackRight?: string;
  @Input('colorFontRight') colorFontRight?: string;
  @Input('colorBackLeft') colorBackLeft?: string;
  @Input('colorFontLeft') colorFontLeft?: string;

  @Output() msgSent = new EventEmitter<string>();

  textInput:string = '';

  faPaperPlane = faPaperPlane;

  constructor(private service : MessagingService) { }

  ngOnInit(): void {
  }

  sendMsg(){
    this.msgSent.emit(this.textInput);
    this.textInput = '';
    // const el = document.getElementById('list-messages');
    // // id of the chat container ---------- ^^^
    // if (el) {
    //   el.scrollTop = el.scrollHeight - 10;
    // }
    // console.log(this.textInput);
    // this.messages?.push(this.service.sendMsg(this.textInput));
  }

 

}
