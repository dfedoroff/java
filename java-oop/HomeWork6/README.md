# ООП. ООП Дизайн и SOLID. Семинар 6. Домашнее задание

Каталоги и файлы                                           | Описание
-----------------------------------------------------------|-----------------------------------------------------
`/java-oop/HomeWork6`                                      | Каталог файлов домашнего задания
`/HomeWork6/src/Main.java`                                 | Точка входа в программу
`/HomeWork6/src/Controller.java`                           | Управляющий класс
`/HomeWork6/src/Classes/AbstractTypes/BaseBehaviour.java`  | Интерфейс `String getInfo()` и `void step()`
`/HomeWork6/src/Classes/AbstractTypes/BasicCharacter.java` | Суперкласс, содержащий конструктор класса, get() и set()
`/HomeWork6/src/Classes/AbstractTypes/Coordinates.java`    | Координаты персонажей на игровой доске
 методы, а также другие методы, необходимые для вывода информации о персонажах игры
`/HomeWork6/src/Classes/AbstractTypes/Squad.java`          | Взаимедействие персонажей на игровой доске
`/HomeWork6/src/Classes/AbstractTypes/Healers.java`        | Абстартактный класс `Монаха` и `Волшебника`
`/HomeWork6/src/Classes/AbstractTypes/Shooters.java`       | Абстартактный класс `Арбалетчика` и `Снайпера`
`/HomeWork6/src/Classes/AbstractTypes/Warriors.java`       | Абстартактный класс `Копейщика` и `Разбойника`
`/HomeWork6/src/GameBoard/AnsiColors.java`                 | Цвета раскраски в кодировке ANSI
`/HomeWork6/src/GameBoard/View.java`                       | Рисует игровую доску в консоли
`/HomeWork6/src/GameBoard/Board.java`                      | Передвижение персонажа на игровой доске
`/HomeWork6/src/GameBoard/Constants.java`                  | Данные для игровой доски
`/HomeWork6/src/GameBoard/Logger.java`                     | Ведение статистики персонажей
`/HomeWork6/src/Classes/Archer.java`                       | Класс персонажа `Арбалетчик`
`/HomeWork6/src/Classes/Farmer.java`                       | Класс персонажа `Крестьянин`
`/HomeWork6/src/Classes/Monk.java`                         | Класс персонажа `Монах`
`/HomeWork6/src/Classes/Outlaw.java`                       | Класс персонажа `Разбойник`
`/HomeWork6/src/Classes/Sniper.java`                       | Класс персонажа `Снайпер`
`/HomeWork6/src/Classes/Lancer.java`                       | Класс персонажа `Копейщик`
`/HomeWork6/src/Classes/Wizard.java`                       | Класс персонажа `Колдун`
`/HomeWork6/.gitignore`                                    | Файл для исключения из индексации Git файлов и папок
`/HomeWork6/README.md`                                     | Условие задачи

### Описание:

Изменить step магов.
1. Если у всех в группе здоровье выше `75%` - маг стреляет в противника. Вне зависимости от атаки, брони и расстояния повреждение равно силе магии.
2. Если у кого то в группе здоровье меньше `75%` - маг лечит.
3. Маг может возраждать, но у возраждённого всего одно здоровье!

Начало проекта находится по [ссылке](https://github.com/dfedoroff/java/tree/main/java-oop/HomeWork1).

