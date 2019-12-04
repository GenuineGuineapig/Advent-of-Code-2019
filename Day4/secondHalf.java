package Day4;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class secondHalf {

    public static void main(String[] args) {
        long count = IntStream.rangeClosed(109165, 576723)
                .filter(Utils::isValid)
                .filter(i -> Utils.hasDoublePair(i, 2))
                .count();

        System.out.println("Different passwords: " + count);
    }

}
