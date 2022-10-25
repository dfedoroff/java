public class WaveAlgo {

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