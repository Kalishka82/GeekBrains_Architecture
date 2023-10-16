package gb.ht01.store3d.inmemorymodel;

public interface ModelChanger {
    void notifyChange();
    void registerModelChanger(ModelChangeObserver o);
    void removeModelChanger(ModelChangeObserver o);
}
