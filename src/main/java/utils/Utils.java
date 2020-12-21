package utils;


import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import utils.enums.Currencies;
import utils.enums.PetrolCities;
import utils.responses.PetrolLists;

import java.io.IOException;

/**
 * @author Karthikeyan on 26/05/20
 */

public class Utils {
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36";

    public static void main(String[] args) {
        Utils utils = new Utils();
        new Thread(() -> utils.rupeesConverter(Currencies.Afghan_Afghani, Currencies.Indian_Rupee, 99d)).start();
        new Thread(utils::goldPrice).start();
        new Thread(() -> utils.petrolAndDieselPrice(PetrolCities.madurai)).start();
    }

    public void goldPrice() {
        Document doc;
        try {
            doc = Jsoup.connect("https://www.google.com/search?q=gold+rate").userAgent(USER_AGENT).ignoreHttpErrors(true).timeout(0).get();
            Elements links = doc.select("g-card-section div");
            for (int i = 0; i < 2; i++) {
                System.out.print(links.get(i).text() + " ");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void rupeesConverter(Currencies from, Currencies to, Double amount) {
        Document doc;
        try {
            doc = Jsoup.connect("https://www.google.com/search?q=" + from.name().replace(" ", "+") + "+to+" + to.name().replace(" ", "+")).userAgent(USER_AGENT).ignoreHttpErrors(true).timeout(0).get();
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

    public void petrolAndDieselPrice(PetrolCities cities) {
        Document doc;
        try {
            doc = Jsoup.connect("https://mfapps.indiatimes.com/ET_Calculators/oilprice.htm?citystate=" + cities.name()).userAgent(USER_AGENT).ignoreHttpErrors(true).timeout(0).get();
            PetrolLists petrolLists = new Gson().fromJson(doc.body().ownText(), PetrolLists.class);
            System.out.println(petrolLists.getResults());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}