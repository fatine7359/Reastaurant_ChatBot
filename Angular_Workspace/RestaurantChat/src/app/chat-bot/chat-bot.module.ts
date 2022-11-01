import { ChatComponent } from './chat/chat.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MessageComponent } from './message/message.component';
import { ChatbotComponent } from './chatbot/chatbot.component';
import { HeaderComponent } from './header/header.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    MessageComponent,
    ChatComponent,
    ChatbotComponent,
    HeaderComponent
  ],
  exports: [
    ChatbotComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
  ]
})
export class ChatBotModule { }
