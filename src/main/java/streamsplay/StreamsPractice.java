package streamsplay;

import java.util.stream.Stream;

public class StreamsPractice {
    public static void main(String[] args) {
        Stream.of(12, 9, 14, 17, 19, 9, 8, 10).count();
        Stream.of(12, 9, 14, 17, 19, 9, 8, 10).reduce(0, Integer::sum);
    }

}
