package me.snowdrop.cloudnative.front;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<Note> all() {
        return noteGateway.all();
    }

    @PutMapping
    public Note add(@RequestBody Note note) {
        return noteGateway.add(note);
    }

    @DeleteMapping("/{id}")
    public DefaultResult delete(@PathVariable("id") long id) {
        noteGateway.delete(id);

        return DefaultResult.INSTANCE;
    }

    @PostMapping("/{id}")
    public Note update(@PathVariable("id") long id, @RequestBody Note note) {
        note.setId(id);
        return noteGateway.update(note);
    }

    private static class DefaultResult {

        private final String result = "OK";

        public String getResult() {
            return result;
        }

        private static DefaultResult INSTANCE = new DefaultResult();

        private DefaultResult() {}
    }
}
