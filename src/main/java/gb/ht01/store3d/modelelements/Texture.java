package gb.ht01.store3d.modelelements;

public class Texture {

    //region Constructors
    public Texture(String texture) {
        this.texture = texture;
    }
    //endregion

    //region Public Properies
    public int getId() {
        return id;
    }

    public String getTexture() {
        return texture;
    }
    //endregion

    //region Private Fields
    private int id;
    private String texture;
    //endregion
}
