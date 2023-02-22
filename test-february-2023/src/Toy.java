public class Toy implements Comparable<Toy> {

    private final int toyID;
    private final String toyName;
    private final int toyFreqFall;

    public Toy(int toyID, String toyName, int toyFreqFall) {
        this.toyID = toyID;
        this.toyName = toyName;
        this.toyFreqFall = toyFreqFall;
    }

    public int getToyFreqFall() {
        return toyFreqFall;
    }

    public String toString() {
        return String.join(",", String.valueOf(this.toyID), this.toyName, String.valueOf(this.toyFreqFall));
    }

    @Override
    public int compareTo(Toy other) {
        return Integer.compare(this.toyFreqFall, other.toyFreqFall);
    }
}
