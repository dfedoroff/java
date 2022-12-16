package GameBoard;

import Classes.AbstractTypes.Coordinates;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DirectionSeeker {

    private final Coordinates start;
    private final Coordinates finish;
    private final LinkedHashMap<String, Coordinates> prevPoints = new LinkedHashMap<>();

    public DirectionSeeker(Coordinates start, Coordinates finish) {

        this.start = start;
        this.finish = finish;
    }

    public int calcDistance() {

        ArrayList<Coordinates> oldFront = new ArrayList<>();
        ArrayList<Coordinates> newFront = new ArrayList<>();
        int[][] dist = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        int currentDist = 0;

        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                dist[i][j] = Board.isFree(i, j) ? Integer.MAX_VALUE : -1;
            }
        }

        oldFront.add(start);
        dist[start.getX()][start.getY()] = 0;
        dist[finish.getX()][finish.getY()] = 0;

        while (true) {
            currentDist++;
            for (Coordinates p : oldFront) {
                for (int[] dir : directions) {
                    int newX = p.getX() + dir[0];
                    int newY = p.getY() + dir[1];
                    Coordinates newPoint = new Coordinates(newX, newY);

                    if (newPoint.isEqual(finish)) {
                        prevPoints.put(newPoint.toString(), p);
                        return currentDist;
                    } else if
                        (newX < 0 || newX >= Constants.BOARD_SIZE || newY < 0 || newY >= Constants.BOARD_SIZE // if out of border
                                  || dist[newX][newY] <= currentDist) {
                        continue;
                    }

                    dist[newX][newY] = currentDist;
                    prevPoints.put(newPoint.toString(), p);
                    newFront.add(newPoint);
                }
            }

            if (newFront.isEmpty()) return -1;
            oldFront = new ArrayList<>(newFront);
            newFront.clear();
        }
    }


    public Coordinates getFreeCellCloserToEnemy() {

        if (!prevPoints.containsKey(finish.toString())) {
            return null;
        }

        Coordinates lastPoint = finish;
        ArrayList<Coordinates> path = new ArrayList<>();

        while (!lastPoint.equals(start)) {
            path.add(lastPoint);
            lastPoint = prevPoints.get(lastPoint.toString());
        }
        path.add(start);
        return path.get(path.size() - 2);
    }
}
