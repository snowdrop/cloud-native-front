package me.snowdrop.cloudnative.front;

import java.util.List;


public interface NoteGateway {

    List<Note> all();

    Note add(Note note);

    Note update(Note note);

    void delete(long id);
}
