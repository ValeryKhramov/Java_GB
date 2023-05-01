package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
// 1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
// 2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести
// в консоль в формате "Иванов И.И. 32 М"
// 3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас
// и пол в отдельных списках.
// 4.Отсортировать по возрасту используя дополнительный список индексов.

// Сначала загружаем данные из файла, после пожно посмотреть в каком они порядке, используя п.3, далее сортируем данные
// используя п.5, и перезаписываем их в файл(п.4)
public class Main {
    static ArrayList<String> surname = new ArrayList<>();
    static ArrayList<String> name = new ArrayList<>();
    static ArrayList<String> patronymic = new ArrayList<>();
    static ArrayList<Integer> age = new ArrayList<>();
    static ArrayList<String> gender = new ArrayList<>();
    static ArrayList<Integer> id = new ArrayList<>();
    public static ArrayList<String> directory = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() throws Exception {
        while (true){
            System.out.println("\nГлавное меню:\n 1. Загрузить данные из файла \n 2. Добавить данные " +
                    "\n 3. Показать данные \n 4. Сохранить данные в файл \n 5. Отсортировать данные \n 6. Выход");
            System.out.print("Введите число для выбора пункта главного меню: ");
            String number = scanner.nextLine();
            switch (Integer.parseInt(number)) {
                case (1):
                    loadInfoFromFile();
                    break;
                case (2):
                    inputInDirectory(directory);
                    break;
                case (3):
                    if (!directory.isEmpty()) {
                        outputDirectory();
                    } else {
                        System.out.println("\n Файл пуст или данные из него не были загружены!");
                    }
                    break;
                case(4):
                    saveInfoInFile(directory);
                    break;
                case(5):
                    sortedInformation(id, age);
                    break;
                case (6):
                    exit();
                    break;
                default:
                    System.out.println("\nВы ввели некорректные данные");
                    mainMenu();
            }
        }
    }
    public static void inputInDirectory(ArrayList<String> directory){
        System.out.print("\nВведите ФИО, возраст, пол через пробел (Иванов Иван Иванович 20 М): ");
        String in = scanner.nextLine();
        directory.add(in);
    }
    public static void outputDirectory(){
        System.out.println("\n");
        for (int n:id) {
            System.out.println(directory.get(n));
        }
    }
    public static void sortedInformation(ArrayList<Integer> id, ArrayList<Integer> age){
        int temp = 0;
        for (int out = age.size() - 1; out >= 1; out--){
            for (int i = 0; i < out; i++) {

                if(age.get(i) > age.get(i+1)) {
                    temp = age.get(i);
                    age.set(i, age.get(i + 1));
                    age.set(i + 1, temp);

                    temp = id.get(i);
                    id.set(i, id.get(i + 1));
                    id.set(i + 1, temp);

                }
            }

        }
        System.out.println("\nСортировка успешно завершена!");
        System.out.println(age);
        System.out.println(id);
    }
    public static void saveInfoInFile(ArrayList<String> list){
        try (FileWriter writer = new FileWriter("db.sql", false)){
            for (String str: list) {
                writer.write(str);
                writer.append("\n");
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("\nФайл успешно сохранен!");
        }

    }
    public static void exit(){
        System.out.println("\nВсего хорошего!");
        System.exit(1);

    }
    public static void loadInfoFromFile()  throws Exception {


        BufferedReader br = new BufferedReader(new FileReader("db.sql"));
        String str = "";
        int key = 0;
        while ((str = br.readLine()) != null) {
            directory.add(str);
            String[] array;
            array = str.split(" ");
            surname.add(array[0]);
            name.add(array[1]);
            patronymic.add(array[2]);
            age.add(Integer.parseInt(array[3]));
            gender.add(array[4]);
            id.add(key++);
        }
        br.close();
        System.out.println("\n Загрузка данных прошла успешно!");
        System.out.println(id);
        System.out.println(age);
    }

    public static void main(String[] args) throws Exception {
        mainMenu();

;


    }
}