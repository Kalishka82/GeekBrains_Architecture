import java.util.Collection;

public interface UILayer {
    void openProject(String fileName);
    void showProjectSetting();
    void saveProject();
    void printAllModels();
    void printAllTextures();
    void renderAll();
    void renderModel(int i);
    void addModel(String name, Collection<Texture> textures);
    void deleteModel(int i);
    void addTexture(String name);
    void deleteTexture(int i);
}
