import java.util.Collection;

public interface BusinessLogicalLayer {
    Collection<Model3D> getAllModels();
    Collection<Texture> getAllTextures();

    void addModel(String name, Collection<Texture> textures);
    void deleteModel(int i);
    void addTexture(String name);
    void deleteTexture(int i);

    void renderModel(Model3D model);
    void renderAllModels();
}
