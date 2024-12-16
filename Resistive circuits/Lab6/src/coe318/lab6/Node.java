package coe318.lab6;
public class Node {
    private int id;
    private static int next_id = 0;  // Static variable to track the next node id

    // Constructor
    public Node() {
        this.id = next_id++;
    }

    // toString method to return the id as a string
    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
