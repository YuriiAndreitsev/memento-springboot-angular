package com.app.memento;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class Handler {
    private final ArrayList<Memento> savedArticles = new ArrayList<>();

    public void addMemento(Memento m) {
        savedArticles.add(m);
    }

    public Memento getMemento(int index) {
        return savedArticles.get(index);
    }
}
