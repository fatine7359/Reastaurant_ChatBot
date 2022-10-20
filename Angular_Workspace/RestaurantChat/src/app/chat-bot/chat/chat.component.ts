import { Message } from './../../../models/Message';
import { Component, Input, OnInit } from '@angular/core';
import { faPaperPlane } from '@fortawesome/free-solid-svg-icons';
import {MatIconModule} from '@angular/material/icon';


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

  textInput:string = '';

  faPaperPlane = faPaperPlane;

  constructor() { }

  ngOnInit(): void {
  }

}
