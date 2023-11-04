package infrastructure.persistance;

import application.interfaces.NotesDatabaseContext;
import database.NotesRecord;
import database.NotesDatabase;
import domain.Note;
import infrastructure.persistance.entityconfiguration.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class DatabaseContext extends DbContext implements NotesDatabaseContext {

    public Collection<Note> getAll() {
        Collection<Note> notes = new ArrayList<>();
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()) {
            notes.add(new Note(
                    record.getId(),
                    record.getTitle(),
                    record.getDetails()));
        }
        return notes;
    }

    @Override
    public boolean addNote(Note note) {
        return ((NotesDatabase)database).getNotesTable().addRecord(note);
    }

    @Override
    public boolean editNote(Note note) {
        return ((NotesDatabase)database).getNotesTable().editRecord(note);
    }

    @Override
    public boolean deleteNote(Note note) {
        return ((NotesDatabase)database).getNotesTable().deleteRecord(note);
    }

    public DatabaseContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }
}
