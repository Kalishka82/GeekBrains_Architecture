import application.interfaces.NotesDatabaseContext;
import database.NotesDatabase;
import application.ConcreteNoteEditor;
import application.interfaces.NoteEditor;
import infrastructure.persistance.Database;
import infrastructure.persistance.DatabaseContext;
import presentation.queries.controllers.NotesController;
import presentation.queries.views.NotesConsolePresenter;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Database database = new NotesDatabase();
        NotesDatabaseContext context = new DatabaseContext(database);
        NotesConsolePresenter notesConsolePresenter = new NotesConsolePresenter();
        NoteEditor noteEditor = new ConcreteNoteEditor(context, notesConsolePresenter);

        NotesController notesController = new NotesController(noteEditor);

        notesController.routeGetAll();

        Scanner scanner = new Scanner(System.in);
        boolean f = true;
        while (f) {
            System.out.println("*** MY NOTES ***");
            System.out.println("================");
            System.out.println("1. All notes");
            System.out.println("2. Add note");
            System.out.println("3. Edit note");
            System.out.println("4. Delete note");
            System.out.println("0. EXIT");
            System.out.print("Please, make the choice: ");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 1:
                            notesController.routeGetAll();
                            break;
                        case 2:
                            System.out.println("Input a title: ");
                            String title = scanner.nextLine();
                            System.out.println("Input details");
                            String details = scanner.nextLine();
                            System.out.println(notesController.routeAddNote(title, details) ?
                                    "New note added successfully!" : "New note not added");
                            break;
                        case 3:
                            System.out.println("Input noteId: ");
                            if (scanner.hasNextInt()) {
                                int noteId = scanner.nextInt();
                                scanner.nextLine();
                                if (notesController.routeGetNote(noteId)) {
                                    System.out.println("Input a new title: ");
                                    String newTitle = scanner.nextLine();
                                    System.out.println("Input new details: ");
                                    String newDetails = scanner.nextLine();
                                    System.out.println(notesController.routeEditNote(noteId, newTitle, newDetails) ?
                                            "New note edited successfully!" : "noteId isn't correct");
                                } else {
                                    System.out.println("noteId isn't correct");
                                }
                            } else {
                                System.out.println("noteId isn't correct");
                            }
                            break;
                        case 4:
                            System.out.println("Input noteId: ");
                            if (scanner.hasNextInt()) {
                                int noteId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println(notesController.routeDeleteNote(noteId) ?
                                        "New note delited successfully!" : "noteId isn't correct");
                            } else {
                                System.out.println("noteId isn't correct");
                            }
                            break;
                        case 0:
                            System.out.println("CLOSING THE APP...PLEASE, WAIT...");
                            f = false;
                            break;
                        default:
                            System.out.println("Please, make the choice: ");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Please, make your choice: ");
                scanner.nextLine();
            }
        }
    }
}
