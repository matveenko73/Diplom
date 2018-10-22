package com.example.demo;

import com.beust.jcommander.internal.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.util.PropertyExpander;

import java.util.List;
import java.util.function.Predicate;

public class MainSite {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Андрей\\Downloads\\geckodriver.exe");

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://rst.ua/oldcars/?task=newresults&make%5B%5D=0&year%5B%5D=0&year%5B%5D=0&price%5B%5D=0&price%5B%5D=0&engine%5B%5D=0&engine%5B%5D=0&gear=0&fuel=0&drive=0&condition=0&from=sform");


        List<WebElement> nextPages = driver.findElementsByCssSelector("ul.pagination a");
        List<WebElement> models = driver.findElementsByCssSelector(".rst-ocb-i-h");
        List<WebElement> urles = driver.findElementsByCssSelector(".rst-ocb-i-a");
        List<WebElement> pictures = driver.findElementsByCssSelector(".rst-ocb-i-i");
        List<WebElement> prices = driver.findElementsByCssSelector(".rst-ocb-i-d-l-i");

        int k = 0;
        try {

            for (int f = 0; f < 30; f++) {
                for (int i = 0; i < pictures.size(); i++) {

                    String s = pictures.get(i).getAttribute("src");
                    System.out.println(urles.get(i).getAttribute("href"));
//                    System.out.println(models.get(i).getText());
                    int iz = s.indexOf("oldcars/");

                    String s2 = s.substring(iz + 8);
                    int x = s2.indexOf("/");

                    String car = s2.substring(0, x);
                    System.out.println(car);

                    s2 = s2.substring(car.length() + 1);
                    s2 = s2.substring(0, s2.indexOf('/'));
                    System.out.println(s2);

                    for (int j = 0; j < 3; j++) {
//                        String p = prices.get(k).getText();
//                        System.out.println("FFFF " + p);
//                        int r = p.indexOf("Цена: ");
//                        String r2 = p.substring(r + 6);
//                        int c = r2.indexOf("грн");
//
//                        String price = r2.substring(0, c);
//                        price = price.replaceAll("'", "");
//                        System.out.println(price);

//
//                        String y = prices.get(k).getText();
//                        int g = y.indexOf("Год: ");
//                        int l = y.indexOf("(");
//                        int d = y.indexOf("-");
//                        String g2 = y.substring(g + 5);
//                        int t = g2.indexOf(",");
//
//                        String year = g2.substring(0, t);
//                        String prob = y.substring(l + 1, d);
//                        System.out.println(year);
//                        System.out.println(prob);

                        System.out.println(prices.get(k).getText());
                        k++;
                    }
                    System.out.println();
                    k = 0;
                }
//                new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);

                WebElement nextPage = nextPages.get(f);
                if (nextPage.getText().startsWith(">")) {
                    f = 0;
                }

                nextPage.click();
                nextPages = driver.findElementsByCssSelector("ul.pagination a");
                models = driver.findElementsByCssSelector(".rst-ocb-i-h");
                urles = driver.findElementsByCssSelector(".rst-ocb-i-a");
                pictures = driver.findElementsByCssSelector(".rst-ocb-i-i");
                prices = driver.findElementsByCssSelector(".rst-ocb-i-d-l-i");
            }
//        } catch (StaleElementReferenceException e) {
        } catch (Exception ex) {
            System.out.println("Исключение: " + ex);
        }

//        } finally {
//            driver.close();
//        }
    }
}
