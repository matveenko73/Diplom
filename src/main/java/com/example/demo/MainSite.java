package com.example.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class MainSite {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Андрей\\Downloads\\geckodriver.exe");

        FirefoxDriver driver = new FirefoxDriver();
        //driver.get("http://rst.ua/oldcars/maserati/");
//        driver.get("http://rst.ua");
        driver.get("http://rst.ua/oldcars/audi/");
//        List<WebElement> prices = driver.findElementsByCssSelector(".rst-ocb-i-d-l-i-s-p");
//        List<WebElement> images = driver.findElementsByCssSelector("img.rst-ocb-i-i");
//        for (WebElement image : images) {
//            System.out.println((image.getAttribute("src")));
//        }

//        WebElement elementByCssSelector = driver.findElementByName("make[]");
//        elementByCssSelector.click();

//        List<WebElement> images = driver.findElementsByCssSelector(".rst-ocb-i-a");
//        for (WebElement image : images) {
//            System.out.println((image.getAttribute("src")));
//        } ссылки

        List<WebElement> pictures = driver.findElementsByCssSelector(".rst-ocb-i-d-l-i-b");
        for (WebElement picture : pictures) {
            System.out.println((picture.getAttribute("src")));
        }
        //driver.close();
    }
}