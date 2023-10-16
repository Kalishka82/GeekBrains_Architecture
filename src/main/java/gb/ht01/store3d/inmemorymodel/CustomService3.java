package gb.ht01.store3d.inmemorymodel;

public class CustomService3 implements ModelChangeObserver{

    @Override
    public void applyUpdateModel() {
        //TODO: Реагирует на изменение в хранилице моделей ...
        System.out.println("CustomService3 reacted on model changes");
    }
}
