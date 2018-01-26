package me.snowdrop.cloudnative.front;

import java.util.List;


public interface NoteGateway {

    List<Note> allNotes();

    Note addNote(Note note);
}
