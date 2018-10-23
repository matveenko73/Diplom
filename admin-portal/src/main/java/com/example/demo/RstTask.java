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

        String str = "http://rst.ua/oldcars/?task=newresults&make%5B%5D=0&year%5B%5D=0&year%5B%5D=0&price%5B%5D=0&price%5B%5D=0&engine%5B%5D=0&engine%5B%5D=0&gear=0&fuel=0&drive=0&condition=0&from=sform&start=";
        driver.get("http://rst.ua/oldcars/?task=newresults&make%5B%5D=0&year%5B%5D=0&year%5B%5D=0&price%5B%5D=0&price%5B%5D=0&engine%5B%5D=0&engine%5B%5D=0&gear=0&fuel=0&drive=0&condition=0&from=sform");

        List<WebElement> urles = driver.findElementsByCssSelector(".rst-ocb-i-a");
        List<WebElement> pictures = driver.findElementsByCssSelector(".rst-ocb-i-i");
        List<WebElement> prices = driver.findElementsByCssSelector(".rst-ocb-i-d-l-i");
        List<WebElement> region = driver.findElementsByCssSelector(".rst-ocb-i-d-l-i-s");

        int k = 0;
        int o = 1;
        int u = 2;
        int pageNomber = 1;
        int re = 1;
        int un = 3;

        try {

            for (int f = 0; f < 20; f++) {
                for (int i = 0; i < pictures.size(); i++) {

                    System.out.println(pictures.get(i).getAttribute("src"));
                    System.out.println(urles.get(i).getAttribute("href"));
                    System.out.println(region.get(re).getText());
                    System.out.println(region.get(un).getText());


                    String s = urles.get(i).getAttribute("href");
                    int iz = s.indexOf("oldcars/");
                    String s2 = s.substring(iz + 8);
                    int x = s2.indexOf("/");

                    String brand = s2.substring(0, x);
                    System.out.println(brand);

                    s2 = s2.substring(brand.length() + 1);
                    String model = s2.substring(0, s2.indexOf('/'));
                    System.out.println(model);

                    String p = prices.get(k).getText();
                    int r = p.indexOf("Цена: ");
                    String r2 = p.substring(r + 6);
                    int c = r2.indexOf(" ");
                    String price;
                    if (c == -1) {

                        price = "Договорная";
                    } else {

                        price = r2.substring(0, c);
                        price = price.replaceAll("'", ".");
                    }
                    System.out.println(price);


                    String y = prices.get(o).getText();
                    int g = y.indexOf("Год: ");
                    int l = y.indexOf("(");
                    int d = y.indexOf("-");
                    String g2 = y.substring(g + 5);
                    int t = g2.indexOf(",");
                    String yearF = g2.substring(0, t);
                    String mileageF = y.substring(l + 1, d);
                    Integer year = Integer.parseInt(yearF);
                    System.out.println(year);
                    mileageF = mileageF.replaceAll(" ", "");
                    Integer mileage = Integer.parseInt(mileageF);
                    System.out.println(mileage);


                    String z = prices.get(u).getText();
                    int w = z.indexOf("Двиг.: ");
                    String z2 = z.substring(w + 7);
                    int n = z2.indexOf(" ");
                    String engine = z2.substring(0, n);
                    engine = engine.replaceAll("i", "");
                    System.out.println(engine);

                    z2 = z2.substring(engine.length() + 1);
                    String fuel = z2.substring(0, z2.indexOf(" "));
                    System.out.println(fuel);
                    int q = z2.indexOf("(");
                    int b = z2.indexOf(")");
                    String transmission = z2.substring(q + 1, b);
                    System.out.println(transmission);

                    Car car = new Car();
                    car.setPictures(pictures.get(i).getAttribute("src"));
                    car.setUrles(urles.get(i).getAttribute("href"));
                    car.setBrand(brand);
                    car.setModel(model);
                    car.setEngineSize(engine);
                    car.setRegion(region.get(re).getText());
                    car.setPrice(price);
                    car.setProductionYear(year);
                    car.setFuel(fuel);
                    car.setState(region.get(un).getText());
                    car.setTransmission(transmission);
                    car.setMileage(mileage);

                    result.add(car);

                    k = k + 3;
                    o = o + 3;
                    u = u + 3;
                    re = re + 6;
                    un = un + 6;

                    System.out.println();
                }

                pageNomber++;
                driver.get(str + pageNomber);

                urles = driver.findElementsByCssSelector(".rst-ocb-i-a");
                pictures = driver.findElementsByCssSelector(".rst-ocb-i-i");
                prices = driver.findElementsByCssSelector(".rst-ocb-i-d-l-i");
                region = driver.findElementsByCssSelector(".rst-ocb-i-d-l-i-s");

                k = 0;
                o = 1;
                u = 2;
                re = 1;
                un = 3;

            }
            resultListener.accept(result);
        } catch (Exception ex) {
            System.out.println("Исключение: " + ex);
        }
    }
}


//        int k = 0;
//
//        for (WebElement nextPage : nextPages) {
//            for (int i = 0; i < pictures.size(); i++) {
//                System.out.println(models.get(i).getText());
//
//                Car car = new Car();
//                car.setPictures(pictures.get(i).getAttribute("src"));
//                car.setUrles(urles.get(i).getAttribute("href"));
//                result.add(car);
//
//                for (int j = 0; j < 3; j++) {
//                    System.out.println(prices.get(k).getText());
//                    k++;
//                }
//                System.out.println();
//            }
//            nextPage.click();
//        }
//
//        resultListener.accept(result);

