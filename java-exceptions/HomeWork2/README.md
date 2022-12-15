# Исключения в программировании и их обработка. Исключения и их обработка. Семинар 2, Домашнее задание

Каталоги и файлы             | Описание
-----------------------------|-----------------------------------------------------
`/java-exceptions/HomeWork2` | Каталог файлов домашнего задания
`/HomeWork2/src/Task1.java`  | Решение задачи 1
`/HomeWork2/src/Task2.java`  | Решение задачи 2
`/HomeWork2/.gitignore`      | Файл для исключения из индексации Git файлов и папок
`/HomeWork2/README.md`       | Условия задач

## Задача 1

### Описание:

Реализуйте метод, который запрашивает у пользователя ввод дробного числа типа `float`, и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных. В этом задании не используем `try catch`. Пишем регулярное выражение и используем на строке метод `matches`.

## Задача 2

### Описание:

Если необходимо, исправьте данный код:

```java
try {
    int d = 0;
    double catchedRes1 = intArray[8] / d;
    System.out.println("catchedRes1 = " + catchedRes1);
} catch (ArithmeticException e) {
    System.out.println("Catching exception: " + e);
}
```

## Задача 3

### Описание:

Исправьте там, где требуется, следующий код:

```java
public static void main(String[] args) throws Exception {
    try {
        int a = 90;
        int b = 3;
        System.out.println(a / b);
        printSum(23, 234);
        int[] abc = { 1, 2 };
        abc[3] = 9;
    } catch (Throwable ex) {
        System.out.println("Что-то пошло не так...");
    } catch (NullPointerException ex) {
        System.out.println("Указатель не может указывать на null!");
    } catch (IndexOutOfBoundsException ex) {
        System.out.println("Массив выходит за пределы своего размера!");
    }
}

public static void printSum(Integer a, Integer b) throws FileNotFoundException {
    System.out.println(a + b);
}
```

## Задача 4

### Описание:

Разработайте программу, которая выбросит `Exception`, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя. `Try` быть не должно.

## Задача 5 (по желанию)

### Описание:

Придумайте структуру класса. Опишите класс в программе, создайте `json` с несколькими экземплярами. В программе с помощью `objectMapper` преобразуйте `json` в массив объектов.
implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0")


