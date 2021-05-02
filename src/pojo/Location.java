package pojo;

public class Location implements Comparable<Location> {

    private final Long lineOffset;
    private final Integer charOffset;

    public Location(Long lineOffset, Integer charOffset) {
        this.lineOffset = lineOffset;
        this.charOffset = charOffset;
    }

    @Override
    public String toString() {
        return "[lineOffset=" + lineOffset +
                ", charOffset=" + charOffset +
                ']';
    }

    @Override
    public int compareTo(Location o) {
        int lineComparing = this.lineOffset.compareTo(o.lineOffset);
        int charComparing = this.charOffset.compareTo(o.charOffset);

        return lineComparing == 0 ? charComparing : lineComparing;
    }
}
