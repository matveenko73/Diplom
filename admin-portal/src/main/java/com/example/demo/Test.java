package com.example.demo;

public class Test {
    public static void main(String[] args) {

//        Kia Niro 1.6 DCT (141 л.с.) Prestige 2016
//        771 750 грн
//        без пробега
//        Киев
//        Бензин/Электричество, 1.6 л.
//        Автомат
//        Volkswagen Passat B8 TDI 4MOTION MAXI-FUL 2015

        String rs = "продам RENAULT Megane";
        String inform = rs.substring(7, rs.length());
        System.out.println(inform);
        System.out.println(rs.length());


//        String ab ="Volkswagen Passat 1992";
//        String year = ab.substring(ab.length() - 4, ab.length());
//        String info = ab.substring(0, ab.length() - 5);
//        System.out.println(year);
//        System.out.println(info);
//        System.out.println(ab.length());



//        String s = "1 235 000 грн";
//        int i = s.indexOf("грн");
//        String price = s.substring(0, i - 1);
//        price = price.replaceAll(" ",".");
//        System.out.println(price);
//
//
//        String p = "123 тыс км";
//        int v = p.indexOf("тыс");
//        String mileageF;
//        Integer mileage;
//        if (v == -1) {
//            mileageF = "0";
//            mileage = Integer.parseInt(mileageF);
//        } else {
//            mileageF = p.substring(0, v - 1);
//            mileage = Integer.parseInt(mileageF);
//            mileage = mileage * 1000;
//        }
//        System.out.println(mileage);
//
//        String z = "Бензин/Электричество, 1.6 л.";
//        int c = z.indexOf(",");
//        String fuel = z.substring(0, c);
//        if (c == 20) {
//            fuel = "Гибрид";
//        }
//        System.out.println(fuel);
//
//        int h = z.indexOf("л.");
//        String eng = z.substring(c + 1, h);
//        eng = eng.replaceAll(" ", "");
//        System.out.println(eng);
//
//
//
//
//
//        String s = "http://rst.ua/oldcars/mercedes/vito/mercedes_vito_8938560.html";
//        int i = s.indexOf("oldcars/");
//
//        String s2 = s.substring(i + 8);
//        int j = s2.indexOf("/");
////        System.out.println(s2);
//
//        String car = s2.substring(0, j);
//        System.out.println(car);
//
//        s2 = s2.substring(car.length() + 1);
//        s2 = s2.substring(0, s2.indexOf('/'));
//        System.out.println(s2);
//
//        String p = "Цена: 606'000 грн $21'500";
//        int r = p.indexOf("Цена: ");
//        String r2 = p.substring(r + 6);
//        int c = r2.indexOf(" ");
//        String price;
//
//        if (c == -1) {
//
//            price = "Договорная";
//        } else {
//
//            price = r2.substring(0, c);
//            price = price.replaceAll("'", "");
//        }
//
//        System.out.println(price);
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
