package processor;

import java.util.List;

public class SpecialNumberSummator implements NumberProcessor {

    @Override
    public Integer process(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 500_000)
                .mapToInt(n -> n * 5 - 150)
                .sum();
    }
}
