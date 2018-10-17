package com.example.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class AutoRia {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Андрей\\Downloads\\geckodriver.exe");

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://auto.ria.com/legkovie/?page=1");


//        List<WebElement> nextPages = driver.findElementsByCssSelector("li.active a");
        List<WebElement> urles = driver.findElementsByCssSelector(".address");
//        List<WebElement> pictures = driver.findElementsByCssSelector(".outline m-auto");
        List<WebElement> prices = driver.findElementsByCssSelector(".i-block");
        List<WebElement> info = driver.findElementsByCssSelector("li.item-char");
        int k = 0;
        int p = 1;

        for (int i = 0; i < urles.size(); i++) {

            System.out.println(urles.get(i).getAttribute("href"));
            System.out.println(prices.get(p).getText());
//            System.out.println(pictures.get(i).getAttribute("src"));
            for (int j = 0; j < 4; j++) {
                System.out.println(info.get(k).getText());
                k++;
            }
            System.out.println();
            p++;
        }
    }
}
