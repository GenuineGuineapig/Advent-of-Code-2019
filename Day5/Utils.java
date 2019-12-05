package Day5;

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

}
