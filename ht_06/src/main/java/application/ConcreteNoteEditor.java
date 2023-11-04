package application;

import application.interfaces.NoteEditor;
import application.interfaces.NotesDatabaseContext;
import application.interfaces.NotesPresenter;
import domain.Note;

import java.util.Collection;
import java.util.Optional;

public class ConcreteNoteEditor implements NoteEditor {
    private final NotesDatabaseContext dbContext;
    private final NotesPresenter presenter;

    public ConcreteNoteEditor(NotesDatabaseContext dbContext,
                              NotesPresenter presenter) {
        this.dbContext = dbContext;
        this.presenter = presenter;
    }

    @Override
    public boolean add(Note item) {
        dbContext.getAll().add(item);
        return dbContext.saveChanges();
    }

    @Override
    public boolean edit(Note item) {
        dbContext.editNote(item);
        return dbContext.saveChanges();
    }

    @Override
    public boolean remove(Note item) {
        dbContext.getAll().remove(item);
        return dbContext.saveChanges();
    }

    @Override
    public Optional<Note> getById(Integer noteId) {
        for (Note note : dbContext.getAll()) {
            if (noteId == note.getId()) {
                return Optional.of(note);
            }
        }
        return Optional.empty();
    }

    @Override
    public Collection<Note> getAll() {
        return dbContext.getAll();
    }

    @Override
    public void printAll() {
        presenter.printAll(getAll());
    }

    @Override
    public void printNote(Note note) {
        presenter.printNote(note);
    }
}
