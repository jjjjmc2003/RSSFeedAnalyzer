package Week3;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class NewsItem {
    private String title;
    private String description;

    public NewsItem(Node node) {
        // Check if the node is not null and is of type ELEMENT_NODE
        if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
            // Cast the node to an Element
            Element eElement = (Element) node;

            // Get all the "title" elements from the node
            NodeList titleElements = eElement.getElementsByTagName("title");

            // If there is at least one "title" element, get its text content and assign it to the title field
            if (titleElements.getLength() > 0) {
                this.title = titleElements.item(0).getTextContent();
            }

            // Get all the "description" elements from the node
            NodeList descriptionElements = eElement.getElementsByTagName("description");

            // If there is at least one "description" element, get its text content and assign it to the description field
            if (descriptionElements.getLength() > 0) {
                this.description = descriptionElements.item(0).getTextContent();
            }
        }
    }

    public void displayDetails() {
        if (title == null) {
            System.out.println("Title: None");
        } else {
            System.out.println("Title: " + title);
        }
        if (description == null) {
            System.out.println("Description: None");
        } else {
            System.out.println("Description Length: " + description +'\n' + description.length());
        }
    }
}
