public class WaveAlgo {

    /**
     * Принимаем step в качестве аргумента. Сканируем массив циклом for и если
     * находим число равное кол-ву step проверяем окружающие ячейки:
     * - содержат ли они числа
     * - являются ли они границами лабиринта
     * Записываем step + 1 в такие ячейки
     */
    private static void makeStep(int[][] maze, int[][] mazeTmp, int step) {

        int lenRow = mazeTmp.length - 1;
        int lenCol = mazeTmp[0].length - 1;

        for (int i = 1; i < lenRow; i++) {
            for (int j = 1; j < lenCol; j++) {
                if (mazeTmp[i][j] == step) {
                    if (mazeTmp[i - 1][j] == 0 && maze[i - 1][j] == 0) {
                        mazeTmp[i - 1][j] = step + 1;
                    }
                    if (mazeTmp[i][j - 1] == 0 && maze[i][j - 1] == 0) {
                        mazeTmp[i][j - 1] = step + 1;
                    }
                    if (mazeTmp[i + 1][j] == 0 && maze[i + 1][j] == 0) {
                        mazeTmp[i + 1][j] = step + 1;
                    }
                    if (mazeTmp[i][j + 1] == 0 && maze[i][j + 1] == 0) {
                        mazeTmp[i][j + 1] = step + 1;
                    }
                }
            }
        }
    }

    /**
     * Считаем количество шагов
     */
    public static void countSteps(int[][] maze, int[][] mazeTmp) {

        int step = 0;
        int lenRow = mazeTmp.length - 2;
        int lenCol = mazeTmp[0].length - 2;

        for (int i = 1; i <= lenRow; i++) {
            for (int j = 1; j <= lenCol; j++) {
                if (mazeTmp[lenRow][lenCol] == 0) {
                    step += 1;
                    makeStep(maze, mazeTmp, step);
                }
            }
        }
    }

    /**
     * Ищем кратчайший путь выхода из лабиринта. Обозначаем точку выхода переменной finish
     * Ищем соседний элемент со значением finish - 1, переходим в эту ячейку, уменьшаем finish на 1
     * Повторяем предыдущий шаг, пока не дойдем до исходной точки, а именно finish = 1
     * Выводим в консоль координаты каждого шага от исходной точки до точки выхода
     */
    public static String findShortWay(int[][] mazeTmp) {

        int i = mazeTmp.length - 2;
        int j = mazeTmp.length - 2;
        int finish = mazeTmp[i][j];
        String path = ("(" + i + ", " + j + ") " + "Выход" + "\n");

        while (finish > 1) {
            if (mazeTmp[i - 1][j] == finish - 1) {
                i = i - 1;
                path += ("(" + i + ", " + j + ")" + "\t" + "Вниз" + "\n");
                finish -= 1;
            } else if (mazeTmp[i][j - 1] == finish - 1) {
                j = j - 1;
                path += ("(" + i + ", " + j + ")" + "\t" + "Вправо" + "\n");
                finish -= 1;
            } else if (mazeTmp[i + 1][j] == finish - 1) {
                i = i + 1;
                path += ("(" + i + ", " + j + ")" + "\t" + "Вверх" + "\n");
                finish -= 1;
            } else if (mazeTmp[i][j + 1] == finish - 1) {
                j = j + 1;
                path += ("(" + i + ", " + j + ")" + "\t" + "Влево" + "\n");
                finish -= 1;
            }
        }
        return path;
    }

    public static void printPath(int[][] mazeTmp) {

        String[] split = findShortWay(mazeTmp).split("\n");

        for (int i = split.length - 1; i >= 0; i--) {
            System.out.println(split[i] + " ");
        }
    }
}