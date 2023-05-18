  package com.example.demo.models;

public class HelloWorld {
    private String title;

    public HelloWorld() {}

    public HelloWorld(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "title='" + title + '\'' +
                '}';
    }
}
