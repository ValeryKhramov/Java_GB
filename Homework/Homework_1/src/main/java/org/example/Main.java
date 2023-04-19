package org.example;

import java.util.Random;

public class Main {

    // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
    public static int getRandomNumber(int min_num, int max_num) {
        return new Random().nextInt(min_num, max_num);
    }

    // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
    public static int findSeniorBit(int number) {
        return Integer.toBinaryString(number).length();
    }

    // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
    public static int[] getArrayFindDivisibleNumber(int number, int limitIndex){
        int[] resultArray = new int[1];
        int index = 0;
        for (int i = limitIndex; i < Short.MAX_VALUE; i++) {
            if (i % number == 0){
                resultArray = appendNumberInArray(index, resultArray, i);
                index++;
            }
        }
        return resultArray;

    }

    // 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
    public static int[] getArrayFindNotDivisibleNumber(int number, int limitIndex) {
        int[] resultArray = new int[1];
        int index = 0;
        for (int i = Short.MIN_VALUE; i < limitIndex; i++) {
            if (i % number != 0) {
                resultArray = appendNumberInArray(index, resultArray, i);
                index++;
            }
        }
        return resultArray;
    }

    // Метод расширения массива и добавление нового элемента в него (Используется в п.3 и п.4)
    public static int[] appendNumberInArray(int index, int[] oldArray, int value){
        int[] newArray = new int[index + 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = oldArray[i];
        }
        newArray[index] = value;
        return newArray;
    }


    public static void main(String[] args) {
        int i = getRandomNumber(0, 2001);
        int n = findSeniorBit(i);
        System.out.println("i = " + i);
        System.out.println("n = " + n);
        int[] m1= getArrayFindDivisibleNumber(n,i);
        int[] m2 = getArrayFindNotDivisibleNumber(n,i);
        System.out.println("Длина массива m1 = " + m1.length);
        System.out.println("Длина массива m2 = " + m2.length);
        // Если необходимо вывести массивы m1 и m2 полностью
        //System.out.println(Arrays.toString(m1));
        //System.out.println(Arrays.toString(m2));



    }
}