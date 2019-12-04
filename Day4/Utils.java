package Day4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Utils {
    protected static int[] toIntArr(int number) {
        List<Integer> list = new LinkedList<>();

        while (number > 0) {
            list.add(0, number % 10);
            number = number / 10;
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    protected static boolean isValid(int number) {
        int[] ints = toIntArr(number);
        int max = 0;
        boolean containsDouble = false;
        if (ints.length != 6) {
            return false;
        }

        for (int anInt : ints) {
            if (anInt < max) {
                return false;
            }
            containsDouble = containsDouble || anInt == max;

            max = anInt;
        }

        return containsDouble;
    }

    protected static boolean hasDoublePair(int number, int minDuplicates) {
        int[] ints = toIntArr(number);
        int[] frequencies = new int[10];

        for (int i : ints) {
            frequencies[i]++;
        }
        return Arrays.stream(frequencies).filter(i -> i == minDuplicates).count() >= 1;
    }


}
