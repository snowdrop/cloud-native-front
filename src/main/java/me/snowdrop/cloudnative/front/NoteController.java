package me.snowdrop.cloudnative.front;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("note")
public class NoteController {

    private final NoteGateway noteGateway;

    public NoteController(NoteGateway noteGateway) {
        this.noteGateway = noteGateway;
    }

    @GetMapping
    public List<Note> allNotes() {
        return noteGateway.allNotes();
    }
}
