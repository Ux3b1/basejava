package com.urise.webapp.model;

import java.util.List;

public class ListSection implements Section{
    public List<String> items;

    public ListSection(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public String getContent() {
        return null;
    }
}
