package com.app.memento;

import org.springframework.stereotype.Component;

@Component
public class Originator {
    private String article;

    public void setArticle(String article) {
        System.out.println("Originator: Current version of Article\n" + article);
        this.article = article;
    }

    public Memento storeInMemento() {
        System.out.println("Originator: saving to memento");
        return new Memento(article);
    }

    public String restoreFromMemento(Memento memento) {
        article = memento.getArticle();
        System.out.println("Originator: restoring from memento previous article = " + article + System.lineSeparator());
        return article;
    }

}
