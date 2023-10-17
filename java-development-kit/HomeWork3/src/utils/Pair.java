package utils;

/**
 * Обобщенный класс для хранения пары значений разных типов.
 */
public class Pair<T, E> {
    private T first;
    private E second;

    public Pair(T first, E second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair [first=" + getFirst() + ", second=" + getSecond() + "]";
    }
}
