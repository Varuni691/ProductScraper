import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

public class ProductScraper {
    public static void main(String[] args) {
        // Public site for scraping practice
        String url = "https://books.toscrape.com/";

        try {
            // Connect and fetch the webpage
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                    .referrer("https://www.google.com/")
                    .timeout(15 * 1000)
                    .get();

            // Create CSV file
            FileWriter csvWriter = new FileWriter("products.csv");
            csvWriter.append("Product Name,Price,Rating\n");

            // Select all product blocks
            Elements products = doc.select("article.product_pod");

            for (Element product : products) {
                String name = product.select("h3 a").attr("title");
                String price = product.select("p.price_color").text();
                String rating = product.select("p.star-rating").attr("class").replace("star-rating", "").trim();

                if (!name.isEmpty() && !price.isEmpty()) {
                    csvWriter.append(String.format("\"%s\",\"%s\",\"%s\"\n",
                            name.replace(",", " "),
                            price.replace(",", ""),
                            rating.isEmpty() ? "N/A" : rating));
                }
            }

            csvWriter.flush();
            csvWriter.close();
            System.out.println("✅ Data extracted successfully and saved to products.csv!");

        } catch (IOException e) {
            System.out.println(" Error fetching data: " + e.getMessage());
        }
    }
}
