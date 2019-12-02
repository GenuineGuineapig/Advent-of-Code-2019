package Day2;

import java.util.Arrays;

public class firstHalf {
    private static final String input = "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,5,19,23,2,9,23,27,1,6,27,31,1,31,9,35,2,35,10,39,1,5,39,43,2,43,9,47,1,5,47,51,1,51,5,55,1,55,9,59,2,59,13,63,1,63,9,67,1,9,67,71,2,71,10,75,1,75,6,79,2,10,79,83,1,5,83,87,2,87,10,91,1,91,5,95,1,6,95,99,2,99,13,103,1,103,6,107,1,107,5,111,2,6,111,115,1,115,13,119,1,119,2,123,1,5,123,0,99,2,0,14,0";
    private static int[] register;

    private static void add(int a, int b, int idx) {
        register[idx] = register[a] + register[b];
    }

    private static void multiply(int a, int b, int idx) {
        register[idx] = register[a] * register[b];
    }

    public static void main(String[] args) {
        register = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        // get it back to 1202 state
        register[1] = 12;
        register[2] = 2;

        for (int i = 0; i < register.length; i = i + 4) {
            switch (register[i]) {
                case 1:
                    add(register[i + 1], register[i + 2], register[i + 3]);
                    break;
                case 2:
                    multiply(register[i + 1], register[i + 2], register[i + 3]);
                    break;
                case 99:
                    System.out.println("Done! :-)");
                    System.out.println(register[0]);
                    return;
                default:
                    System.out.println("Something went wrong! :-( I read: " + register[i]);
                    return;
            }
        }
    }
}
