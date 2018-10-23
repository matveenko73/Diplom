package com.example.demo;

public class Test {
    public static void main(String[] args) {
//        продам MITSUBISHI Eclipse
//        Цена: 606'000 грн $21'500
//        Год: 2012, (93000 - пробег)
//        Двиг.: 2.0 Бензин (Автомат)

//        String s = "http://img1.rstcars.com/oldcars/mitsubishi/eclipse/middle/8720292-2.jpg";
//        int i = s.indexOf("oldcars/");
//
//        String s2 = s.substring(i + 8);
//        int j = s2.indexOf("/");
//        System.out.println(s2);
//
//        String car = s2.substring(0, j);
//        System.out.println(car);
//
//        s2 = s2.substring(car.length() + 1);
//        s2 = s2.substring(0, s2.indexOf('/'));
//        System.out.println(s2);
//
        String p = "Цена: 606'000 грн $21'500";
        int r = p.indexOf("Цена: ");
        String r2 = p.substring(r + 6);
        int c = r2.indexOf(" ");
        String price;

        if (c == -1) {

            price = "Договорная";
        } else {

            price = r2.substring(0, c);
            price = price.replaceAll("'", "");
        }

        System.out.println(price);
//
//
//        String y = "Год: 2012, (93000 - пробег)";
//        int g = y.indexOf("Год: ");
//        int l = y.indexOf("(");
//        int d = y.indexOf("-");
//        String g2 = y.substring(g + 5);
//        int t = g2.indexOf(",");
//
//        String year = g2.substring(0, t);
//        String prob = y.substring(l + 1, d);
//        System.out.println(year);
//        System.out.println(prob);
//
//        String z = "Двиг.: 2.0 Бензин (Автомат)";
//        int x = z.indexOf("Двиг.: ");
//        String z2 = z.substring(x + 7);
//        int n = z2.indexOf(" ");
//        String eng = z2.substring(0, n);
//        System.out.println(eng);
//
//        z2 = z2.substring(eng.length() + 1);
//        String z3 = z2.substring(0, z2.indexOf(" "));
//        System.out.println(z3);
//        int q = z2.indexOf("(");
//        int b = z2.indexOf(")");
//        String z4 = z2.substring(q + 1, b);
//        System.out.println(z4);


    }
}
