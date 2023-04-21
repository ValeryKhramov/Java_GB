package org.example;


import java.util.Arrays;

public class Main {
    // 1. Написать метод принимающий строку, ищущий в ней основание и степень После этого расчитывающий результат и
    // выводящий в консоль в консоль строку параметра + ответ.
    public static String parseString(String inString) {
        int[] digitArguments = new int[2];
        int count = 0;
        inString = inString.replace(",", "");
        String[] strArray = inString.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            try {
                digitArguments[count] = Integer.parseInt(strArray[i]);
                count++;
            } catch (NumberFormatException e) {
                continue;
            }
        }
        String result = inString + " " + (int) Math.pow(digitArguments[0], digitArguments[1]);
        return result;
    }

    // 2. Сравнить скорость работы реплейса классов String и StringBuilder.
    public static String checkSpeedString(String inString) {
        return inString.replace("Python", "Java");

    }

    public static StringBuilder checkSpeedStringBuilder(String inString, String oldWord) {
        StringBuilder strBuilder = new StringBuilder(inString);
        while (strBuilder.indexOf(oldWord) != -1) {
            strBuilder.replace(strBuilder.indexOf(oldWord), strBuilder.indexOf(oldWord) + oldWord.length(), "Java");
        }
        return strBuilder;
    }

    public static String createString(String word, int count){
        String result = "";
        for (int i = 0; i < count; i++) {
            result += word +" ";
        }
        return result;
    }
        public static void main (String[]args){
            System.out.println(parseString("Основание -12, степень 7, результат") + "\n");
            System.out.println(parseString("Основание 0, степень 0, результат") + "\n");
            System.out.println(parseString("Основание 5, степень 10, результат") + "\n");
            System.out.println(parseString("Основание 3, степень 3, результат") + "\n");
            System.out.println(parseString("Основание 15, степень 6, результат") + "\n");

            String text = createString("Python", 1000);
            long startString = System.currentTimeMillis();
            System.out.println(checkSpeedString(text));
            long endString = System.currentTimeMillis();
            System.out.println("Замена слов в строке из 1000 слов \"Python\" с использованием String заняло " +
                    (endString - startString) + "мс." +"\n");

            long startStringBuilder = System.currentTimeMillis();
            System.out.println(checkSpeedStringBuilder(text, "Python"));
            long endStringBuilder = System.currentTimeMillis();
            System.out.println("Замена слов в строке из 1000 слов \"Python\" с использованием StringBuilder заняло " +
                    (endStringBuilder - startStringBuilder) + "мс.");

        }
    }
