import java.util.ArrayList;
import java.util.Collection;

public class Editor3D implements UILayer {
    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;
    private DatabaseAccess databaseAccess;
    private Database database;

    /**
     * Полностью пересобираем внутренние компоненты системы (новый проект)
     */
    private void initialize() {
        database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);
    }

    @Override
    public void openProject(String fileName) {
        projectFile = new ProjectFile(fileName);
        initialize();
    }
    
    @Override
    public void saveProject() {
        System.out.println("Changes have been changed successfully");
        database.save();
    }
    
    @Override
    public void showProjectSetting() {
        // Предусловие
        checkProjectFile();

        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("fileName: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %b\n", projectFile.isSetting3());
        System.out.println("******************");
    }

    @Override
    public void printAllModels() {
        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(models.get(i));
            for (Texture texture: models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }
    }

    @Override
    public void printAllTextures() {
        // Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>)businessLogicalLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {
        // Предусловие
        checkProjectFile();

        System.out.println("Please, wait...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Operation was done in %d ms.\n", endTime);
    }

    @Override
    public void renderModel(int i) {
        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1)
            throw new RuntimeException("Model number isn't correct");
        System.out.println("Please, wait...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Operation was done in %d ms.\n", endTime);
    }

    @Override
    public void addModel(String name, Collection<Texture> textures) {
        // Предусловие
        checkProjectFile();
        businessLogicalLayer.addModel(name, textures);
    }

    @Override
    public void deleteModel(int i) {
        // Предусловие
        checkProjectFile();
        businessLogicalLayer.deleteModel(i);
    }

    @Override
    public void addTexture(String name) {
        // Предусловие
        checkProjectFile();
        businessLogicalLayer.addTexture(name);
    }

    @Override
    public void deleteTexture(int i) {
        // Предусловие
        checkProjectFile();
        businessLogicalLayer.deleteTexture(i);
    }

    private void checkProjectFile(){
        if (projectFile == null)
            throw new RuntimeException("Project file isn't determined");
    }
}
