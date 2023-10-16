package gb.ht01.store3d;

import gb.ht01.store3d.inmemorymodel.CustomService1;
import gb.ht01.store3d.inmemorymodel.CustomService2;
import gb.ht01.store3d.inmemorymodel.CustomService3;
import gb.ht01.store3d.inmemorymodel.ModelStore;
import gb.ht01.store3d.modelelements.*;

public class Program {
    public static void main(String[] args) {

        CustomService1 observer1 = new CustomService1();
        CustomService2 observer2 = new CustomService2();
        CustomService3 observer3 = new CustomService3();

        ModelStore modelStore = new ModelStore();
        modelStore.registerModelChanger(observer1);
        modelStore.registerModelChanger(observer2);
        modelStore.registerModelChanger(observer3);

        modelStore.addCamera(new Camera(new Point3D(5, 1, -6), new Angle3D(30, 30, 90)));
        modelStore.addFlash(new Flash(new Point3D(1, 1, 1), new Angle3D(90, 90, 90)));
    }
}
