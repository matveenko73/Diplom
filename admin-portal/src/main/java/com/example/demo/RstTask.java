package com.example.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RstTask extends Thread {

    static {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Андрей\\Downloads\\geckodriver.exe");
    }

    private List<Car> result = new ArrayList<>();
    private Consumer<List<Car>> resultListener;

    public RstTask(Consumer<List<Car>> resultListener) {
        this.resultListener = resultListener;
    }

    public void run() {

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://rst.ua/oldcars/?task=newresults&make%5B%5D=0&year%5B%5D=0&year%5B%5D=0&price%5B%5D=0&price%5B%5D=0&engine%5B%5D=0&engine%5B%5D=0&gear=0&fuel=0&drive=0&condition=0&from=sform");

        List<WebElement> nextPages = driver.findElementsByCssSelector("li.active a");
        List<WebElement> models = driver.findElementsByCssSelector(".rst-ocb-i-h");
        List<WebElement> urles = driver.findElementsByCssSelector(".rst-ocb-i-a");
        List<WebElement> pictures = driver.findElementsByCssSelector(".rst-ocb-i-i");
        List<WebElement> prices = driver.findElementsByCssSelector(".rst-ocb-i-d-l-i");
        int k = 0;

        for (WebElement nextPage : nextPages) {
            for (int i = 0; i < pictures.size(); i++) {
                System.out.println(models.get(i).getText());

                Car car = new Car();
                car.setPictures(pictures.get(i).getAttribute("src"));
                car.setUrles(urles.get(i).getAttribute("href"));
                result.add(car);

                for (int j = 0; j < 3; j++) {
                    System.out.println(prices.get(k).getText());
                    k++;
                }
                System.out.println();
            }
            nextPage.click();
        }

        resultListener.accept(result);
    }
}
