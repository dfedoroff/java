package processor;

import java.util.List;

public class SquareLessCounter implements NumberProcessor {

    @Override
    public Integer process(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(n -> n * n < 100_000)
                .count();
    }
}
