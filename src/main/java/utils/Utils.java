package utils;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author Karthikeyan on 26/05/20
 */

public class Utils {
    public static void main(String[] args) {
        Utils utils = new Utils();
        new Thread(() -> utils.rupees(Currencies.Afghan_Afghani, Currencies.Indian_Rupee, 99d)).start();
        new Thread(utils::goldRate).start();
    }

    public void goldRate() {
        {
            Document doc;
            try {
                doc = Jsoup.connect("https://www.google.com/search?q=gold+rate").userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36").ignoreHttpErrors(true).timeout(0).get();
                Elements links = doc.select("g-card-section div");
                for (int i = 0; i < 2; i++) {
                    System.out.print(links.get(i).text() + " ");
                }
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void rupees(Currencies from, Currencies to, Double amount) {

        Document doc;
        try {
            doc = Jsoup.connect("https://www.google.com/search?q=" + from.name().replace(" ", "+") + "+to+" + to.name().replace(" ", "+")).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36").ignoreHttpErrors(true).timeout(0).get();
            Elements links = doc.select("#knowledge-currency__updatable-data-column");
            String text = links.get(0).getElementsByAttribute("data-exchange-rate").text();
            String valueText = text.split("equals")[1].split(" ")[1];
            double value = Double.parseDouble(valueText) * amount;
            System.out.println(text);
            System.out.println(amount + " " + from + " = " + value + " " + to);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}