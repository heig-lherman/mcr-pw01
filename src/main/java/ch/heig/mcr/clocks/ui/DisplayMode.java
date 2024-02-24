package ch.heig.mcr.clocks.ui;

public enum DisplayMode {
    ROMAN("/images/cadran_chiffres_romains.jpg"),
    ARABIC("/images/cadran_chiffres_arabes.jpg"),
    DIGITAL("");
    private final String imagePath;

    DisplayMode(String imageName) {
        this.imagePath = imageName;
    }

    String getImagePath() {
        return imagePath;
    }
}
