package com.example.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class MainSite {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Андрей\\Downloads\\geckodriver.exe");

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://rst.ua/oldcars/maserati/");
//        List<WebElement> prices = driver.findElementsByCssSelector(".rst-ocb-i-d-l-i-s-p");
        List<WebElement> images = driver.findElementsByCssSelector("img.rst-ocb-i-i");
        for (WebElement image : images) {
            System.out.println((image.getAttribute("src")));
        }
        driver.close();
    }
}
