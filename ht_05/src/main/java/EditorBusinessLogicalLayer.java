import java.util.Collection;
import java.util.Random;

public class EditorBusinessLogicalLayer implements BusinessLogicalLayer {
    private DatabaseAccess databaseAccess;

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void addModel(String name, Collection<Texture> textures) {
        databaseAccess.addEntity(new Model3D(name, textures));
    }

    @Override
    public void deleteModel(int i) {
        for (Model3D model : databaseAccess.getAllModels()) {
            if (model.getId() == i) {
                databaseAccess.removeEntity(model);
            }
        }
    }

    @Override
    public void addTexture(String name) {
        databaseAccess.addEntity(new Texture(name));
    }

    @Override
    public void deleteTexture(int i) {
        for (Texture texture : databaseAccess.getAllTextures()) {
            if (texture.getId() == i) {
                databaseAccess.removeEntity(texture);
            }
        }
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model: getAllModels()) {
            processRender(model);
        }
    }

    private Random random = new Random();
    private void processRender(Model3D model) {
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
