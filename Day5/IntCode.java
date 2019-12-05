package Day5;

import java.util.Arrays;
import java.util.Scanner;

class IntCode {
    private final int[] register;
    private int instPtr;

    IntCode(int[] register) {
        this.register = register.clone();
        this.instPtr = 0;
        calculate();
    }

    private void add(int a, int b, int idx) {
        this.register[idx] = a + b;
    }

    private void multiply(int a, int b, int idx) {
        this.register[idx] = a * b;
    }

    private void save(int a, int idx) {

        this.register[idx] = a;
    }

    private void output(int idx) {
        System.out.println("OUT :: " + this.register[idx]);
    }

    private void ifTrue(int a, int idx) {
        if (a != 0) {
            this.instPtr = idx;
        } else {
            this.instPtr += Instructions.getOffset(Instructions.JMP_IF_TRUE);
        }
    }

    private void ifFalse(int a, int idx) {
        if (a == 0) {
            this.instPtr = idx;
        } else {
            this.instPtr += Instructions.getOffset(Instructions.JMP_IF_FALSE);
        }
    }

    private void lessThan(int a, int b, int idx) {
        this.register[idx] = a < b ? 1 : 0;
    }

    private void equals(int a, int b, int idx) {
        this.register[idx] = a == b ? 1 : 0;
    }


    private int loadParam(int mode, int value) {
        if (mode == 0) { // position
            return this.register[this.register[value]];
        } else { //immediate
            return this.register[value];
        }
    }

    private int[] paddArr(int[] instructionParts) {
        int instructionLength = 5;

        if (instructionParts.length == instructionLength) {
            return instructionParts;
        }

        int[] newInstructionParts = new int[instructionLength];
        int offset = instructionLength - instructionParts.length;

        for (int i = 0; i < instructionParts.length; i++) {
            if (i + offset >= instructionLength) {
                newInstructionParts[i] = 0;
            }
            newInstructionParts[i + offset] = instructionParts[i];
        }

        return newInstructionParts;
    }

    private Instructions readOpCode(int[] opCodeArr) {
        String opCode = opCodeArr[3] + "" + opCodeArr[4];
        switch (opCode) {
            case "01":
                return Instructions.ADD;
            case "02":
                return Instructions.MULTIPLY;
            case "03":
                return Instructions.SAVE;
            case "04":
                return Instructions.OUT;
            case "05":
                return Instructions.JMP_IF_TRUE;
            case "06":
                return Instructions.JMP_IF_FALSE;
            case "07":
                return Instructions.LESS_THAN;
            case "08":
                return Instructions.EQUALS;
            case "99":
                return Instructions.STOP;
            default:
                System.out.println("Dump @ " + this.instPtr + ":" + this.register[this.instPtr] + " :: " + Arrays.toString(this.register));
                throw new IllegalArgumentException("Could not parse Opcode! " + opCode + " recieved: " + Arrays.toString(opCodeArr));
        }
    }

    private boolean parse() {
        int inst = this.register[this.instPtr];
        int[] instructionParts = Utils.toIntArr(inst);

        instructionParts = paddArr(instructionParts);
        System.out.println("Reading: " + Arrays.toString(instructionParts));
        Instructions opCode = readOpCode(instructionParts);

        switch (opCode) {
            case ADD:
                add(loadParam(instructionParts[2], this.instPtr + 1), loadParam(instructionParts[1], this.instPtr + 2), register[this.instPtr + 3]);
                break;
            case MULTIPLY:
                multiply(loadParam(instructionParts[2], this.instPtr + 1), loadParam(instructionParts[1], this.instPtr + 2), register[this.instPtr + 3]);
                break;
            case SAVE:
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter input:");
                save(5, loadParam(sc.nextInt(), this.instPtr + 1));
                break;
            case OUT:
                output(this.register[this.instPtr + 1]);
                break;
            case JMP_IF_TRUE:
                ifTrue(loadParam(instructionParts[2], this.instPtr + 1), loadParam(instructionParts[1], this.instPtr + 2));
                break;
            case JMP_IF_FALSE:
                ifFalse(loadParam(instructionParts[2], this.instPtr + 1), loadParam(instructionParts[1], this.instPtr + 2));
                break;
            case LESS_THAN:
                lessThan(loadParam(instructionParts[2], this.instPtr + 1), loadParam(instructionParts[1], this.instPtr + 2), register[this.instPtr + 3]);
                break;
            case EQUALS:
                equals(loadParam(instructionParts[2], this.instPtr + 1), loadParam(instructionParts[1], this.instPtr + 2), register[this.instPtr + 3]);
                break;
            case STOP:
                return false;
        }
        if (opCode != Instructions.JMP_IF_FALSE && opCode != Instructions.JMP_IF_TRUE) {
            this.instPtr += opCode.getOffset();
        }
        return true;
    }

    private void calculate() {
        while (parse()) {
        }
        System.out.println("Stopped.");
    }

}
