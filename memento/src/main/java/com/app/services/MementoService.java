package com.app.services;

import com.app.memento.Handler;
import com.app.memento.Originator;
import org.springframework.stereotype.Service;

@Service
public class MementoService {
    private final Originator originator;
    private final Handler handler;
    private int saveFiles = 0, currentArticle = 0;

    public int getSaveFiles() {
        return saveFiles;
    }

    public void setSaveFiles(int saveFiles) {
        this.saveFiles = saveFiles;
    }

    public int getCurrentArticle() {
        return currentArticle;
    }

    public void setCurrentArticle(int currentArticle) {
        this.currentArticle = currentArticle;
    }

    public MementoService(Originator originator, Handler handler) {
        this.originator = originator;
        this.handler = handler;
    }

    public void saveArticle(String text) {
        originator.setArticle(text);
        handler.addMemento(originator.storeInMemento());
        saveFiles++;
        currentArticle++;
        System.out.println("Saving : "+text);
    }

    public String goBack() {
        if (currentArticle > 1) {
            currentArticle--;
            return originator.restoreFromMemento(handler.getMemento(currentArticle));
        } else {
            return originator.restoreFromMemento(handler.getMemento(--currentArticle));
        }
    }

    public String goForward() {
        if ((saveFiles - 1) > currentArticle) {
            currentArticle++;
        }
        return originator.restoreFromMemento(handler.getMemento(currentArticle));
    }
}
