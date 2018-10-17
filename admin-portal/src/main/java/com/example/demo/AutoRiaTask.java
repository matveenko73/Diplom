package com.example.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class AutoRiaTask extends Thread {

    public void run() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://auto.ria.com/legkovie/?page=1");


        List<WebElement> nextPages = driver.findElementsByCssSelector(".js-next");
        List<WebElement> models = driver.findElementsByCssSelector(".address");
        List<WebElement> urles = driver.findElementsByCssSelector(".address");
        List<WebElement> pictures = driver.findElementsByCssSelector(".m-auto");
        List<WebElement> prices = driver.findElementsByCssSelector(".i-block");
        List<WebElement> info = driver.findElementsByCssSelector("li.item-char");
        int k = 0;
        int p = 1;

        for (WebElement nextPage : nextPages) {

            for (int i = 0; i < urles.size(); i++) {
                System.out.println(pictures.get(i).getAttribute("src"));
                System.out.println(urles.get(i).getAttribute("href"));
                System.out.println(models.get(i).getText());
                System.out.println(prices.get(p).getText());
                for (int j = 0; j < 4; j++) {
                    System.out.println(info.get(k).getText());
                    k++;
                }
                System.out.println();
                p++;
            }
            nextPage.click();
        }
    }
}
