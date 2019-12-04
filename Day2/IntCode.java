package Day2;

class IntCode {
    private final int[] register;

    IntCode(int[] register, int noun, int verb) {
        this.register = register.clone();
        this.register[1] = noun;
        this.register[2] = verb;

        calculate();
    }

    private void add(int a, int b, int idx) {
        register[idx] = register[a] + register[b];
    }

    private void multiply(int a, int b, int idx) {
        register[idx] = register[a] * register[b];
    }

    private void calculate() {
        for (int i = 0; i < register.length; i = i + 4) {
            switch (register[i]) {
                case 1:
                    add(register[i + 1], register[i + 2], register[i + 3]);
                    break;
                case 2:
                    multiply(register[i + 1], register[i + 2], register[i + 3]);
                    break;
                case 99:
                    return;
                default:
                    System.out.println("Something went wrong! :-( I read: " + register[i]);
                    return;
            }
        }
    }

    public int getResult() {
        return register[0];
    }
}
