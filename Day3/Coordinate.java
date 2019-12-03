package Day3;

import java.util.Objects;

class Coordinate {
    public final int x;
    public final int y;
    public final Wire w;

    Coordinate(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w == 2 ? Wire.BOTH : w == 0 ? Wire.BLUE : Wire.RED;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coordinate{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
