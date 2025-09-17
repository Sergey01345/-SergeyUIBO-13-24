Работа с массивами на ЯП Java 
import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    
    // Функция для вывода массива
    public static void printArray(int[] arr, String message) {
        System.out.print(message + " ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // Функция для поиска элемента в массиве
    public static int findElement(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    // Функция для вычисления статистики массива
    public static void arrayStats(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Массив пуст");
            return;
        }
        
        int sum = 0;
        int max = arr[0];
        int min = arr[0];
        
        for (int num : arr) {
            sum += num;
            if (num > max) max = num;
            if (num < min) min = num;
        }
        
        double average = (double) sum / arr.length;
        
        System.out.println("Сумма элементов: " + sum);
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);
        System.out.println("Среднее значение: " + String.format("%.2f", average));
        System.out.println("Длина массива: " + arr.length);
    }
    
    // Функция для копирования массива
    public static int[] copyArray(int[] original) {
        return Arrays.copyOf(original, original.length);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== ПРОГРАММА ДЛЯ РАБОТЫ С МАССИВАМИ В JAVA ===");
        System.out.println();
        
        // Статический массив
        System.out.println("1. Статический массив:");
        int[] staticArray = {5, 2, 8, 1, 9, 3, 7};
        printArray(staticArray, "Исходный массив:");
        
        // Сортировка
        Arrays.sort(staticArray);
        printArray(staticArray, "Отсортированный массив:");
        
        // Поиск элемента
        int searchValue = 8;
        int index = findElement(staticArray, searchValue);
        if (index != -1) {
            System.out.println("Элемент " + searchValue + " найден на позиции " + index);
        } else {
            System.out.println("Элемент " + searchValue + " не найден");
        }
        
        // Статистика
        arrayStats(staticArray);
        
        System.out.println();
        
        // Динамический массив (пользовательский ввод)
        System.out.println("2. Динамический массив:");
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        
        if (size <= 0) {
            System.out.println("Неверный размер массива!");
            scanner.close();
            return;
        }
        
        int[] dynamicArray = new int[size];
        
        System.out.println("Введите " + size + " элементов:");
        for (int i = 0; i < size; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            dynamicArray[i] = scanner.nextInt();
        }
        
        printArray(dynamicArray, "Введенный массив:");
        arrayStats(dynamicArray);
        
        // Копирование массива
        int[] copiedArray = copyArray(dynamicArray);
        copiedArray[0] = 999; // Изменяем копию
        printArray(dynamicArray, "Оригинальный массив:");
        printArray(copiedArray, "Измененная копия:");
        
        System.out.println();
        
        // Многомерный массив
        System.out.println("3. Многомерный массив:");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Двумерный массив:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Сумма элементов матрицы
        int matrixSum = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                matrixSum += num;
            }
        }
        System.out.println("Сумма элементов матрицы: " + matrixSum);
        
        scanner.close();
    }
}
Работа со списками на ЯП Java 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    
    // Функция для вывода списка
    public static void printList(List<Integer> list, String message) {
        System.out.print(message + " ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Размер: " + list.size());
    }
    
    // Функция для поиска элемента в списке
    public static int findInList(List<Integer> list, int target) {
        return list.indexOf(target);
    }
    
    // Функция для удаления всех вхождений элемента
    public static void removeAllOccurrences(List<Integer> list, int value) {
        list.removeIf(n -> n == value);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== ПРОГРАММА ДЛЯ РАБОТЫ СО СПИСКАМИ В JAVA ===");
        System.out.println();
        
        // Создание ArrayList
        List<Integer> arrayList = new ArrayList<>();
        
        System.out.println("1. Добавление элементов:");
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(2, 25); // Вставка по индексу
        printList(arrayList, "После добавления элементов:");
        
        // Добавление в начало
        arrayList.add(0, 5);
        printList(arrayList, "После добавления в начало:");
        
        System.out.println();
        System.out.println("2. Доступ к элементам:");
        System.out.println("Первый элемент: " + arrayList.get(0));
        System.out.println("Последний элемент: " + arrayList.get(arrayList.size() - 1));
        System.out.println("Элемент на позиции 3: " + arrayList.get(3));
        
        System.out.println();
        System.out.println("3. Поиск элементов:");
        int[] searchValues = {25, 50, 10};
        for (int value : searchValues) {
            int position = findInList(arrayList, value);
            if (position != -1) {
                System.out.println("Элемент " + value + " найден на позиции " + position);
            } else {
                System.out.println("Элемент " + value + " не найден");
            }
        }
        
        System.out.println();
        System.out.println("4. Сортировка списка:");
        Collections.sort(arrayList);
        printList(arrayList, "Отсортированный список:");
        
        System.out.println();
        System.out.println("5. Удаление элементов:");
        arrayList.remove(Integer.valueOf(25)); // Удаление по значению
        printList(arrayList, "После удаления 25:");
        
        arrayList.remove(0); // Удаление по индексу
        printList(arrayList, "После удаления первого элемента:");
        
        // Удаление всех четных чисел
        removeAllOccurrences(arrayList, 20);
        printList(arrayList, "После удаления всех вхождений 20:");
        
        System.out.println();
        System.out.println("6. Итерация по списку:");
        System.out.println("Итерация с помощью for-each:");
        for (Integer num : arrayList) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.println("Итерация с помощью Iterator:");
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        System.out.println();
        System.out.println("7. Проверка на пустоту и очистка:");
        System.out.println("Список пустой: " + arrayList.isEmpty());
        
        List<Integer> tempList = new ArrayList<>(arrayList);
        System.out.println("Временный список до очистки: " + tempList);
        tempList.clear();
        System.out.println("Временный список после очистки: " + tempList);
        System.out.println("Список пустой: " + tempList.isEmpty());
        
        System.out.println();
        System.out.println("8. Преобразование в массив:");
        Integer[] arrayFromList = arrayList.toArray(new Integer[0]);
        System.out.print("Массив из списка: ");
        for (int num : arrayFromList) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.println();
        System.out.println("9. Работа с подсписками:");
        // Добавим больше элементов для демонстрации
        for (int i = 50; i <= 70; i += 10) {
            arrayList.add(i);
        }
        printList(arrayList, "Расширенный список:");
        
        // Создание подсписка
        List<Integer> subList = arrayList.subList(2, 5);
        System.out.println("Подсписок (элементы 2-4): " + subList);
        
        System.out.println();
        System.out.println("10. Пользовательский ввод:");
        List<Integer> userList = new ArrayList<>();
        System.out.print("Сколько элементов добавить? ");
        int count = scanner.nextInt();
        
        System.out.println("Введите " + count + " чисел:");
        for (int i = 0; i < count; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            userList.add(scanner.nextInt());
        }
        
        System.out.println("Ваш список: " + userList);
        Collections.sort(userList);
        System.out.println("Отсортированный список: " + userList);
        
        scanner.close();
    }
}