package gb.ht01.store3d.inmemorymodel;

import gb.ht01.store3d.modelelements.*;

import java.util.ArrayList;
import java.util.Collection;

public class ModelStore implements ModelChanger {

    //region Public Methods

    public void addPoligonalModel(PoligonalModel model) {
        poligonalModels.add(model);
        this.notifyChange();
    }

    public void removePoligonaModel(PoligonalModel model) {
        poligonalModels.remove(model);
        this.notifyChange();
    }

    public void addScene(Scene scene) {
        scenes.add(scene);
        this.notifyChange();
    }

    public void removeScene(Scene scene) {
        scenes.remove(scene);
        this.notifyChange();
    }

    public Scene getScene(int id) {
        for (Scene scene : scenes) {
            if (scene.getId() == id) {
                return scene;
            }
        }
        return null;
    }

    public void addCamera(Camera camera) {
        cameras.add(camera);
        this.notifyChange();
    }

    public void removeCamera(Camera camera) {
        cameras.remove(camera);
        this.notifyChange();
    }

    public void addFlash(Flash flash) {
        flashes.add(flash);
        this.notifyChange();
    }

    public void removeFlash(Flash flash) {
        flashes.remove(flash);
        this.notifyChange();
    }

    /**
     * Нотифицирует о событии
     */
    @Override
    public void notifyChange() {
        for (ModelChangeObserver observer: changeObservers) {
            observer.applyUpdateModel();
        }
    }

    @Override
    public void registerModelChanger(ModelChangeObserver o) {
        changeObservers.add(o);
    }

    @Override
    public void removeModelChanger(ModelChangeObserver o) {
        changeObservers.remove(o);
    }
    //endregion

    //region Public Properties

    public Collection<PoligonalModel> getPoligonalModels() {
        return poligonalModels;
    }

    public Collection<Scene> getScenes() {
        return scenes;
    }

    public Collection<Flash> getFlashes() {
        return flashes;
    }

    public Collection<Camera> getCameras() {
        return cameras;
    }

    //endregion

    //region Private Fields
    private Collection<PoligonalModel> poligonalModels = new ArrayList<>();
    private Collection<Scene> scenes = new ArrayList<>();
    private Collection<Flash> flashes = new ArrayList<>();
    private Collection<Camera> cameras = new ArrayList<>();
    private Collection<ModelChangeObserver> changeObservers = new ArrayList<>();
    //endregion
}
