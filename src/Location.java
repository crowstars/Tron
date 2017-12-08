public class Location {
    //Location Copied from the Learn Java in N Games program Go
    /** @see #Location(int, int) */
    private int x;

    /** @see #Location(int, int) */
    private int y;

    /** y is zero-based from top, x zero-based from top. */
    public Location(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    /**
     * Returns the x of this location.
     *
     * @see #Location(int, int)
     */
    public int getx() {
        return x;
    }

    /** Returns an array of the four neighboring locations. */
    public Location[] getNeighbors() {
        return new Location[] {new Location(y - 1, x),
                new Location(y + 1, x),
                new Location(y, x - 1),
                new Location(y, x + 1)};
    }

    /**
     * Returns the y of this location.
     *
     * @see #Location(int, int)
     */
    public int gety() {
        return y;
    }

    public String toString(){
        return "" + y + ", " + x;
    }
}
