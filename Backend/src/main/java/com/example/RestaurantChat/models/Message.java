package com.example.RestaurantChat.models;

public class Message {
    private String text;
    private String date;
    private Boolean owner;

    private String language;

    public Message() {
    }

    public Message(String text, String date, Boolean owner) {
        this.text = text;
        this.date = date;
        this.owner = owner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getOwner() {
        return owner;
    }

    public void setOwner(Boolean owner) {
        this.owner = owner;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
