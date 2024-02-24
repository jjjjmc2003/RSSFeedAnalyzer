package Week3;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsItemWithImage extends NewsItem {
    private String imageSource;

    public NewsItemWithImage(Node node, String title, String description, String imageSource) {
        super(node);
        this.imageSource = imageSource != null ? imageSource : "None";
    }

    public void showImage() {
        if (imageSource == null) {
            System.out.println("Image: None");
        } else {
            System.out.println("Image: " + imageSource);
        }
    }
}