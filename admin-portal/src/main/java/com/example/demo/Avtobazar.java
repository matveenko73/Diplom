package com.example.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Avtobazar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Андрей\\Downloads\\geckodriver.exe");

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://ab.ua/avto/?capacityUnit=1&currency=uah&isNew=0&powerUnit=1&transport=1");

        List<WebElement> pictures = driver.findElementsByCssSelector(".imgCover img");
        List<WebElement> urles = driver.findElementsByCssSelector(".Dkcgo a");

        for (int i = 0; i < urles.size(); i++) {
            System.out.println(urles.get(i).getAttribute("href"));
            System.out.println(urles.get(i).getAttribute("src"));
            System.out.println();
        }
    }
}
