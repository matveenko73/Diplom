package com.example.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AutoRiaTask extends Thread {

    static {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Андрей\\Downloads\\geckodriver.exe");}

    private List<Car> result = new ArrayList<>();
    private Consumer<List<Car>> resultListener;

    public AutoRiaTask(Consumer<List<Car>> resultListener) {
        this.resultListener = resultListener;
    }

    public void run() {

        FirefoxDriver driver = new FirefoxDriver();

        String str = "https://auto.ria.com/legkovie/?page=";
        driver.get("https://auto.ria.com/legkovie/?page=1");
        int nextPage = 1;


        List<WebElement> models = driver.findElementsByCssSelector(".address");
        List<WebElement> urles = driver.findElementsByCssSelector(".address");
        List<WebElement> pictures = driver.findElementsByCssSelector(".m-auto");
        List<WebElement> prices = driver.findElementsByCssSelector(".i-block");
        List<WebElement> info = driver.findElementsByCssSelector("li.item-char");

        int p = 1;
        int mile = 0;
        int reg = 1;
        int fe = 2;
        int transm = 3;


        try {
            for (int j = 0; j < 2; j++) {

                for (int i = 0; i < urles.size(); i++) {

                    Car car = new Car();
                    System.out.println(pictures.get(i).getAttribute("src"));
                    System.out.println(urles.get(i).getAttribute("href"));

                    String ab = models.get(i).getText();
                    String years = ab.substring(ab.length() - 4, ab.length());
                    String inform = ab.substring(0, ab.length() - 5);
                    Integer year = Integer.parseInt(years);
                    System.out.println(year);
                    System.out.println(inform);

                    String s = prices.get(p).getText();
                    int q = s.indexOf("грн");
                    String price = s.substring(0, q - 1);
                    price = price.replaceAll(" ", ".");
                    System.out.println(price);

                    String b = info.get(mile).getText();
                    int v = b.indexOf("тыс");
                    String mileageF;
                    Integer mileage;
                    if (v == -1) {
                        mileageF = "0";
                        mileage = Integer.parseInt(mileageF);
                    } else {
                        mileageF = b.substring(0, v - 1);
                        mileage = Integer.parseInt(mileageF);
                        mileage = mileage * 1000;
                    }
                    System.out.println(mileage);
                    System.out.println(info.get(reg).getText());

                    String z = info.get(fe).getText();
                    int c = z.indexOf(",");
                    String fuel;
                    String eng;
                    if (c == -1) {
                        fuel = info.get(fe).getText();
                        System.out.println(fuel);
                    } else {
                        fuel = z.substring(0, c);
                        if (c == 20) {
                            fuel = "Гибрид";
                        }
                        System.out.println(fuel);

                        int h = z.indexOf("л.");
                        eng = z.substring(c + 1, h);
                        eng = eng.replaceAll(" ", "");
                        System.out.println(eng);
                        car.setEngineSize(eng);
                    }
                    System.out.println(info.get(transm).getText());
                    System.out.println();


                    car.setPictures(pictures.get(i).getAttribute("src"));
                    car.setUrles(urles.get(i).getAttribute("href"));
//                    car.setBrand(brand);
//                    car.setModel(model);
                    car.setRegion(info.get(reg).getText());
                    car.setPrice(price);
                    car.setProductionYear(year);
                    car.setFuel(fuel);
//                    car.setState(region.get(un).getText());
                    car.setTransmission(info.get(transm).getText());
                    car.setMileage(mileage);
                    car.setInfo(inform);

                    result.add(car);

                    p++;
                    mile = mile + 4;
                    reg = reg + 4;
                    fe = fe + 4;
                    transm = transm + 4;
                }

                nextPage++;
                driver.get(str + nextPage);

                models = driver.findElementsByCssSelector(".address");
                urles = driver.findElementsByCssSelector(".address");
                pictures = driver.findElementsByCssSelector(".m-auto");
                prices = driver.findElementsByCssSelector(".i-block");
                info = driver.findElementsByCssSelector("li.item-char");

                p = 1;
                mile = 0;
                reg = 1;
                fe = 2;
                transm = 3;

            }
            resultListener.accept(result);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        driver.close();

    }
}
