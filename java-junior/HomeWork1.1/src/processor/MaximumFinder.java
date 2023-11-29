package processor;

import java.util.List;

public class MaximumFinder implements NumberProcessor {

    @Override
    public Integer process(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).orElse(null);
    }
}
