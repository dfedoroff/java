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
}