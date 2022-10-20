export class Message {
    text: string;
    date: string;
    owner: boolean;

    constructor(text: string, date: string, owner: boolean){

        this.text = text;
        this.date = date;
        this.owner = owner;

    }
}