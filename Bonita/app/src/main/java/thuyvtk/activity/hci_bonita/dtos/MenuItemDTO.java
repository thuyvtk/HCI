package thuyvtk.activity.hci_bonita.dtos;

import java.io.Serializable;

public class MenuItemDTO implements Serializable {
    private String title;
    private int image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public MenuItemDTO(String title, int image) {
        this.title = title;
        this.image = image;
    }
}
