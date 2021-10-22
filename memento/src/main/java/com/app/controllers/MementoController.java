package com.app.controllers;

import com.app.services.MementoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
@CrossOrigin("*")
public class MementoController {
    private final MementoService mementoService;

    public MementoController(MementoService mementoService) {
        this.mementoService = mementoService;
    }

    @PostMapping("/init")
    public void init(@RequestBody InitPayload payload) {
        System.out.println("IN INIT : ");
        mementoService.setSaveFiles(payload.saveFiles);
        mementoService.setCurrentArticle(payload.currentArticle);
        System.out.println("SERVICE current article = " + mementoService.getCurrentArticle());
        System.out.println("SERVICE files = " + mementoService.getSaveFiles());
    }

    @PostMapping("/save")
    public String saveMemento(@RequestBody String text) {
        System.out.println("SAVE : " + text);
        mementoService.saveArticle(text);
        return text;
    }

    @GetMapping("/go-back")
    public ResponseEntity<String> goBack() {
        System.out.println("GO BACK");
        return ResponseEntity.ok(mementoService.goBack());
    }

    @GetMapping("/go-forward")
    public ResponseEntity<String> goForward() {
        System.out.println("GO FORWARD");
        return ResponseEntity.ok(mementoService.goForward());
    }
}

class InitPayload {
    int saveFiles;
    int currentArticle;
}
