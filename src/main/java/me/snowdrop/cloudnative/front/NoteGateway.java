package me.snowdrop.cloudnative.front;

import java.util.List;


public interface NoteGateway {

    List<Note> all();

    Note add(Note note);

    void delete(int id);
}
