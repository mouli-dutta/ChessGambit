package moulichess.a8queens.spinner;

public class SpinnerItems {
    private final int imageResource;
    private final String imageText;

    public SpinnerItems(int imageResource, String imageText) {
        this.imageResource = imageResource;
        this.imageText = imageText;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getImageText() {
        return imageText;
    }
}
