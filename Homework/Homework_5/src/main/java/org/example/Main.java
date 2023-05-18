package org.example;

import java.util.HashMap;

/*Создать множество, ключь и значение строки. Добавить шесть элементов.
        Вывести в консоль значения. Добавить ко всем значениям символ "!".
        Создать второе множество с таким же обобщением. Ключи второго множества частично совпадают с ключами первого.
        Объеденить значания во втором множестве и первом если ключи совподают. Вывести результат в консоль.*/
public class Main {

    public static void main(String[] args) {
//      Создать множество; ключ и значение - строки.
        HashMap<Integer, String> hashMap = new HashMap<>();

//      Добавить шесть элементов.
        hashMap.put(1, "Один");
        hashMap.put(2, "Два");
        hashMap.put(3, "Три");
        hashMap.put(4, "Четыре");
        hashMap.put(5, "Пять");
        hashMap.put(6, "Шесть");

//      Вывести в консоль значения.
        System.out.println(hashMap.values() + "\n");

//      Добавить ко всем значениям символ "!".
        for (Integer key: hashMap.keySet()){
            hashMap.compute(key, (k,v) -> v + "!");
        }

//      Создать второе множество с таким же обобщением.
        HashMap<Integer, String> hashMap2 = new HashMap<>();

//      Ключи второго множества частично совпадают с ключами первого.
        hashMap2.put(3, "Three");
        hashMap2.put(4, "Four");
        hashMap2.put(5, "Five");
        hashMap2.put(6, "Six");
        hashMap2.put(7, "Seven");
        hashMap2.put(8, "Eight");

//      Объединить значения во втором множестве и первом, если ключи совпадают.
        hashMap2.forEach((k2, v2) ->
                hashMap.forEach((k, v) -> {
                    if (k2.hashCode() == k.hashCode() && k2 == k) {
                        hashMap2.put(k2, v + v2);
                    }
                }));

//      Вывести результат в консоль.
        hashMap2.forEach((k, v) -> System.out.format("%-10s %-1s%n", k, v));

    }
}