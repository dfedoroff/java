public class Main {
    public static void main(String[] args) {

        int[][] maze = new int[][] {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        /* Создаем временный массив для необходимых вычислений */
        int start = 1;
        int[][] mazeTmp = new int[maze.length][maze[0].length];
        mazeTmp[start][start] = 1;

        System.out.println("Лабиринт:");
        WaveAlgo.printArray(maze);
        WaveAlgo.countSteps(maze, mazeTmp);
        System.out.println("Координаты кратчайшего пути выхода из лабиринта:");
        WaveAlgo.printPath(mazeTmp);
    }
}
