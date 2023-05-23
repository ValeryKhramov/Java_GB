package org.example;


import java.util.Random;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        mySet mySet = new mySet();

        // Добавляет элемент
        for (int i = 0; i < 10; i++) {
            mySet.add(new Random().nextInt( 10));
        }

        // Возвращающает строку с элементами множества
        String my_string = mySet.toString();
        System.out.println(my_string);

        // Позволяет читать элементы по индексу
        System.out.println(mySet.getItem(new Random().nextInt(mySet.size())));
    }
}

class mySet{
    static final Object OBJECT = new Object();
    private final TreeMap<Integer, Object> treeMap = new TreeMap<>();

    public boolean add(int num) {
        return treeMap.put(num, OBJECT) == null;
    }

    public Integer getItem(int index) {
        return (Integer) treeMap.keySet().toArray()[index];
    }

    public String toString() {
        return treeMap.keySet().toString();
    }

    public Integer size() {
        return treeMap.size();
    }

}