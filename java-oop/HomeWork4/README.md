# ООП. Обобщения. Часть 1. Семинар 4. Домашнее задание

Каталоги и файлы                             | Описание
---------------------------------------------|-----------------------------------------------------
`/java-oop/HomeWork4`                        | Каталог файлов домашнего задания
`/HomeWork4/src/Main.java`                   | Точка входа в программу
`/HomeWork4/src/GameBoard/AnsiColors.java`   | Цвета раскраски в кодировке ANSI
`/HomeWork4/src/GameBoard/Board.java`        | Рисует игровую доску в консоли
`/HomeWork4/src/GameBoard/Constants.java`    | Данные для игровой доски
`/HomeWork3/src/Classes/BaseBehaviour.java`  | Интерфейс `String getInfo()` и `void step()`
`/HomeWork4/src/Classes/Coordinates.java`    | Координаты персонажей на игровой доске
`/HomeWork4/src/Classes/BasicCharacter.java` | Суперкласс, содержащий конструктор класса, get() и set() методы, а также другие методы, необходимые для вывода информации о персонажах игры
`/HomeWork4/src/Classes/Squad.java`          | Взаимедействие персонажей на игровой доске
`/HomeWork4/src/Classes/Archer.java`         | Класс персонажа `Арбалетчик`
`/HomeWork4/src/Classes/Farmer.java`         | Класс персонажа `Крестьянин`
`/HomeWork4/src/Classes/Monk.java`           | Класс персонажа `Монах`
`/HomeWork4/src/Classes/Outlaw.java`         | Класс персонажа `Разбойник`
`/HomeWork4/src/Classes/Sniper.java`         | Класс персонажа `Снайпер`
`/HomeWork4/src/Classes/Lancer.java`         | Класс персонажа `Копейщик`
`/HomeWork4/src/Classes/Wizard.java`         | Класс персонажа `Колдун`
`/HomeWork4/README.md`                       | Условие задачи

### Описание:

Переопределить метод `step` для стрелков. Поиск в своей группе крестьянина, если он жив и не занят, увеличить количество стрел на один а статус крестьянина на занят. Найти ближайшего противника и расчитать повреждение с учётом атаки, защиты и расстояния. Нанести повреждение и, если у противника жизней меньше нуля установить его статус `повержен`. Изменить порядок хода в группах. Сначала ход передаётся всем боевым юнитам обеих сторон, потом магам, а уже затем крестьянам.

Начало проекта находится по [ссылке](https://github.com/dfedoroff/java/tree/main/java-oop/HomeWork1).

