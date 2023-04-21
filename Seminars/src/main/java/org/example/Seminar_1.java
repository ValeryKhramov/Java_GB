package org.example;

import java.util.Random;

public class Seminar_1 {
    public static void main(String[] args) {
        int i = 128;
        long l;
        float f = .86f;
        double d = 566.86;
        byte b;
        short sh;
        char c = 'f'; //16bit Р±РµР·Р·РЅР°РєРѕРІР°СЏ

        String s = ":";
        s += ") Smile";
        print(s.repeat(12));
        print(String.valueOf(s.length()));
        print(s.toLowerCase());
        print(String.valueOf(s.toUpperCase().charAt(s.length()-1)));
        print(":) ".repeat(12));

        if (s.contains(":")) print("true"); else print("false");
        if (s.equals(":")) print("true"); else print("false");

        print(s.replace(')', '('));

        s.substring(3, s.length()-2);
        String[] lines = s.split(" ");

        int[] ints = new int[]{1,2,3,4,5};
        i = ints.length;

        int[] tmp = new int[ints.length+1];
        for (int j=0;j<ints.length;j++) {
            tmp[j] = ints[j];
        }
        ints = tmp;

        if (2==3) {
            System.out.println("Hello World");
        }

        System.out.println(Short.MIN_VALUE);
        System.out.println(Integer.toBinaryString(17).length());
        Integer.parseInt("1265");

//        Random random = new Random();
//        System.out.println(random.nextInt(12));

        System.out.println(new Random().nextInt(12));


    }

    private static void print(String s){
        System.out.println(s);
    }

}