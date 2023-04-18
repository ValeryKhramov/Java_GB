package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int random_number(int min_num, int max_num) {
        Random rnd = new Random();
        return rnd.nextInt(min_num, max_num);

    }
    public static void main(String[] args) {
        // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        int i = random_number(0, 2000);
        System.out.println(i);



    }
}