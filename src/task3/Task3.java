package task3;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import static task3.workingWithFiles.writeFiles;
import static task3.workingWithFiles.creatFiles;

public class Task3 {

    public static void main(String[] args) throws InterruptedException {

        try {

            for (int j = 1; j < 21; j++) {
                   /*C dizinin altina files klasoru olusturun.*/
                String path = "C:\\files\\ihaleOzetsayfa" + j + ".txt";
                creatFiles(path);
                Document doc = Jsoup.connect("https://ilan.gov.tr/kategori-arama?currentPage=" + j + "&npdab=on&type=21628").timeout(5000).get();

                for (int i = 1; i < 15; i++) {
                    String link = (doc.select("ul li:nth-child(" + i + ")" + " > div.inner-item > a").attr("abs:href"));

                    var doc2 = Jsoup.connect(link).timeout(1000 * 5).ignoreHttpErrors(true).get(); 
                    /*TODO: HTTPStatusException 400 error.*/

                    String ihaleKayıtNo = doc2.select("div.table-div > div.tr:nth-child(2)").text();
                    String niteliğiTürüveMiktari = doc2.select("div.table-div > div.tr:nth-child(3)").text();
                    String işinYapilacagiYer = doc2.select("div.table-div > div.tr:nth-child(4)").text();
                    String ihaleTuru = doc2.select("div.table-div > div.tr:nth-child(5)").text();
                    String text = doc2.select("div.table-div > div.tr:nth-child(6)").text();
                    String text2 = doc2.select("div.table-div > div.tr:nth-child(7)").text();

                    writeFiles(path, j + ". sayfa, " + i + ". ilan özeti: ");
                    writeFiles(path, ihaleKayıtNo);
                    writeFiles(path, niteliğiTürüveMiktari);
                    writeFiles(path, işinYapilacagiYer);
                    writeFiles(path, ihaleTuru);
                    writeFiles(path, text);
                    writeFiles(path, text2);
                    writeFiles(path, "----------------------------");

                }
                for (int i = 1; i < 7; i++) {
                    String link = (doc.select("ul:nth-child(2) li:nth-child(" + i + ")" + " > div.inner-item > a").attr("abs:href"));

                    var doc3 = Jsoup.connect(link).timeout(5000).ignoreHttpErrors(true).get();
                      /*TODO: HTTPStatusException 400 error*/
                    String ihaleKayıtNo = doc3.select("div.table-div > div.tr:nth-child(2)").text();
                    String niteliğiTürüveMiktari = doc3.select("div.table-div > div.tr:nth-child(3)").text();
                    String işinYapilacagiYer = doc3.select("div.table-div > div.tr:nth-child(4)").text();
                    String ihaleTuru = doc3.select("div.table-div > div.tr:nth-child(5)").text();
                    String text = doc3.select("div.table-div > div.tr:nth-child(6)").text();
                    String text2 = doc3.select("div.table-div > div.tr:nth-child(7)").text();

                    writeFiles(path, j + ". sayfa, " + (i + 14) + ". ilan özeti: ");
                    writeFiles(path, ihaleKayıtNo);
                    writeFiles(path, niteliğiTürüveMiktari);
                    writeFiles(path, işinYapilacagiYer);
                    writeFiles(path, ihaleTuru);
                    writeFiles(path, text);
                    writeFiles(path, text2);
                    writeFiles(path, "----------------------------");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Task3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
