package com.example.demo;

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

        System.out.println();

        List<WebElement> prices = driver.findElementsByCssSelector(".rst-ocb-i-d-l-i-s-p");
        for (WebElement price : prices) {
            System.out.println(price.getText());
        }

        System.out.println();

        List<WebElement> years = driver.findElementsByClassName(".rst-ocb-i-d-l-i");
        for (WebElement year : years) {
            System.out.println(year.getText());
        }

        System.out.println();

        List<WebElement> regions = driver.findElementsByClassName(".rst-ocb-i-d-l-i-s rst-ocb-i-d-l-i-s-p");
        for (WebElement region : regions) {
            System.out.println(region.getText());
        }


        //driver.close();
    }
}