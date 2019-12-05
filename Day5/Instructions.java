package Day5;

public enum Instructions {
    ADD,
    MULTIPLY,
    SAVE,
    OUT,
    JMP_IF_TRUE,
    JMP_IF_FALSE,
    LESS_THAN,
    EQUALS,
    STOP;

    protected static int getOffset(Instructions instructions) {
        switch (instructions) {
            case ADD:
            case MULTIPLY:
            case EQUALS:
            case LESS_THAN:
                return 4;
            case JMP_IF_TRUE:
            case JMP_IF_FALSE:
                return 3;
            case SAVE:
            case OUT:
                return 2;
            case STOP:
                return 0;
            default:
                throw new IllegalArgumentException("Command not found!");
        }
    }

    protected int getOffset() {
        return getOffset(this);
    }


}
