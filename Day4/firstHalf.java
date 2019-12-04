package Day4;

import java.util.stream.IntStream;

public class firstHalf {
    public static void main(String[] args) {
        long count = IntStream.rangeClosed(109165, 576723)
                .filter(Utils::isValid)
                .count();

        System.out.println("Different passwords: " + count);
    }
}
