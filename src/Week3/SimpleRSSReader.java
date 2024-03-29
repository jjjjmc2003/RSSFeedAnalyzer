package Week3;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class SimpleRSSReader {

    public static void main(String[] args) {
        try {
// Open a connection to the RSS feed
            URL url = new URL("https://feeds.bbci.co.uk/news/rss.xml"); // BBC News RSS feed
            HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();

// Set up to parse the XML from the RSS feed
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
// Obtain and parse the input stream from the connection
            InputStream in = httpcon.getInputStream();
            Document doc = dBuilder.parse(in);
// Get all <item> elements from the Document
            NodeList nList = doc.getElementsByTagName("item");
//Your task: Iterate over each item in the NodeList
            //TODO 0: COMMENT THE FOLLOWING LINE
            //for (int i = 0; i < 4; i++) {
                //TODO 1 : UNCOMMENT THE FOLLOWING LINE and replace the ? with the correct values
                for (int i = 0 ; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                // Check if the current node is an Element (since NodeList can contain various types of nodes)
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
// Extract the title from the current item
                    String title = eElement.getElementsByTagName("title").item(0).getTextContent();
// Extract the description from the current item
                    String description = eElement.getElementsByTagName("description").item(0).getTextContent();

//TODO 2: DISPLAYS TITLE DESCRIPTION AND DESCRIPTION LENGTH ENCAPSULATION IS COOL
                    NewsItem newsItem = new NewsItem(node);

                    newsItem.displayDetails();

                    NewsItemWithImage newsItemWithImage = new NewsItemWithImage(node, title, description, null);

                    newsItemWithImage.showImage();





//TODO 4: Maybe --ADD YOUR OWN CALCS HERE
                    String input = description;
                    String[] words = input.split("\\s+");
                    HashSet<String> original = new HashSet<>();
                    HashSet<String> duplicates = new HashSet<>();

                    for (String word : words) {
                        if (!original.add(word)) {
                            duplicates.add(word);
                        }
                    }

                    System.out.println("Duplicate word(s):");
                    for (String duplicate_word : duplicates) {
                        System.out.println(duplicate_word);
                    }




//
//TODO 5: DISPLAY A LINE BREAK ie: "-----"
                    System.out.println("------------------");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading RSS feed: " + e.getMessage());
        }
    }
}