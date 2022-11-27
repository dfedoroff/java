# Коллекции JAVA: Введение. Факультет: Тестировщик. Семинар 3, Домашнее задание

Каталоги и файлы                      | Описание
--------------------------------------|-----------------------------------------------------
`/introduction-to-java-api/PhoneBook` | Каталог файлов задачи 3
`/PhoneBook/src/Main.java`            | Точка входа в программу
`/PhoneBook/src/PhoneBook.java`       | Добавляет и находит контакты в телефонном справочнике
`/PhoneBook/.gitignore`               | Файл для исключения из индексации Git файлов и папок
`/PhoneBook/README.md`                | Условие задачи

## Задача 3

### Описание:

Написать простой класс `PhoneBook` - Телефонный справочник, который хранит список фамилий контактов и их телефонные номера. В этот телефонный справочник с помощью метода `add()` можно добавлять записи, а с помощью метода `get()` искать номер телефона по фамилии. Следует учесть, что в случае однофамильцев в справочнике может быть несколько телефонов, а следовательно, при запросе такой фамилии должны выводиться все телефоны.

### Примечание:

Желательно как можно меньше добавлять своего, не указанного в задании. То есть в телефонную запись не нужно добавлять дополнительные поля (`имя`, `отчество`, `адрес`) или же делать взаимодействие с пользователем через консоль и т.п. Консоль желательно не использовать, в том числе `Scanner`, а тестировать все из метода `main()` прописывая методы `add()` и `get()`.
