package generator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random random = new Random();

    @Override
    public List<Integer> generateNumbers(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> random.nextInt(1_000_000) + 1)
                .collect(Collectors.toList());
    }
}
