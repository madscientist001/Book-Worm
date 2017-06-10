package grimreaper.bookworm;

/**
 * Created by Kanchan on 11-06-2017.
 */
public class DrawerDataModel{

    String name;
    int icon;

    public DrawerDataModel(String name, int icon) {
        this.name=name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public int getIcon(){
        return icon;
    }
}
