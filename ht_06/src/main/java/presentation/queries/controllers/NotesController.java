package presentation.queries.controllers;

import application.interfaces.NoteEditor;
import domain.Note;

import java.util.Optional;

public class NotesController extends Controller {
    private final NoteEditor noteEditor;

    public NotesController(NoteEditor noteEditor) {
        this.noteEditor = noteEditor;
    }

    //TODO: \notes\all
    public void routeGetAll() {
        noteEditor.printAll();
    }

    public boolean routeGetNote(int noteId) {
        Optional<Note> item = noteEditor.getById(noteId);
        item.ifPresent(noteEditor::printNote);
        return item.isPresent();
    }

    public boolean routeAddNote(String title, String details) {
        return noteEditor.add(new Note(0, title, details));
    }

    public boolean routeEditNote(int noteId, String title, String details) {
        Optional<Note> item = noteEditor.getById(noteId);
        item.ifPresent(note -> {
            note.setTitle(title);
            note.setDetails(details);
            noteEditor.edit(note);
        });
        return item.isPresent();
    }

    public boolean routeDeleteNote(int noteId) {
        Optional<Note> item = noteEditor.getById(noteId);
        item.ifPresent(noteEditor::remove);
        return item.isPresent();
    }
}
