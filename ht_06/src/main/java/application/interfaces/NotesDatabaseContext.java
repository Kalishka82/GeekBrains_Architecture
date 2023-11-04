package application.interfaces;

import domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {
    Collection<Note> getAll();
    boolean addNote(Note note);
    boolean editNote(Note note);
    boolean deleteNote(Note note);
    boolean saveChanges();
}
