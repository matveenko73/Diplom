package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class MainSite {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Андрей\\Downloads\\geckodriver.exe");

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://rst.ua/oldcars/bmw/");
//        List<WebElement> urles = driver.findElementsByCssSelector(".rst-ocb-i-a");
//        for (WebElement url : urles) {
//            System.out.println((url.getAttribute("href")));
//        }

//        System.out.println();
//
//        List<WebElement> pictures = driver.findElementsByCssSelector(".rst-ocb-i-i");
//        for (WebElement picture : pictures) {
//            System.out.println(picture.getAttribute("src"));
//        }

//        System.out.println();

        List<WebElement> nextPages = driver.findElementsByCssSelector("ul.pagination a");
        for (WebElement nextPage : nextPages) {
//            nextPage.findElements(By.cssSelector("324234234"));
            nextPage.click();

            List<WebElement> prices = driver.findElementsByCssSelector(".rst-ocb-i-d-l-i-s");
            int i = 0;
            for (WebElement price : prices) {
                i++;
                if (i == 7) {
                    i = 1;
                    System.out.println();
                }
                System.out.println(price.getText());
            }
        }
        //driver.close();
    }
}