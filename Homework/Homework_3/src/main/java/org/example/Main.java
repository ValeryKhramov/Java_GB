package org.example;

import java.beans.Introspector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    // Метод для создания списка с заданными пользователем количеством элементов и наименьшим и наибольшем значением
    public static ArrayList<Integer> randomArrayList(int countElements, int minValue, int maxValue){
        ArrayList<Integer> resultArrayList = new ArrayList<>();
        for (int i = 0; i < countElements; i++) {
            resultArrayList.add(new Random().nextInt(minValue, maxValue));
        }
        return resultArrayList;
    }
    // 1. Реализовать алгоритм обратной сортировки списков компаратором.
    public static ArrayList<Integer> sortedArrayList(ArrayList<Integer> inList ){
        ArrayList<Integer> resultArray = new ArrayList<>(inList);
        resultArray.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        return resultArray;
    }
    // 2. Пусть дан произвольный список целых чисел, удалить из него чётные числа
    public static ArrayList<Integer> deleteEvenNumbers(ArrayList<Integer> arrayNumber){
        ArrayList<Integer> resultArray = new ArrayList<>(arrayNumber);
        for (int i = 0; i < resultArray.size(); i++) {
            if (resultArray.get(i) % 2 == 0){
                resultArray.remove(resultArray.get(i));
                i--; // Компенсируем смещение индекса в ArrayList при удалении элемента
            }
        }
        return resultArray;
    }

    // 3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
    public static ArrayList minMaxAverageValue(ArrayList<Integer> arrayNumbers){
        ArrayList resultArray = new ArrayList();
        arrayNumbers = sortedArrayList(arrayNumbers);
        resultArray.add(arrayNumbers.get(arrayNumbers.size() - 1));
        resultArray.add(arrayNumbers.get(0));
        int sum = 0;
        for (int n:arrayNumbers) {
            sum += n;
        }
        resultArray.add((double) sum/arrayNumbers.size());
        return  resultArray;
    }

    // 4. Дано два целочисленных списка, объеденить их не допуская элементы второго списка уже встречающиеся в первом.
    public static void joinArrayLists(ArrayList<Integer> firstLists, ArrayList<Integer> secondLists) {
        ArrayList<Integer> resultArray = new ArrayList<>(firstLists);
        System.out.println(firstLists + " " + "Первый список");
        System.out.println(secondLists + " " + "Второй список");
        firstLists.retainAll(secondLists);
        secondLists.removeAll(firstLists);
        resultArray.addAll(secondLists);
        System.out.println(resultArray+ " " + "(Первый список + второй список) без дубликатов");
    }
    //5.Создать ArrayList<Integer> и добавить нулевым эллементом ноль 10000 раз.
    public static ArrayList<Integer> checkSpeedArrayList(){
        ArrayList<Integer> resultArray = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            resultArray.add(0,0);

        }
        return resultArray;
    }
    //6.Повторить пятый пункт но с LinkedList.
    public static LinkedList<Integer> checkSpeedLinkedList(){
        LinkedList<Integer> resultArray = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            resultArray.add(0,0);

        }
        return resultArray;
    }


    public static void main(String[] args) {
        ArrayList<Integer> mainArrayList = new ArrayList<>();
        mainArrayList = randomArrayList(20, 0, 100);
        System.out.println(mainArrayList + " " + "Рандомный ArrayList");


        System.out.println(sortedArrayList(mainArrayList) + " " + "ArrayList с обратной сортирвкой");

        System.out.println(deleteEvenNumbers(mainArrayList) + " " + "ArrayList без четных чисел");

        System.out.println(minMaxAverageValue(mainArrayList) + " " + " Минимальное, максимально и среднее значение ArrayList");

        joinArrayLists(mainArrayList,randomArrayList(10,0,100));
        long start = System.currentTimeMillis();
        checkSpeedArrayList();
        long end = System.currentTimeMillis();
        System.out.println("Создать ArrayList<Integer> и добавить нулевым эллементом ноль 10000 раз занимает " + (end - start) + " мс.");
        start = System.currentTimeMillis();
        checkSpeedLinkedList();
        end = System.currentTimeMillis();
        System.out.println("Создать LinkedList<Integer> и добавить нулевым эллементом ноль 10000 раз занимает " + (end - start) + " мс.");


    }
}