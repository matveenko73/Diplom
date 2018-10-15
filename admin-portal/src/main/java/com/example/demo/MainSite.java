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
        driver.get("http://rst.ua/oldcars/?task=newresults&make%5B%5D=0&year%5B%5D=0&year%5B%5D=0&price%5B%5D=0&price%5B%5D=0&engine%5B%5D=0&engine%5B%5D=0&gear=0&fuel=0&drive=0&condition=0&from=sform");
//        List<WebElement> urles = driver.findElementsByCssSelector(".rst-ocb-i-a");
//        for (WebElement url : urles) {
//            System.out.println((url.getAttribute("href")));
//        }

//        System.out.println();
//
        List<WebElement> urles = driver.findElementsByCssSelector(".rst-ocb-i-a");
        List<WebElement> pictures = driver.findElementsByCssSelector(".rst-ocb-i-i");
        List<WebElement> prices = driver.findElementsByCssSelector(".rst-ocb-i-d-l-i-s");
        int k = 0;

        for (int i = 0; i < pictures.size(); i++) {

            System.out.println(pictures.get(i).getAttribute("src"));
            System.out.println(urles.get(i).getAttribute("href"));
            for (int j = 0; j < 6; j++) {
                System.out.println(prices.get(k).getText());
                k++;
            }
            System.out.println();
        }

//        for (int i = 0; i < pictures.size(); i++) {
//
//            for (WebElement j : pictures) {
//                System.out.println(j.getAttribute("src"));
//                continue;
//            }
//
//            for (WebElement price : prices) {
//                System.out.println(price.getText());
//                continue;
//            }
//            System.out.println();
//        }
    }


//        System.out.println();

//        List<WebElement> nextPages = driver.findElementsByCssSelector("ul.pagination a");
//        for (WebElement nextPage : nextPages) {
//            nextPage.findElements(By.cssSelector("324234234"));
//            nextPage.click();

//        List<WebElement> prices = driver.findElementsByCssSelector(".rst-ocb-i-d-l-i-s");
//        int i = 0;
//        for (WebElement price : prices) {
//            i++;
//            if (i == 7) {
//                i = 1;
//                System.out.println();
//            }
//            System.out.println(price.getText());
//        }
//    }
}
//driver.close();
//rst-page-wrap