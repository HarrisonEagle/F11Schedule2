package com.example.f11schedule;

public class noteinf {

    public String title;
    public String content;

    noteinf(){


    }

    noteinf(String title,String content){
        this.title=title;
        this.content=content;


    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

