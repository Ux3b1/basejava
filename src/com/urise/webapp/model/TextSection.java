package com.urise.webapp.model;

public class TextSection implements Section{
    public String content;

    public String getContent() {
        return content;
    }

    public TextSection(String content) {
        this.content = content;
    }
}
