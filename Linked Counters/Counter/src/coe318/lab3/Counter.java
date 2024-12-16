/**
 *
 * @author Your Name
 */
package coe318.lab3;

public class Counter {
    // Instance variables
    private int mod;  // Maximum value before rolling over
    private Counter left_n;  // Left neighbor Counter
    private int num;     // Current num

    public Counter(int mod, Counter left) {
        this.mod = mod;
        this.left_n = left;
        this.num = 0;  // Initialize num to 0
    }

    /**
     * @return the mod
     */
    public int getMod() {
        return mod;
    }

    /**
     * Returns the Counter to the left attached to this
     * Counter. Returns null if there is no Counter
     * to the left.
     * @return the left_n
     */
    public Counter getLeft_n() {
        return left_n;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * Increment this counter. If it rolls over,
     * its left Counter is also incremented if it
     * exists.
     */
    public void increment() {
        num++;  // Increment the current num
        if (num >= mod) {  // Check for rollover
            num = 0;  // Reset to zero
            if (left_n != null) {  // If there's a left_n neighbor, increment it
                left_n.increment();
            }
        }
    }

    /** Return the count of this Counter combined
 with any Counter to its left_n.
     *
     * @return the count
     */
    public int getCount() {
        if (left_n == null) {
            return num;  // If no left_n neighbor, return the num
        } else {
            return num + (left_n.getCount() * mod);  // Add left_n neighbor's count
        }
    }

    /** Returns a String representation of the Counter's
 total count (including its left_n neighbour).
     * @return the String representation
     */
    @Override
    public String toString() {
        // DO NOT MODIFY THIS CODE
        return "" + getCount();
    }
}
