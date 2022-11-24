# ООП. Принципы ООП: инкапсуляция, наследование, полиморфизм. Семинар 1. Домашнее задание

Каталоги и файлы                     | Описание
-------------------------------------|-------------------------------------------------------
`/java-oop/HomeWork1`                | Каталог файлов домашнего задания
`/HomeWork1/src/Main.java            | Точка входа в программу
`/HomeWork1/src/BasicCharacter.java` | Суперкласс, содержащий конструктор класса, get() и set() методы, а также другие методы, необходимые для вывода информации о персонажах игры
`/HomeWork1/.gitignore`              | Файл для исключения из индексации Git файлов и папок
`/HomeWork1/README.md`               | Условие задачи

### Описание:

Разработать иерархию классов персонажей описанных в таблице.

Провести анализ (абстракция) полей необходимых данных и перенести общие поля в базовый класс. Так же в базовом классе переопределить метод `toString()` для вывода подробной информации о персонаже.

Описать удобный конструктор базового класса и классов наследников так, чтобы необходимые параметры передавались вызовом пустого конструктора класса наследника.

В основном классе создать список и заполнить его экземплярами каждого нового класса. Вывести в консоль содержание списка переопределенным методом `toString()`.

Создать список из `50` персонажей, выбранных случайным числом, и статический метод выбирающий из списка только элементы конкретного персонажа, переданного в параметре класса, и выводящий их описание в консоль.
